package com.waper.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangpeng
 * @ClassName User
 * @description TODO
 * @date 2023/12/20 11:30
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class User {

    /**
     * id
     */
    private String id;

    /**
     * 用户名
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;

}
