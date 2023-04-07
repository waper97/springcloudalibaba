package com.waper.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/9 18:43
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User implements Serializable {

    private Integer id;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private Integer age;
}
