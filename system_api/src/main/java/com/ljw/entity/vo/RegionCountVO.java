package com.ljw.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DATE: 2025/3/23
 * Author: lizhiyu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionCountVO {
    private String province;
    private Integer count;
    private String percentage;
}
