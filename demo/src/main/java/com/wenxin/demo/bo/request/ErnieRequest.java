package com.wenxin.demo.bo.request;

import com.wenxin.demo.enums.MaskType;
import com.wenxin.demo.enums.TaskType;
import lombok.Data;

/**
 * @ docs: https://wenxin.baidu.com/wenxin/docs#dl6tgxw5f
 */
@Data
public class ErnieRequest {
    /**
     * 异步标识
     */
    private int async = 1;
    /**
     * 用户输入文本
     */
    private String text;
    /**
     * 最小生成长度
     */
    private int min_dec_len = 1;
    /**
     * 最大生成长度
     */
    private int seq_len = 128;
    /**
     * 多样性
     * [0.0,1.0]，间隔0.1
     */
    private float topp;
    /**
     * 重复惩罚
     * [1,2]
     */
    private float penalty_score;
    /**
     * 提前结束符
     */
    private String stop_token;
    /**
     * 任务类型
     */
    private TaskType task_prompt;
    /**
     * 模型类型
     */
    private int typeId = 1;
    /**
     * 惩罚文本
     */
    private String penalty_text;
    /**
     * 候选文本
     */
    private String choice_text;
    /**
     * 单双向控制开关
     */
    private int is_unidirectional = 0;
    /**
     * 最小惩罚样本
     */
    private String min_dec_penalty_text;
    /**
     * 屏蔽惩罚
     */
    private String logits_bias;
    /**
     * 生成粒度
     */
    private MaskType mask_type;

}
