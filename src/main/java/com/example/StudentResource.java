package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component // Model注解
@Service   // 服务中间件注解
@Repository //  DAO层注解
@Controller // 控制器注解  没有什么特定的区别主要用来分层
@Scope("prototype")
public class StudentResource {
    @Value("默认名称")
    private String name;
    private int age;
    @Resource // javax包，jdk11不包含，需要手动在pox.xml加载 一般不用
    private School school;
    @Autowired(required = false) // 自动注入验证，找不到bean就会为null
    @Qualifier("SchoolDefualt") // byName
    private School schoolMiddeSchool;
    public School getSchoolMiddeSchool() {
        return schoolMiddeSchool;
    }
    public void setSchoolMiddeSchool(School schoolMiddeSchool) {
        this.schoolMiddeSchool = schoolMiddeSchool;
    }
    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
