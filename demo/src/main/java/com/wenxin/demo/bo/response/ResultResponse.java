package com.wenxin.demo.bo.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResultResponse {
    private String result;
    private Date createTime;
    private String requestId;
    private String text;
    private Long taskId;
    /**
     *  0表示生成中，1表示生成成功
     */
    private Integer status;
}
