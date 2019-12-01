package com.controller;

import com.entity.TextsEntity;
import com.service.TextsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author XJ
 */
@Controller
public class MyController {

    @Autowired
    private TextsService textsService;
    private List<TextsEntity> list = new ArrayList<>();
    private static int RANDOM_NUM = 5;

    @RequestMapping("/hello")
    public String hello() {
        list = textsService.getAll();
        return "hello";
    }//欢迎界面首页并且读取数据库

    @RequestMapping("/edit")
    public String edit(int id) {
        RANDOM_NUM = id;
        return "hello";
    }//改变出题数目

    @RequestMapping("/reset")
    public String reset() {
        return "hello";
    }//返回主界面

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }//管理员界面

    @RequestMapping("/insertTest")
    public ModelAndView insertTest(String path) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("list", getList(path));
        modelAndView.addObject("path",path);
        return modelAndView;
    }//测试文档的数据是否正确

    @RequestMapping("/insert")
    public ModelAndView insert(String path) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        int result = textsService.insert(getList(path));
        if (result == 0) {
            modelAndView.addObject("error", "添加数据失败！");
        }
        return modelAndView;
    }//录入数据库

    @RequestMapping("/answer")
    public ModelAndView answer() {
        List<TextsEntity> lists = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("answer");
        Random random = new Random();
        for (int i = 0; i < RANDOM_NUM; i++) {
            int num = random.nextInt(list.size());
            TextsEntity testsEntity = list.get(num);
            lists.add(testsEntity);
            list.remove(num);
        }
        modelAndView.addObject("list", lists);
        return modelAndView;
    }//展示题目界面

    private List<TextsEntity> getList(String path) {
        List<TextsEntity> exam = new ArrayList<>();
        String[] word = TextPoi.getContext(path).split("\r");
        for (String s : word) {
            String[] text = s.split("：");
            TextsEntity textsEntity = new TextsEntity();
            for (int j = 0; j < text.length; j++) {
                if (//下面的这个是防止有文档单个不明字符或者空字符等等造成不必要的数据影响
                     text[j].length()>1) {
                    if(j % 2 == 0) {
                        textsEntity.setTextdosc(text[j].trim());
                    }else {
                        textsEntity.setTextanswer(text[j].trim());
                    }
                }

            }
            exam.add(textsEntity);
        }
        return exam;
    }//获取题目的方法
}
