import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

public class AuthCustomization extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html;charset=utf-8");
        String target=request.getRequestURI();//thispage

        HttpSession session=request.getSession(false);
        if(session==null){
            session=request.getSession(true);
            session.setAttribute("target",target);

            response.sendRedirect("/hello/login");

        }
        else{
            Object loginCheck=session.getAttribute("login");
            if(loginCheck ==null){
                session.setAttribute("target",target);
                response.sendRedirect("/hello/login");
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ユーザー認証テスト</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>テストページ1</p>");

        out.println("<p><a href=\"/hello/customauth2\">テストページ2へ</a></p>");
        out.println("<p><a href=\"/hello/logout\">ログアウト</a></p>");

        out.println("</body>");
        out.println("</html>");

    }
}