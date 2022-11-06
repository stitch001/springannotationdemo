# Spring 注解注入快速入门

~~吐槽于2022年11月6日~~
> Spring 一款优秀的IOC框架，Java就靠它活着呢，Java对象管理有点乱，使用Spring以后，管理上去了，体现了依赖倒置原则  
> 其他的语言没有那么复杂，python 模块就是单例模式，go语言不全，.net 重新搞出来了.net core 相当于springboot全家桶了。  
> 学习一门框架核心的时学习其中实现思想，以及这个思想解决了什么问题，对其他的语言有没有什么借鉴

所谓容器，可以理解成玩具盒子，有一堆堆的玩具，管理由盒子管理  
随便存取

## Maven项目 
引入必须依赖
```xml
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.3.23</version>
    </dependency>
```

## 核心

### 声明 `bean`

Java Bean 就是一个一个`java`对象,由spring容器管理

```java
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.*;

@Component // 基本bean声明
@Service // 业务bean声明
@Repository // 数据库访问(DAO) 类声明
@Controller // 控制层 bean声明
class A {
    // 自定义bean声明
    @Bean
}
```

### 使用 `bean`

所有bean都是单例，`System.out.println()` id是一样的

```java
import org.springframework.beans.factory.annotation.*;

class A {
    @Autowired //自动根据名字装配 bean
    @Qualifier('') // 如果有多个bean则根据这个字段选择
    @Scope("prototype") //原型的话可以建立多个bean，否则默认单例
    public Book book;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.example", "com");
        ctx.getBean("BeanName");
    }
}
```


### 声明配置

```java
import org.springframework.context.annotation.*;

@Configuration //配置类声明
@PropertySource // 从配置文件加载配置
@Import({}) //引入其他配置类，比如mybatis, jdbc
@EnableAspectJAutoProxy // 其他的类
@ComponentScan({}) //扫描其他bean
class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.example", "com");
    }
}
```


