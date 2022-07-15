package com.example.spider.dal.result;

import java.util.StringJoiner;

public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <S> Result<S> of(S data) {
        return new Result<S>().setCode(200).setMessage("请求成功").setData(data);
    }

    public static <S> Result<S> fail(int code, String message) {
        return new Result<S>().setCode(code).setMessage(message).setData(null);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Result.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("message='" + message + "'")
                .add("data=" + data)
                .toString();
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
