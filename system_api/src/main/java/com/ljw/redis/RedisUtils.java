package com.ljw.redis;

import org.slf4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils<V> {
    @Resource
    private RedisTemplate<String, V> redisTemplate;

    private static final Logger Logger = org.slf4j.LoggerFactory.getLogger(RedisUtils.class);

    /**
     * 删除给定的Redis键
     * @param key 要删除的键，可以是单个键名字符串，也可以是多个键名字符串
     */
    public void delete(String ... key){
        if(key != null && key.length > 0){
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(java.util.Arrays.asList(key));
            }
        }
    }

    /**
     * 在Redis中设置键值对
     * @param key 键名
     * @param value 键值
     * @return 如果设置成功返回true，否则返回false
     */
    public boolean set(String key, V value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            Logger.error("redis set key:{},value：{} error", key, value);
            return false;
        }
    }

    /**
     * 根据键名获取Redis中的值
     * @param key 键名
     * @return 对应的键值，如果键不存在或参数为null则返回null
     */
    public V get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 在Redis中设置键值对，并为键设置过期时间
     * @param key 键名
     * @param value 键值
     * @param time 键的过期时间（以分钟为单位）
     * @return 如果设置成功返回true，否则返回false
     */
    public boolean setex(String key, V value, long time){
        try {
            if(time > 0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            Logger.error("redis setex key:{},value：{} error", key, value);
            return false;
        }
    }

    /**
     * 为给定的键设置过期时间
     * @param key 键名
     * @param time 过期时间（以分钟为单位）
     * @return 如果设置成功返回true，否则返回false
     */
    public boolean expire(String key, long time){
        try {
            if(time > 0){
                redisTemplate.expire(key, time, TimeUnit.MINUTES);
            }
            return true;
        } catch (Exception e) {
            Logger.error("redis expire key:{},value：{} error", key, time);
            return false;
        }
    }

    /**
     * 获取Redis列表类型的键的全部内容
     * @param key 列表类型的键名
     * @return 列表内容，如果键不存在或参数为null则返回空列表
     */
    public List<V> getQueueList(String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 在Redis列表类型的键的左侧推送值
     * @param key 列表类型的键名
     * @param value 要推送的值
     * @param time 列表的过期时间（以分钟为单位）
     * @return 如果操作成功返回true，否则返回false
     */
    public boolean lpush(String key, V value, Long time){
        try {
            redisTemplate.opsForList().leftPush(key, value);
            if(time > 0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            Logger.error("redis lpush key:{},value：{} error", key, value);
            return false;
        }
    }

    /**
     * 从Redis列表类型的键中移除指定的值
     * @param key 列表类型的键名
     * @param value 要移除的值
     * @return 移除的值的数量，如果操作失败或键不存在则返回0
     */
    public long remove(String key, V value){
        try {
            Long remove = redisTemplate.opsForList().remove(key, 1, value);
            return remove;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将多个值推送到Redis列表类型的键的左侧
     * @param key 列表类型的键名
     * @param values 要推送的值列表
     * @param time 列表的过期时间（以分钟为单位）
     * @return 如果操作成功返回true，否则返回false
     */
    public boolean lpushAll(String key, List<V> values, Long time){
        try {
            redisTemplate.opsForList().leftPushAll(key, values);
            if(time > 0){
                expire(key, time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
