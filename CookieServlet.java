import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

//classファイルをclasses内に配置
//

public class CookieServlet extends HttpServlet{

    @Override
    public void init() throws ServletException{

    }

    @Override
    public void destroy(){

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");


        Cookie cookie[]=request.getCookies();
        Cookie visitedCookie=null;

        if(cookie !=null) {
            for(Cookie c:cookie){
                if(Objects.equals(c.getName(),"visited")
            }
            out.println("<h2>CookieCount=" + count + "</h2>");
        }else{
            out.println("初回の訪問DA");
            Cookie newCookie=new Cookie("visited","1");
            response.addCookie(newCookie);
        }


        out.println("reqURI"+request.getRequestURI());
        out.println("reqURL"+request.getRequestURL());
        out.println("servletPath"+request.getServletPath());

        out.println("</body>");
        out.println("</html>");

    }
}