package com.ljw.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DATE: 2025/3/22
 * Author: lizhiyu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateCountVO {
    private String date;
    private Integer count;

    public void setDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(date);
    }
}
