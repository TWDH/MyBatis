package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 字符串返回值
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString执行了");

        //模拟从数据库中查找
        User user = new User();
        user.setUsername("HeZhu");
        user.setPassword("123");
        user.setAge(24);

        //存入request域
        model.addAttribute("user", user);

        return "success";
    }

    /**
     * 返回值为void
     * 请求转发是一次请求，不用编写项目名称
     * @param
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid执行了");
        //编写请求转发程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
        //System.out.println(request.getContextPath());
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接进行响应
        response.getWriter().println("你好");
        return;
    }

    /**
     * ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView执行了");

        //模拟从数据库中查找
        User user = new User();
        user.setUsername("HeZhu");
        user.setPassword("123");
        user.setAge(24);

        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        //把user对象存储到mv对象中，同时会把user对象存到request域
        mv.addObject("user", user);

        //跳转到那个页面(调用视图解析器)
        mv.setViewName("success");

        return mv;
    }

    /**
     * ForwardOrRedirect
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("--------- testForwardOrRedirect ----------");
        //请求转发(此时视图解析器不使用)
        //return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 接收ajax
     * @param
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("----- testAjax方法执行了 -----");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println("body: "+ user);
        //模拟查找数据库，user从ajax传过来，我们修改再返回到页面
        user.setUsername("祝赫");
        user.setAge(25);
        return user;

    }
}
