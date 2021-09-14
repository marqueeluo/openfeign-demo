package com.luo.demo.openfeign.server.domain.param;

/**
 * 组织 - 基础参数
 *
 * @author luohq
 * @date 2021-09-14 19:39
 */
public class OrgBaseParam {
    private Long parentOrgId;
    private String name;

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrgBaseParam{" +
                "parentOrgId=" + parentOrgId +
                ", name='" + name + '\'' +
                '}';
    }
}
