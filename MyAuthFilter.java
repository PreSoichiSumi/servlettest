import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

//認証が通っているならリクエストを通し，通っていなければ
//ログインページに飛ばす
public class MyAuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            //ログインページに飛ばした場合に，ログイン後どこに飛べばいいかを伝えるため
            //sessionに登録しておく
            String target=((HttpServletRequest)request).getRequestURI();

            HttpSession session=((HttpServletRequest)request).getSession(false);

            if(session==null){
                session=((HttpServletRequest)request).getSession(true);
                session.setAttribute("target",target);
                ((HttpServletResponse)response).sendRedirect("/hello/login");
            }else{
                Object loginCheck=session.getAttribute("login");
                if(loginCheck==null){
                    session.setAttribute("target",target);
                    ((HttpServletResponse)response).sendRedirect("/hello/login");
                }
            }


            chain.doFilter(request, response);
        } catch (ServletException se) {
        } catch (IOException e) {
        }
    }

    public void init(FilterConfig filterConfig) {

    }

    public void destroy() {

    }
}