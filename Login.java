import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

public class Login extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>ログインページ</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>ログイン画面</h1>");

        out.println("<p>本来はここでログインするためのフォームが表示されます</p>");

        HttpSession session = request.getSession(false);
        if (session == null) {
            out.println("<p>不正なアクセスです．</p>");
        } else {
            out.println("<p>認証が行われました</p>");
            session.setAttribute("login", "OK");

            String target = (String) session.getAttribute("target");
            out.println("<a href=\"" + target + "\">ページを表示する</a>");
        }
        out.println("</body>");
        out.println("</html>");

    }
}