package newnew.study;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context =this.getServletContext();
        Object nameAttr = context.getAttribute("name");
        String name = nameAttr != null ? nameAttr.toString() : null;
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        if (name == null) {
            resp.getWriter().write("error");
        }
        else {
            resp.getWriter().write(name);
        }


    }
}
