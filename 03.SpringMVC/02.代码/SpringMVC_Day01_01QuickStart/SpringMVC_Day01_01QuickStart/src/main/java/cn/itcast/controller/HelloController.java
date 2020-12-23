package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器:用来接收请求
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    /**
     * 入门案例
     * @return
     */
    //"/hello"为此方法的请求路径
    @RequestMapping(path="/hello")
    public String sayHello() {
        System.out.println("Hello StringMVC");
        return "success";
    }

    /**
     * 测试RequestMapping注解
     * method：方法
     *  params：必须给方法一个参数（在请求页面?username=zhangsan），否则不能执行
     * @return
     */
    @RequestMapping(value = "/testRequestMapping", method = {RequestMethod.POST})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解");
        return "success";
    }
}
