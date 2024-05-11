package com.gxa.agriculture.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 实体类与数据表建立映射关系
 */

import java.io.Serializable;
import java.util.Date;

@Data
@ToString(exclude = {"pwd"})
@TableName("tb_user")
public class User implements Serializable {



    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("phone")
    private String phone;

    /**
     * 生成json时该字段会被忽略
     */
    @JsonIgnore
    @TableField("pwd")
    private String pwd;

    @TableField("points")
    private Integer points;

    /**
     * 在返回前端转回json时生效
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "Asia/Shanghai")
    @TableField("reg_time")
    private Date regTime;

    @TableField("deleted")
    private Integer deleted;
}
