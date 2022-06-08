//package com.bpm.mes.stock.server.feign;
//
//import com.bpm.mes.stock.common.dto.StockCheckResults;
//import com.bpm.mes.stock.common.dto.StockInPurchaseDto;
//import com.bpm.mes.stock.common.dto.StockOutDto;
//import com.bpm.mes.stock.common.vo.ResultVO;
//import feign.hystrix.FallbackFactory;
//import org.springframework.stereotype.Component;
//
///**
// * <p>Title: AuthFallBackClient</p>
// * <p>Description: Feign异常处理</p>
// * <p>Company: http://www.wootion.com/</p>
// * <p>create date: 2020/03/26</p>
// *
// * @author :tanhuan
// * @version :1.0
// */
//@Component
//public class StockInClientFallBack implements FallbackFactory<StockInClient> {
//    @Override
//    public StockInClient create(Throwable arg0) {
//        return new StockInClient(){
//            /**
//             * 收货新增入库单
//             * @param dto
//             * @return
//             */
//            @Override
//            public ResultVO<StockInPurchaseDto> addPurchaseIn(StockInPurchaseDto dto) {
//                ResultVO resultVO = new  ResultVO();
//                resultVO.setCode(300);
//                resultVO.setMsg(arg0.getMessage());
//                return resultVO;
//            }
//
//            /**
//             * 生产新增入库单
//             * @param dto
//             * @return
//             */
//            @Override
//            public ResultVO<StockInPurchaseDto> addProductionIn(StockInPurchaseDto dto) {
//                ResultVO resultVO = new  ResultVO();
//                resultVO.setCode(300);
//                resultVO.setMsg(arg0.getMessage());
//                return resultVO;
//            }
//
//            /**
//             * 生产新增入库单
//             * @param dto
//             * @return
//             */
//            @Override
//            public ResultVO<StockOutDto> addProductionOut(StockOutDto dto) {
//                ResultVO resultVO = new  ResultVO();
//                resultVO.setCode(300);
//                resultVO.setMsg(arg0.getMessage());
//                return resultVO;
//            }
//
//            /**
//             * 生产新增入库单
//             * @param stockCheckResults
//             * @return
//             */
//            @Override
//            public ResultVO<StockCheckResults> checkReception(StockCheckResults stockCheckResults) {
//                ResultVO resultVO = new  ResultVO();
//                resultVO.setCode(300);
//                resultVO.setMsg(arg0.getMessage());
//                return resultVO;
//            }
//        };
//    }
//}