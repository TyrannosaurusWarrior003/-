package com.gxa.agriculture.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageDto implements Serializable {
    private Long current;
    private Long size;
}
