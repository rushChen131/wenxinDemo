package com.wenxin.demo.enums;

import lombok.Getter;

@Getter
public enum TaskType {
    PARAGRAPH("引导模型生成一段文章"),
    SENT("引导模型生成一句话"),
    ENTITY("引导模型生成词组"),
    Summarization("摘要"),
    MT("翻译"),
    Text2Annotation("抽取"),
    Correction("纠错"),
    QA_MRC("阅读理解"),
    Dialogue("对话"),
    QA_Closed_book(" 闭卷问答"),
    QA_Multi_Choice("多选问答"),
    QuestionGeneration("问题生成"),
    Paraphrasing("复述"),
    NLI("文本蕴含识别"),
    SemanticMatching("匹配"),
    Text2SQL("文本描述转SQL"),
    TextClassification("文本分类"),
    SentimentClassification("情感分析"),
    zuowen("写作文"),
    adtext("写文案"),
    couplet("对对联"),
    novel("写小说"),
    cloze("文本补全"),
    Misc("其它任务"),
    ;

    private final String remark;

    TaskType(String remark) {
        this.remark = remark;
    }
}
