package week_passwd;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        // 获取表单提交的参数
        String admin = req.getParameter("admin");
        String passwd = req.getParameter("passwd");

        if (admin.equals("admin") && passwd.equals("a123456")) {
            resp.getWriter().write("flag{4314e2b15ad9a960e7d9d8fc2ff902da}");
        } else {
            resp.getWriter().write("登录失败！");
        }
    }
}
