package com.odas.controller;

import com.odas.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Api是接口类的说明注释
@Api(tags = "Hello 接口")
@RestController
@RequestMapping("/odas")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    // 只要我们的接口中，返回值中存在实体类，他就会被扫描到swagger中
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User user() {
        return new User();
    }

    @ApiOperation("user2 方法")
    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    public User hello2(@ApiParam("用户类User") User user) {
        return user;
    }

    @ApiOperation("hello2 方法")
    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    /*
    注意，如果要用@ApiParam一定要和@RequestParam搭配使用
    @ApiParam 里的 name 表示参数名，一定要与 @RequestParam 里的参数名一致
    @ApiParam 里的 value 则表示对于参数的说明
     */
    public String hello2(@ApiParam(name = "name", value = "用户名", required = true) @RequestParam("name") String name) {
        return "hello " + name;
    }
}
