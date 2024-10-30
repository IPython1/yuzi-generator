package com.dyj.generator;

import com.dyj.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/10/30 15:28
 * @Description:核心生成器
 **/

public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException, TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
//      +File.separator+"yuzi-generator-basic";
//      System.out.println(projectPath);
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
//        System.out.println(parentFile.getName());
        // 输入路径
        String inputPath = projectPath+File.separator+"yuzi-generator-demo-projects"+File.separator+"acm-template";
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(new File(inputPath),new File(outputPath) );

        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator +"yuzi-generator-basic"+File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("jeijiejie");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("这就是结果啦：");
        doGenerate(mainTemplateConfig);
    }
}


