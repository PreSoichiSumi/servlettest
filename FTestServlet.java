import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

//classファイルをclasses内に配置
//

public class FTestServlet extends HttpServlet {

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
        out.println("<h1>Hello Filter!</h1>");

        String s = (String) request.getAttribute("filter");
        if (s == null)
            s = "";

        out.println("<p>"
                + "filterData: "
                + s
                + "</p>");

        out.println("<br>");
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