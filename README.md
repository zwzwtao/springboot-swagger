# springboot-swagger
exploring swagger3

##### 1. swagger3 只需要在pom里导入一个starter即可，不用导入别的了
启动项目后点开 http://localhost:8080/swagger-ui/index.html 即可进入swagger文档
```java
<dependency>
<groupId>io.springfox</groupId>
<artifactId>springfox-boot-starter</artifactId>
<version>3.0.0</version>
</dependency>
```

##### 2. 在springboot启动器配置注解@EnableOpenApi
```java
@SpringBootApplication
@EnableOpenApi
public class SpringbootSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwaggerApplication.class, args);
    }

}
```  
##### 3. SwaggerConfig可以不佳@EnableOpenApi注解



参考1: https://cloud.tencent.com/developer/article/1840435  
参考2: https://juejin.cn/post/6951736202613489672  
参考3: https://juejin.cn/post/6878956091670495240
参考4: https://www.cnblogs.com/architectforest/p/13470170.html (swagger配置)  
参考5: https://support.typora.io/Markdown-Reference/#fenced-code-blocks
