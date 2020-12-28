package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResovler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取异常对象
        SysException e = null;
        if (ex instanceof SysException) {
            e = (SysException) ex;
        }
        else {
            e = new SysException("系统正在维护");
        }

        //创建ModelAndView信息
        ModelAndView mv = new ModelAndView();
        //将信息存入request
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("error");
        return mv;

    }
}
