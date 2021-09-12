package com.luo.demo.openfeign.server.domain.param;

/**
 * 修改用户 - 参数
 *
 * @author luohq
 * @date 2021-09-11 16:24
 */
public class UserUpdateParam extends UserBaseParam {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserUpdateParam{" +
                "super=" + super.toString() + ',' +
                "id=" + id +
                '}';
    }
}
