package cn.itcast.controller;

import cn.itcast.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * SpringMVC文件上传
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("----- 文件上传 -----");
        // 使用fileupload组件完成文件上传
        //1.上传的位置
        String path = request.getSession().getServletContext().getRealPath("/upload/");

        //2.判断，该路径是否存在.不存在创建新文件夹
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        //3.说明上传文件项
        //3.1获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //3.2把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //4.完成文件上传
        upload.transferTo(new File(path, filename));

        return "success";
    }

    /**
     * 跨服务器文件上传
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(MultipartFile upload) throws Exception {
        System.out.println("----- 跨服务器文件上传 -----");
        //1.定义上传文件服务器路径
        String path = "http://localhost:9090/uploads/";

        //2.说明上传文件项
        //2.1获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //2.2把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //3.创建客户端对象
        Client client = Client.create();
        //4.和图片服务器链接
        WebResource webResource = client.resource(path + filename);
        //5.上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
