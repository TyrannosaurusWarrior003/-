//package bak;
//
//import lombok.Data;
//
///**
// * 通用返回结果，服务端响应的数据最终都会封装成此对象
// * @param
// */
//@Data
//public class R {
//
//    public Integer code; //编码：1成功，0和其它数字为失败
//
//    public String msg; //错误信息
//
//    public Object data; //数据
//
//    //public Map map = new HashMap(); //动态数据
//
//    //重用
//    public static R success() {
//        R r = new R();
//        r.setCode(200);
//        r.setMsg("success");
//        return r;
//    }
//
//    public static R success(Object data) {
//        R r = success();
//        r.setData(data);
//        return r;
//    }
//
//    public static R error() {
//        R r = new R();
//        r.setCode(0);
//        r.setMsg("failed");
//        return r;
//    }
//
//    public static R error(String msg) {
//        R r = new R();
//        r.setCode(0);
//        r.setMsg(msg);
//        return r;
//    }
//
//}
