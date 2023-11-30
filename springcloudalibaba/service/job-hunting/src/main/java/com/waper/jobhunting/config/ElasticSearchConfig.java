package com.waper.jobhunting.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ElasticSearch配置类
 * @author wangpeng
 * @ClassName ElasticSearchConfig
 * @description ElasticSearchConfig
 * @date 2023/11/30 15:56
 */
@Configuration
public class ElasticSearchConfig {

    /**
     * 注册rest高级客户端
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient () {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.128.128",9200,"http")));
        return client;
    }
}
