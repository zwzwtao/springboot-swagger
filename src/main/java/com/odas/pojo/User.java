package com.odas.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// @ApiModel是对这个类的说明
@ApiModel("用户实体类")
public class User {

    // @ApiModelProperty是对类属性的说明，如果是私有属性，需要加get,set方法才能显示在swagger
    // 里，如果是public属性，则不用get,set方法
    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("用户密码")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
