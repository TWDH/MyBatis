package cn.itcast.controller;

import cn.itcast.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/param")
public class ParamController {

    /**
     * 参数绑定
     * @param username
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username) {
        System.out.println("执行了testParam...");
        System.out.println("我的用户名是："+username);
        return "success";
    }

    /**
     * 封装到javabean
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account);
        return "success";
    }
}
