import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

//classファイルをclasses内に配置
//

public class SessionServlet extends HttpServlet {
    final int MAX_AGE = 60;

    @Override
    public void init() throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>this is session test</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello Session!</h1>");

        HttpSession session = request.getSession(false);

        if (session == null) {
            out.println("しょかいほうもん");
            session = request.getSession(true);
            session.setMaxInactiveInterval(MAX_AGE);
            session.setAttribute("visited", "1");
            session.setAttribute("age", "24");
            session.setAttribute("name", "sumi");
            session.setAttribute("hoge", "hage");
            session.setAttribute("num", "fuga");
        } else {
            String visitedStr = (String) session.getAttribute("visited");
            int visited = Integer.parseInt(visitedStr);
            visited++;

            out.println("<p>訪問回数は");
            out.println(visited);
            out.println("回目です</p>");

            session.setAttribute("visited", Integer.toString(visited));
        }
        out.println("<br>");
        out.println("登録されているセッションオブジェクトを表示します．");
        if (session != null) {
            Enumeration<String> enum_session = session.getAttributeNames();
            while (enum_session.hasMoreElements()) {
                String key = (String) enum_session.nextElement();
                String val = (String) session.getAttribute(key);

                out.println(key + " = " + val + "<br>");
            }
        } else {
            out.println("何故かセッションがない<br>");
        }
        out.println("<br>");


        out.println("<a href=\"/hello/sessiontest\">再表示</a>");
        out.println("<br>");
        out.println("<a href=\"/hello/remove\">attribute破棄</a>");
        out.println("<br>");
        out.println("sessionID: " + session.getId());
        out.println("<br>");
        out.println("reqURI: " + request.getRequestURI());
        out.println("<br>");
        out.println("reqURL: " + request.getRequestURL());
        out.println("<br>");
        out.println("servletPath: " + request.getServletPath());
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");

    }
}