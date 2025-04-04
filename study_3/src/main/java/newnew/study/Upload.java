package newnew.study;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@MultipartConfig
public class Upload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取普通表单项（获取参数）
        String uname = req.getParameter("uname");
        System.out.println("uname: " + uname);

        //获取Part对象
        Part part = req.getPart("uploadFile");
        if (part != null && part.getSize() > 0) {
            //通过Part对象得到上传的文件名
            String fileName = part.getSubmittedFileName();
            System.out.println("上传文件名：" + fileName);

            //指定文件存放到download目录
            String downloadPath = req.getServletContext().getRealPath("/resource");

            //确保download目录存在
            File downloadDir = new File(downloadPath);
            if (!downloadDir.exists()) {
                downloadDir.mkdir();
            }

            System.out.println("文件存放路径：" + downloadPath);

            //上传文件到download目录
            part.write(downloadPath + File.separator + fileName);

            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("文件上传成功！保存在/resource目录");
        } else {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("请选择要上传的文件");
        }
    }
}