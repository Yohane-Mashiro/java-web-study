package newnew.study;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DownLoad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求参数获取文件名，使代码更灵活
        String filename = req.getParameter("filename");
        if (filename == null || filename.trim().isEmpty()) {
            filename = "test.txt"; // 默认文件名
        }

        // 处理中文文件名
        String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8.toString());

        // 设置更合适的Content-Type
        String contentType = getServletContext().getMimeType(filename);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        // 设置响应头
        resp.setContentType(contentType);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Disposition", "attachment;filename=" + encodedFilename);
        resp.setHeader("Cache-Control", "no-cache");

        // 正确获取资源路径
        try (InputStream in = getServletContext().getResourceAsStream("/resource/" + filename);
            ServletOutputStream out = resp.getOutputStream()) {

            if (in == null) {
                resp.setContentType("text/html;charset=UTF-8");
                resp.getWriter().println("文件不存在: " + filename);
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            // 输出文件内容
            byte[] buffer = new byte[4096];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
