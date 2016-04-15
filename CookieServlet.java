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
    final int MAX_AGE=60;
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


        Cookie cookie[]=request.getCookies();//cookieはKeyValueな感じで格納される
        Cookie visitedCookie=null;

        if(cookie !=null) {
            for(Cookie c:cookie){
                if(Objects.equals(c.getName(),"visited")){
                    visitedCookie=c;
                }
            }
            if(visitedCookie!=null) {
                int visited=Integer.parseInt(visitedCookie.getValue())+1;
                out.println("<h2>CookieCount=" + visited + "</h2>");

                visitedCookie.setValue(Integer.toString(visited));
                visitedCookie.setMaxAge(MAX_AGE);
                response.addCookie(visitedCookie);

            }else{
                out.println("初回の訪問DA．他にも何かある");
                Cookie newCookie=new Cookie("visited","1");
                newCookie.setMaxAge(MAX_AGE);
                response.addCookie(newCookie);
            }
        }else{
            out.println("初回の訪問DA");
            Cookie newCookie=new Cookie("visited","1");
            newCookie.setMaxAge(MAX_AGE);
            response.addCookie(newCookie);
        }

        out.println("<a href=\"/hello/cookietest\">再表示</a>");
        out.println("<br>");
        out.println("reqURI: "+request.getRequestURI());
        out.println("<br>");
        out.println("reqURL: "+request.getRequestURL());
        out.println("<br>");
        out.println("servletPath: "+request.getServletPath());
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");

    }
}