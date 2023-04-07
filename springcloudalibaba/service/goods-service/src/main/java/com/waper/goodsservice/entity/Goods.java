package com.waper.goodsservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Good
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/14 20:37
 */
@TableName("goods")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods {

    private Integer id;
    private String name;
    /**
     * 产地
     */
    private String productPlace;
    /**
     * 生产日期
     */
    private String productDate;
}
