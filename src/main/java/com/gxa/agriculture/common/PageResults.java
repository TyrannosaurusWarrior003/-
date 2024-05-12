package com.gxa.agriculture.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageResults<T> implements Serializable {
    private Long total;
    private T recodes;
}
