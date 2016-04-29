import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//入力された値が正しいかチェック
public class LoginCheck extends HttpServlet {
    protected Connection conn = null;

    public void init() throws ServletException {
        String url="jdbc:mysql://localhost/auth";
        String user="root";
        String pass="sumi1375";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection(url,user,pass);
        }catch (ClassNotFoundException e){
            log("ClassNotFoundException:" + e.getMessage());
        }catch (SQLException e){
            log("SQLException:" + e.getMessage());
        }catch (Exception e){
            log("Exception:" + e.getMessage());
        }
    }


    public void destroy(){
        try{
            if(conn!=null)conn.close();
        }catch (SQLException e){
            log("SQLException:" + e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession(true);

        boolean check = authUser(user, pass);
        if (check) {
            session.setAttribute("login", "OK");

            String target = (String) session.getAttribute("target");
            response.sendRedirect(target);
        } else {
            session.setAttribute("status", "Not Auth");
            response.sendRedirect("/hello/login");
        }
    }

    protected boolean authUser(String user, String pass) {
        if (user == null || user.length() == 0 ||
                pass == null || pass.length() == 0) {
            return false;
        }

        try{
            String sql="SELECT * FROM user_table WHERE user = ? && pass = ?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user);
            pstmt.setString(2,pass);
            ResultSet rs =pstmt.executeQuery();

            if(rs.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            log("SQLException:" + e.getMessage());
            return false;
        }
    }
}