package com.trkj.thirdproject.exception;

public enum CustomErrorType {
    USER_INPUT_ERROR(400,"用户输入异常"),
    SYSTEM_ERROR (500,"系统服务异常"),
    OTHER_ERROR(999,"其他未知异常"),
    ACCOUNT_ERROR(600,"账户异常"),
    PAGE_NOT_FOUND_ERROR(404,"无法找到对应的资源"),
    SIGNATURE_ERROR(700,"签名异常");
    CustomErrorType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }
    //异常类型中文描述
    private String typeDesc;
    //异常code
    private int code;

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getCode() {
        return code;
    }
}