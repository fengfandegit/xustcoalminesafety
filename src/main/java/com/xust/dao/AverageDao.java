package com.xust.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by lenovo on 2018/5/30.
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AverageDao {
    private Double values;
    private String date;
    private boolean alarm;
    private String starttime;
    private String endtime;
}
