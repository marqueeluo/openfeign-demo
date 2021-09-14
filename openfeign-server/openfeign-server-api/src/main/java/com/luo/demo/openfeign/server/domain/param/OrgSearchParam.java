package com.luo.demo.openfeign.server.domain.param;

import java.time.LocalDate;

/**
 * 组织 - 查询参数
 *
 * @author luohq
 * @date 2021-09-14 19:40
 */
public class OrgSearchParam {
    private Long id;
    private String name;
    private Long parentId;
    private LocalDate createDateStart;
    private LocalDate createDateEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public LocalDate getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(LocalDate createDateStart) {
        this.createDateStart = createDateStart;
    }

    public LocalDate getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(LocalDate createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    @Override
    public String toString() {
        return "OrgSearchParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", createDateStart=" + createDateStart +
                ", createDateEnd=" + createDateEnd +
                '}';
    }
}
