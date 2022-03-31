package com.waper.dataanalysis.entity;

import lombok.Data;
import org.hibernate.annotations.Tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName Hero
 * @Description TODO
 * @Author wangpeng
 * @Date 2021/6/21 15:09
 */
@Entity
@Data
public class Hero implements Serializable {
    /**
     * 英雄编号
     */
    @Id
    private Long ename;
    /**
     * 英雄名称
     */
    private String cname;
    /**
     * 英雄全称
     */
    private String title;
    /**
     *
     */
    private String newType;
    /**
     * 英雄类型
     */
    private String heroType;
    /**
     * 皮肤
     */
    private String skinName;
}
