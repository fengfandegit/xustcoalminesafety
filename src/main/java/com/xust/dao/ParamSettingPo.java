package com.xust.dao;

import lombok.*;

/**
 * Created by 10045 on 2018/5/22.
 */
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamSettingPo {
    private String id;
    private String name;
    private int airIntake;
    private int airVelocity;
    private int coalSeam;
    private String geologicalStructure;
    private int designProductionCapacity;
    private int verificationProductionCapacity;
}
