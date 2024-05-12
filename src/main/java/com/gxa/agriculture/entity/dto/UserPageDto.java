package com.gxa.agriculture.entity.dto;

import com.gxa.agriculture.common.PageDto;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 带条件的分页查询
 */
@Data
public class UserPageDto implements Serializable {
    private String phone;
    //private Date reg;

    private PageDto pageDto;
    /*private Long current;
    private Long size;*/


}
