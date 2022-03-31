package com.waper.dataanalysis.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName Props
 * @Description TODO
 * @Author wangpeng
 * @Date 2021/6/21 18:26
 */
@Data
@Entity
public class Props implements Serializable {
    /**
     *
     */
    @Id
    private Long itemId;
    private String itemName;
    private String itemType;
    private String price;
    private String totalPrice;
    private String des1;
    private String des2;
}
