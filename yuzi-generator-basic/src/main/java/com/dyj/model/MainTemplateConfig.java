package com.dyj.model;

import lombok.Data;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/10/30 14:28
 * @Description:静态模板配置
 **/
@Data
public class MainTemplateConfig {
    /**
     * 是否生成循环（开关）
     */
    private boolean loop;

    /**
     * 作者注释 （字符串 填充值）
     */
    private String author="dyj";

    /**
     * 输出信息
     */
    private String outputText="结果为";

}
