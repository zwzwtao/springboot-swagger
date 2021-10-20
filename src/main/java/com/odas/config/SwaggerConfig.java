package com.odas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        /*
        获取项目的环境(这个环境可以在yaml里配置)，acceptsProfiles会返回一个布尔值，
        true就表示在相关的环境里，false则表示不在相关环境里，这里获取的b可以传给Docket
        的enable里作为参数来控制是否在某个环境开启swagger
         */
        boolean b = environment.acceptsProfiles(profiles);

        // 配置了swagger的docket的bean实例，这里点入源码可以看到
        // 构造函数里面有相关的参数选项，这里swagger3就选择OAS_30啦
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // enable是否启用swagger，如果false则不启用，默认启用，所以可以不写enable
                .enable(b)
                .select()
                /*
                RequestHandlerSelectors，配置要扫描接口的方式
                basePackage: 指定要扫描的包
                any(): 扫描全部
                none(): 不扫描
                withClassAnnotation: 只扫描带特定注解的类，如: 类上有@RestController，
                    就传.withClassAnnotation(RestController.class)
                withMethodAnnotation: 只扫描带特定注解的函数
                 */
                .apis(RequestHandlerSelectors.basePackage("com.odas.controller"))
                // paths()过滤什么路径，其实ant更像是说放行什么路径
                .paths(PathSelectors.ant("/odas/**"))
                .build();
    }

    // 配置swagger信息apiInfo
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("odas", "https://github.com/zwzwtao", "odas@odas.com");

        return new ApiInfo(
                "标题-ODAS文档",
                "ODASの无限可能",
                "v1.0",
                "https://github.com/zwzwtao",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
