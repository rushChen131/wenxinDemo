package com.wenxin.demo.service;

import ch.qos.logback.classic.jmx.MBeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.wenxin.demo.bo.request.ErnieRequest;
import com.wenxin.demo.bo.request.ResultRequest;
import com.wenxin.demo.bo.response.BaseResponse;
import com.wenxin.demo.bo.response.ErnieResponse;
import com.wenxin.demo.bo.response.ResultResponse;
import com.wenxin.demo.enums.UrlType;
import com.wenxin.demo.util.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class RequestService {

    @Value("${app.key:}")
    private String appKey;

    @Value("${app.secret:}")
    private String appSecret;

    @Resource
    private RestTemplate restTemplate;

    public String getAccessToken() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Accept-Charset", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            HttpEntity<HashMap<String, Object>> request = new HttpEntity<>(null, headers);
            BaseResponse baseResponse = restTemplate.postForObject("https://wenxin.baidu.com/moduleApi/portal/api/oauth/token?grant_type=client_credentials&client_id=" + appKey + "&client_secret=" + appSecret, request, BaseResponse.class);
            System.out.println("response:" + JSONObject.toJSONString(baseResponse));
            return baseResponse.getData();
        } catch (Exception e) {
            System.out.println("异常消息:" + e.getMessage());
            return e.getMessage();
        }
    }

    public ErnieResponse requestWenXin(String token, ErnieRequest ernieRequest, Integer urlIndex) {
        try {
            BaseResponse response = request(new HttpEntity<>(BeanUtils.beanToMap(ernieRequest), buildHeaders()), UrlType.values()[urlIndex].getUrl() + "?access_token=" + token);
            return JSONObject.parseObject(response.getData(), ErnieResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultResponse getResult(String token, ResultRequest resultRequest) {
        try {
            BaseResponse response = request(new HttpEntity<>(BeanUtils.beanToMap(resultRequest), buildHeaders()), "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/v1/getResult?access_token=" + token);
            return JSONObject.parseObject(response.getData(), ResultResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private BaseResponse request(HttpEntity<MultiValueMap<String, String>> request, String url) {
        System.out.println("request url :" + url + " data :" + JSONObject.toJSONString(request));
        BaseResponse responseEntity = restTemplate.postForObject(url, request, BaseResponse.class);
        System.out.println("response:" + JSONObject.toJSONString(responseEntity));
        return responseEntity;
    }


    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Accept-Charset", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        return headers;
    }


}
