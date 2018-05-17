package com.xust.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by lenovo on 2018/5/14.
 *
 * @Test by fengfan
 */
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String phonename;
    private String password;
    private String realname;
    private String workid;
    private int power;
    private String groupid;
    private String salt;
}
