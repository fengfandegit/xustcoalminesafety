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
    private String callback;
    private String id;
    private String name;
    private int air_intake;
    private int air_velocity;
    private int coal_seam;
    private String geological_structure;
    private int design_production_capacity;
    private int verification_production_capacity;
    private int wasixiangduiyongchuliang;
    private double meicengyuanshiwasihanliang;
    private double wasifangsanchusudu;
    private double meicengtouqixingxishu;
    private double wasijueduiyongchuliang;
    private double meicengyuanshiwasiyali;
    private double meicengpohuaileixing;
}
