package com.ljw.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenUserInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
    private Integer id;
    private String role;

}
