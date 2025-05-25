package com.ljw.utils;

import com.ljw.constants.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
    /**
     * 生成随机数
     *
     * @param count
     * @return
     */
    public static final String getRandomNumber(Integer count) {
        return RandomStringUtils.random(count, false, true);
    }

    /**
     * 生成随机字符串
     *
     * @param count
     * @return
     */
    public static final String getRandomString(Integer count) {
        return RandomStringUtils.random(count, true, true);
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0 || "null".equalsIgnoreCase(str) || "".equals(str) || "\u0000".equals(str)) {
            return true;
        }
        return false;
    }

    public static String encodeByMd5(String orginString) {
        return isEmpty(orginString) ? null : DigestUtils.md5Hex(orginString);
    }

    public static boolean pathIsOk(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return true;
        }
        // 检查路径中是否包含尝试访问父目录的模式
        if (filePath.contains("../") || filePath.contains("..\\")) {
            return false;
        }
        return true;
    }


    public static String rename(String fileName) {
        String fileNameNoSuffix = getFileNameNoSuffix(fileName);
        String fileSuffix = getFileSuffix(fileName);
        return fileNameNoSuffix + "_" + getRandomNumber(Constants.LENGTH_5) + fileSuffix;
    }

    public static String getFileNameNoSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index == -1) {
            return fileName;
        }
        return fileName.substring(0, index);
    }

    public static String getFileSuffix(String fileName) {
        if(isEmpty(fileName)){
            return null;
        }
        int index = fileName.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        return fileName.substring(index);
    }

    public static String getUserId() {
        return "U" + getRandomNumber(Constants.LENGTH_11);
    }

    public static String getGroupId() {
        return "G" + getRandomNumber(Constants.LENGTH_11);
    }

    public static String cleanHtmlTag(String content) {
        if (isEmpty(content)) {
            return content;
        }
        content = content.replaceAll("<", "&lt");
        content = content.replaceAll("\r\n", "<br>");
        content = content.replaceAll("\n", "<br>");
        return content;
    }

    public static String getChatSessionId4User(String[] userIds) {
        /**
         * 要获取唯一且不重复的sessionId，并且删好友后，重新加回来，依旧是这个sessionId
         * 由于用户Id始终不变，例如：张三（U123456789） 李四（U987654321）
         * 将他们两的Id加起来，排序后，得到：123456789 + 987654321
         * 再进行md5格式化，这样所有id的长度都相同 MD5(U123456789 + U987654321)
         * 这样，这两个用户id就与这个sessionId强绑定了
         * 如果是群组，则直接将群号md5即可
         */
        Arrays.sort(userIds);
        return encodeByMd5(userIds[0] + userIds[1]);
    }

    public static String getChatSessionId4Group(String groupId) {
        return encodeByMd5(groupId);
    }

    public static boolean isNumber(String str){
        String checkNumber = "^[0-9]+$";
        if(null == str){
            return false;
        }
        if(str.matches(checkNumber)){
            return true;
        }
        return false;
    }
    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects)
    {
        return !isEmpty(Arrays.toString(objects));
    }
}
