package com.wenxin.demo.enums;

import lombok.Getter;

@Getter
public enum UrlType {
    SYNONYMOUS_REWRITING("同义改写", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.20/zeus"),
    COMPOSITION("写作文", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.21/zeus"),
    WRITE_A_COPY("写文案", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.22/zeus"),
    WRITE_SUMMARY("写摘要", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.23/zeus"),
    MATCHING_AN_ANTITHETICAL_COUPLET("对对联", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.24/zeus"),
    FREE_QUESTION_AND_ANSWER("自由问答", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.25/zeus"),
    PRODUCE_A_NOVEL("写小说", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.26/zeus"),
    COMPLETE_TEXT("补全文本", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.27/zeus"),
    CUSTOM("自定义", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.28/zeus"),
    QA_PAIR_EXTRACTION("问答对抽取", "https://wenxin.baidu.com/moduleApi/portal/api/rest/1.0/ernie/3.0.30/zeus"),
    ;

    private final String remark;

    private final String url;

    UrlType(String remark, String url) {
        this.remark = remark;
        this.url = url;
    }
}
