package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器
@Controller
public class HelloController {
    //"/hello"为此方法的请求路径
    @RequestMapping(path="/hello")
    public String sayHello() {
        System.out.println("Hello StringMVC");
        return "success";
    }
}
