package com.ljw.redis;

import com.ljw.constants.Constants;
import com.ljw.entity.dto.TokenUserInfoDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisComponent {

    @Resource
    private RedisUtils redisUtils;
    
    public void saveTokenUserInfoDTO(TokenUserInfoDTO tokenUserInfoDTO){
        redisUtils.setex(Constants.REDIS_TOKEN_KEY + tokenUserInfoDTO.getToken(), tokenUserInfoDTO, Constants.REDIS_TIME_EXPIRE_DAY * 2);
        redisUtils.setex(Constants.REDIS_TOKEN_ID + tokenUserInfoDTO.getId(), tokenUserInfoDTO.getToken(), Constants.REDIS_TIME_EXPIRE_DAY * 2);
    }

    public TokenUserInfoDTO getTokenUserInfoDTO(String token) {
        TokenUserInfoDTO tokenUserInfoDTO = (TokenUserInfoDTO) redisUtils.get(Constants.REDIS_TOKEN_KEY + token);
        return tokenUserInfoDTO;
    }

//    public SysSettingDto getSysSettingDto(){
//        SysSettingDto sysSettingDto = (SysSettingDto) redisUtils.get(Constants.REDIS_KEY_SYS_SETTING);
//        return sysSettingDto == null ? new SysSettingDto() : sysSettingDto;
//    }
//
//    public void saveSettingDto(SysSettingDto sysSettingDto){
//        redisUtils.set(Constants.REDIS_KEY_SYS_SETTING, sysSettingDto);
//    }


    public void cleanUserTokenByUserId(String id) {
        String token = (String) redisUtils.get(Constants.REDIS_TOKEN_ID + id);
        if(token == null)
            return;
        redisUtils.delete(Constants.REDIS_TOKEN_ID + token);
    }

    public TokenUserInfoDTO getTokenUserInfoDTOById(String id) {
        if(id == null){
            return null;
        }
        String token = (String) redisUtils.get(Constants.REDIS_TOKEN_ID + id);
        TokenUserInfoDTO tokenUserInfoDTO = (TokenUserInfoDTO) redisUtils.get(Constants.REDIS_TOKEN_KEY + token);
        return tokenUserInfoDTO;
    }

    /**
     * Get current user info from request token
     * @return TokenUserInfoDTO containing user information
     */


}
