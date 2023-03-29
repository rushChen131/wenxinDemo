package com.wenxin.demo.bo.request;

import lombok.Data;

@Data
public class ViLGRequest {

    private String text;
    /**
     * 古风、二次元、写实风格、浮世绘、low poly 、未来主义、
     * 像素风格、概念艺术、赛博朋克、洛丽塔风格、巴洛克风格、
     * 超现实主义、水彩画、蒸汽波艺术、油画、卡通画
     */
    private String style;
    /**
     * 图片尺寸，目前支持的有：1024*1024 方图、1024*1536 长图、1536*1024 横图
     */
    private String resolution;

    /**
     * 图片数量，目前支持可选1到6张
     */
    private Integer num = 1;

//    /**
//     * 用该字段时 请将访问类型设置为： Content-Type 设置为 application/form-data
//     */
////    private MFile image;
}
