package com.bpm.mes.purchase.feign;

import com.bpm.mes.purchase.common.vo.ResultVO;
import com.bpm.mes.purchase.dto.MesPurchaseBuyRequestInsertDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "mes-purchase-manage",
        path = "mesPurchaseBuyRequest"

)
public interface PurchaseClient {

    @PostMapping(value = "/insert")
    ResultVO add(@RequestBody MesPurchaseBuyRequestInsertDTO mesPurchaseBuyRequestInsertDTO);

    /**
     * feign Demo
     * @return
     */
    @GetMapping("/helloPurchase")
    String helloPurchase();

}
