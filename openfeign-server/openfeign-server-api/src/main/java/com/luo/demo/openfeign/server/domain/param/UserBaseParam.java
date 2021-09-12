package com.luo.demo.openfeign.server.domain.param;

import java.time.LocalDate;

/**
 * 用户 - 基础参数
 *
 * @author luohq
 * @date 2021-09-11 16:25
 */
public class UserBaseParam {
    private String name;
    private Integer sex;
    private LocalDate bornDate;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserSearchParam{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", bornDate=" + bornDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
