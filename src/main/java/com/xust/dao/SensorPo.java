package com.xust.dao;

import lombok.*;

/**
 * Created by 10045 on 2018/5/28.
 */
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorPo {
    private String callback;
    private String id;
    private String name;
    private int num;
    private String model;
    private String type;
    private String unit;
}
