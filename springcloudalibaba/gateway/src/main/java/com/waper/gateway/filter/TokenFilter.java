package com.waper.gateway.filter;

import com.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * @ClassName TokenFilter
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/3/13 17:36
 */
public class TokenFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String uri = request.getURI().getPath();

        String token = request.getHeaders().getFirst("token");
        if (!StringUtil.isNullOrEmpty(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return chain.filter(exchange);
        }

        return null;
    }
}
