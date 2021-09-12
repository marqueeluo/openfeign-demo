package com.luo.demo.openfeign.server.domain.param;

import java.time.LocalDate;

/**
 * 查找用户 - 参数
 *
 * @author luohq
 * @date 2021-09-11 16:25
 */
public class UserSearchParam {
    private String name;
    private Integer sex;
    private LocalDate bornDateStart;
    private LocalDate bornDateEnd;
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

    public LocalDate getBornDateStart() {
        return bornDateStart;
    }

    public void setBornDateStart(LocalDate bornDateStart) {
        this.bornDateStart = bornDateStart;
    }

    public LocalDate getBornDateEnd() {
        return bornDateEnd;
    }

    public void setBornDateEnd(LocalDate bornDateEnd) {
        this.bornDateEnd = bornDateEnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserAddParam{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", bornDateStart=" + bornDateStart +
                ", bornDateEnd=" + bornDateEnd +
                ", phone='" + phone + '\'' +
                '}';
    }
}
