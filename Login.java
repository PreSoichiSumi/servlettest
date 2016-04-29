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

        HttpSession session = request.getSession(false);

        Object status=session.getAttribute("status");

        if(status != null){
            out.println("<p>認証に失敗しました</p>");
            out.println("<p>再度ユーザ名とパスワードを入力してください．</p>");
            session.setAttribute("status",null);
        }

        out.println("<form method=\"POST\" action=\"/hello/logincheck\" name=\"loginform\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>ユーザー名</td>");
        out.println("<td><input type=\"text\" name=\"user\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>パスワード</td>");
        out.println("<td><input type=\"password\" name=\"pass\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"login\"></td>");
        out.println("<td><input type=\"reset\" value=\"reset\"></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");

    }
}