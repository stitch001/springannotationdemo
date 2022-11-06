package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component("NewsDefualt")
public class News {

    public String title;
    public String content;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}

@Component
class NewsPost implements BeanPostProcessor{
    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        if (bean instanceof News){

            System.out.println(bean.toString() + "初始化完成");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}