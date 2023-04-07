package com.waper.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName GlobalFilter
 * @Description 权限过滤器
 * @Author wangpeng
 * @Date 2022/12/20 18:09
 */
@Component
@Order(2)
public class AuthFilter implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
//        // 获取请求体
//        ServerHttpRequest request = exchange.getRequest();
//        // 获取请求参数
//        MultiValueMap<String, String> queryParams = request.getQueryParams();
//
//        String auth = queryParams.getFirst("authorization");
////        if (auth != null && "admin".equals(auth)) {
////            // 放行
////            return chain.filter(exchange);
////        }
//        // 获取响应体
//        ServerHttpResponse response = exchange.getResponse();
//        // 设置状态码
//        response.setStatusCode(HttpStatus.OK);
//        // 设置拦截完成
//        return response.setComplete();
    }
}
