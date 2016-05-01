import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

public class AuthFilteredServlet extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html;charset=utf-8");


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ユーザー認証テスト(フィルタ)</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>テストページ(フィルタ)1</p>");

        out.println("<p><a href=\"/hello/filterauth2\">テストページ2(フィルタ)へ</a></p>");
        out.println("<p><a href=\"/hello/logout\">ログアウト</a></p>");

        out.println("</body>");
        out.println("</html>");

    }
}