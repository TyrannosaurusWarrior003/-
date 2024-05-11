package com.gxa.agriculture.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDto implements Serializable {
    private String name;
    private String phone;
    private String pwd;
}
