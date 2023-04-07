package com.waper.goodsserviceapi.feign;

import org.springframework.stereotype.Component;

/**
 * @ClassName GoodsFeignServiceException
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/14 22:25
 */
@Component
public class GoodsFeignServiceException  implements GoodsFeignService{
    @Override
    public String inserGoods() {
        return "哦豁展示用不起了！";
    }
}
