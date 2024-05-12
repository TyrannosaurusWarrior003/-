package com.gxa.agriculture.util;

import com.gxa.agriculture.common.PageResults;

import java.util.List;

public class PageResultsUtil<T> {

    public static <T> PageResults<T> getData(Long total, T records) {

        //创建返回对象
        PageResults<T> pageResults = new PageResults<>();

        //设置参数
        pageResults.setTotal(total);
        pageResults.setRecodes(records);

        //返回给调用处
        return pageResults;
    }
}

