package com.wenxin.demo.bo.response;

import lombok.Data;

@Data
public class BaseResponse {
    private Integer code;
    private String msg;
    private String data;
}
