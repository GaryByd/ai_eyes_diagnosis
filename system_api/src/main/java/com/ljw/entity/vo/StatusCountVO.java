package com.ljw.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DATE: 2025/3/22
 * Author: lizhiyu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusCountVO {
    private String status;
    private Integer count;
    private String percentage;
}
