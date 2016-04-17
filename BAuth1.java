import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

public class BAuth1 extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out=response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>ユーザー認証テスト</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>テストページ1</p>");

        out.println("<p><a href=\"/hello/authtest2\">テストページ2へ</a></p>");

        out.println("</body>");
        out.println("</html>");

    }
}