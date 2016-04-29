import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

public class AuthCustomization2 extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html;charset=utf-8");
        String target=request.getRequestURI();//thispage

        HttpSession session=request.getSession(false);
        if(session==null){
            session=request.getSession(true);
            session.setAttribute("target",target);

            response.sendRedirect("/hello/authlogin");

        }
        else{
            Object loginCheck=session.getAttribute("login");
            if(loginCheck ==null){
                session.setAttribute("target",target);
                response.sendRedirect("/hello/authlogin");
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ユーザー認証テスト</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>テストページ2</p>");

        out.println("<p><a href=\"/hello/customauth1\">テストページ1へ</a></p>");
        out.println("<p><a href=\"/hello/logout\">ログアウト</a></p>");

        out.println("</body>");
        out.println("</html>");

    }
}