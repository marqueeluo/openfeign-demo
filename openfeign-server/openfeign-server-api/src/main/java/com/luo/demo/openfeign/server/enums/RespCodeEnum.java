package com.luo.demo.openfeign.server.enums;

import java.util.stream.Stream;

/**
 * 响应码 - 枚举
 *
 * @author luohq
 * @date 2021-09-11
 */
public enum RespCodeEnum {
    SUCCESS(100, "成功"),
    PARAM_INVALID(101, "参数格式异常"),
    FAILED(200, "系统异常"),
    THIRD_PARTY_FAILED(300, "第三方系统错误");
    private Integer code;
    private String desc;

    RespCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Boolean equalCode(Integer respCode) {
        return this.getCode().equals(respCode);
    }

    public static RespCodeEnum valueOf(Integer respCode) {
        return Stream.of(values())
                .filter(respCodeEnum -> respCodeEnum.getCode().equals(respCode))
                .findFirst()
                .orElse(null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
