package com.example;


import org.springframework.context.annotation.*;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAspectJAutoProxy
//@ComponentScan("com.example")
public class App 
{
    // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(App.class);
    @Bean("mainNewsBean2")
    public News getNews(){
        News n = new News();
        n.setTitle("Title Bean 1");
        n.setContent("conetent22222");
        return n;
    }

    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.example","com");
        News news = ctx.getBean("NewsDefualt",News.class);
        System.out.println(news.title);
        News news2 = ctx.getBean("mainNewsBean2", News.class);
        UserService us = ctx.getBean(UserService.class);
        System.out.println(us.toString());
        System.out.println(news2.content);
        System.out.println(news2.title);
        var stu = ctx.getBean("student",Student.class);
        var stu1 = ctx.getBean("student",Student.class);
        var stu2 = ctx.getBean("student",Student.class);
        System.out.println(stu.getAge());
        System.out.println(stu.getName());
        System.out.println(stu.getSchool().getName());
        System.out.println(stu.getSchool().getNews1().content);
        System.out.println(stu.getSchoolMiddeSchool().getName());
        System.out.println(stu1);
        System.out.println(stu2);
        UserService userService  = ctx.getBean("userService",UserService.class);
        userService.AddUser("Xiaomi", 10);
        userService.GetUser("UserName 1111");
        // log.info("Info");
        ctx.close();
        
        
    }
}
