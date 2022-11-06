package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SchoolDefualt")
public class School {
    @Value("默认学校")
    private String name;
    @Value("默认位置")
    private String localtion;
    @Autowired
    @Qualifier("mainNewsBean2")
    private News news1;
    public News getNews1() {
        return news1;
    }
    public void setNews1(News news1) {
        this.news1 = news1;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocaltion() {
        return localtion;
    }
    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }
}
