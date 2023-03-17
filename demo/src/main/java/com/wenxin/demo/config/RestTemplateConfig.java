package com.wenxin.demo.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RestTemplateConfig {
    @Resource
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        RestTemplate restTemplate = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();

        List<HttpMessageConverter<?>> converters = messageConverters.stream()
                .filter(item -> !(item instanceof MappingJackson2HttpMessageConverter))
                .collect(Collectors.toList());
        converters.add(converter);

        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(150000); // ms
        factory.setConnectTimeout(150000); // ms
        return factory;
    }
}