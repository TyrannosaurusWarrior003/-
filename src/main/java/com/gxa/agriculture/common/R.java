package com.gxa.agriculture.common;

import lombok.Data;

import java.util.List;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param
 */
@Data
public class R<T> {

    public Integer code; //编码：1成功，0和其它数字为失败

    public String msg; //错误信息

    public T data; //数据

    public Long total; //数据总条数

    public List<T> records; //返回前端的数据集合

    //public Map map = new HashMap(); //动态数据

    //重用
    public static <T> R<T> success() {
        R<T> r = new R<T>();
        r.setCode(200);
        r.setMsg("success");
        return r;
    }

    public static <T> R<T> success(T data) {
        R<T> r = success();
        r.setData(data);
        return r;
    }

    //封装返回给前端的数据
    public static <T> R<T> success(Long total, List<T> records) {
        R<T> r = success();
        r.setTotal(total);
        r.setRecords(records);
        return r;
    }




    public static <T> R<T> error() {
        R<T> r = new R<T>();
        r.setCode(0);
        r.setMsg("failed");
        return r;
    }

    /*public static <T> R<T> error(T data) {
        R<T> r = error();
        r.setData(data);
        return r;
    }*/
    public static <T> R<T> error(String msg) {
        R<T> r = new R<T>();
        r.setCode(0);
        r.setMsg(msg);
        return r;
    }


    public static <T> R<T> error(Integer code,String msg) {
        R<T> r = new R<T>();
        r.setCode(code);
        r.setMsg(msg);

        return r;
    }

}
