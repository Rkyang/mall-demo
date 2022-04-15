package com.rky.mall.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.address}")
    private String address;
    @Value("${elasticsearch.username}")
    private String username;
    @Value("${elasticsearch.password}")
    private String password;


    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration build = ClientConfiguration.builder()
                // 集群地址
                .connectedTo(address)
                // 连接超时时间，默认为10秒
//                .withConnectTimeout(Duration.ofSeconds(5))
                // 套接字超时时间，默认为5秒
//                .withSocketTimeout(Duration.ofSeconds(3))
                .withBasicAuth(username, password)
                .build();
        return RestClients.create(build).rest();
    }
}
