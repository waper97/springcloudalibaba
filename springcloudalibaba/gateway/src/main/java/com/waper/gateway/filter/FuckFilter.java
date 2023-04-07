package com.waper.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName FuckFilter
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/12/20 18:17
 */
@Component
@Order(1)
public class FuckFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("这是FuckFilter");
        return chain.filter(exchange);
    }
}
