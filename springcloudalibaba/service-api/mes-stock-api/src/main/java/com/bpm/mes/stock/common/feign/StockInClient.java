package com.bpm.mes.stock.common.feign;


import com.bpm.mes.stock.common.dto.StockCheckResults;
import com.bpm.mes.stock.common.dto.StockInPurchaseDto;
import com.bpm.mes.stock.common.dto.StockOutDto;
import com.bpm.mes.stock.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(
//        name = "mes-stock",
//        fallbackFactory = StockInClientFallBack.class
//)
@FeignClient(
        name = "mes-stock"
)
public interface StockInClient {

    /**
     * 收货新增入库单
     * @param dto
     * @return
     */
    @PostMapping("/mesWmsStockin/addPurchaseIn")
    ResultVO addPurchaseIn(@RequestBody StockInPurchaseDto dto) ;

    /**
     * 生产新增入库单
     * @param dto
     * @return
     */
    @PostMapping("/mesWmsStockin/addProductionIn")
    ResultVO addProductionIn(@RequestBody StockInPurchaseDto dto) ;

    /**
     * 新增生产出库
     * @param dto
     * @return
     */
    @PostMapping("/out/addProductionOut")
    ResultVO addProductionOut(@RequestBody StockOutDto dto) ;

    /**
     * 检验接收
     * @param stockCheckResults 主键
     * @return 检验接收是否成功
     */
    @PostMapping("/out/checkReception")
    ResultVO checkReception(@RequestBody StockCheckResults stockCheckResults);

}
