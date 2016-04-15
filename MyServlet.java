import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//classファイルをclasses内に配置
//

public class MyServlet extends HttpServlet{
    int count=0;

    @Override
    public void init() throws ServletException{
        count=100;
        log("カウント開始");
    }

    @Override
    public void destroy(){
        log("最終値は"+count+"です");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String param=request.getParameter("name");
        if(!request.getParameterNames().hasMoreElements() ) {
            response.setStatus(200);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello World!</h1>");
            count++;
            out.println("<h2>count=" + count + "</h2>");
            out.println("reqURI"+request.getRequestURI());
            out.println("reqURL"+request.getRequestURL());
            out.println("servletPath"+request.getServletPath());

            out.println("</body>");
            out.println("</html>");
        }else if(param!=null && param!=""){
            response.setStatus(200);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello World!</h1>");
            count++;
            out.println("<h2>count=" + count + "</h2>");
            out.println("<h2>name=" + param + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}