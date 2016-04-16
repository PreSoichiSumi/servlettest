import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class TestFilter implements Filter{

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            request.setAttribute("filter","added data");
            System.out.println("filterpassed-----------");
            chain.doFilter(request,response);
        }catch (ServletException se){
        }catch (IOException e){
        }
    }

    public void init(FilterConfig filterConfig){

    }

    public void destroy(){

    }
}