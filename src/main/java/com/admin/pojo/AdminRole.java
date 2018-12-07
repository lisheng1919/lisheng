package com.admin.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lisheng
 * @version AdminRole, v0.1 2018/11/3 17:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdminRole {
    private static final long serialVersionUID = 5454155825314635342L;

    private Integer id;

    private String roleName;

    private Integer sort;

    private Integer status;

    private String delFlag;

    private String createtime;

    private String updatetime;

    private Integer createUserId;

    private Integer updateUserId;

    private String description;
}
