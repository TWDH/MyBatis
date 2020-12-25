package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request: "+request);

        HttpSession session = request.getSession();
        System.out.println("session: "+session);

        ServletContext servletContext = session.getServletContext();
        System.out.println("servletContext: "+servletContext);

        System.out.println("response: "+response);

        return "success";
    }
}
