import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

public class Logout extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session= request.getSession(true);
        session.invalidate();

        response.sendRedirect("/hello/login");
    }
}