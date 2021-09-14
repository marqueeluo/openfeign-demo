package com.luo.demo.openfeign.server.domain.param;

/**
 * 修改组织 - 参数
 *
 * @author luohq
 * @date 2021-09-14 19:44
 */
public class OrgUpdateParam extends OrgBaseParam {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrgUpdateParam{" +
                "super=" + super.toString() + "," +
                "id=" + id +
                '}';
    }
}
