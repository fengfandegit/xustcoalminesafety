package com.xust.dao;

import lombok.*;

/**
 * Created by 10045 on 2018/5/27.
 */
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationPo {
    private String callback;
    private String id;
    private Double diameter;
    private Double spacing;
    private String coordinate;
    private String position2;
    private int angle;
    private Double depth;
    private Double extraction_rate;
    private Double extraction_num;
    private int time;
    private Double concentration_assessment;
    private Double extraction_rate_assessment;
    private Double extraction_num_assessment;
    private int comprehensive_evaluation;
    private Double add_press;
    private int add_time;
    private Double add_radius;
    private Double add_power;
    private Double distance;
    private Double wind_num;
}
