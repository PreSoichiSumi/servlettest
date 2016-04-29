import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

//入力された値が正しいかチェック
public class LoginCheck extends HttpServlet {
    protected Connection conn = null;

    @Override
    public void init() throws ServletException {
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession(true);

        boolean check = authUser(user, pass);
        if (check) {
            session.setAttribute("login", "OK");

            String target = (String) session.getAttribute("target");
            response.sendRedirect(target);
        } else {
            session.setAttribute("status", "Not Auth");

            response.sendRedirect("/hello/login");
        }
    }

    protected boolean authUser(String user, String pass) {
        if (user == null || user.length() == 0 || pass == null || pass.length() == 0) {
            return false;
        }
        return true;
    }
}