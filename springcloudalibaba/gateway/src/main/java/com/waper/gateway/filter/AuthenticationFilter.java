//package com.waper.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @ClassName AuthenticationFilter
// * @Description TODO
// * @Author wangpeng
// * @Date 2023/3/26 18:19
// */
//@Component
//public class AuthenticationFilter implements GlobalFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
//        String auth = queryParams.getFirst("token");
//        if (StringUtils.hasText(auth) && "admin".equals(auth)) {
//            // 方行
//            return chain.filter(exchange);
//        }
//
//        // 禁止访问，设置状态码
//        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//        return exchange.getResponse().setComplete();
//    }
//}
