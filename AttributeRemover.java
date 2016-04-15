import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

//classファイルをclasses内に配置
//

public class AttributeRemover extends HttpServlet{
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
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        HttpSession session = request.getSession(false);

        if(session == null){

        }else{
            session.removeAttribute("age");
            session.removeAttribute("hoge");
        }
        response.sendRedirect(request.getContextPath()+"/sessiontest");

    }
}