import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

@WebServlet("/AjaxRequest6Servlet")
public class AjaxRequest6Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //准备StringBuild对象，拼接json
        StringBuilder json = new StringBuilder();
        String jsonStr = "";
        //连接数据库查询所有学生
         Connection conn = null;
         Statement stmt = null;
        //Statement rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pets_hospital","root","Hhjybaby929113");
            //获取预编译的数据库操作对象
            String sql = "select id,name,age,addr from pets";
            Statement  ps = conn.createStatement();
            //执行SQL语句
            ResultSet rs=ps.executeQuery(sql);
            //展开结果集数据库
            //处理结果集
            json.append("[");
            while (rs.next()){
                //获取每个学生的信息
                String id=rs.getString("id");
                String name=rs.getString("name");
                String age=rs.getString("age");
                String addr=rs.getString("addr");
                //拼接json格式的字符串
                json.append("{\"id\":\"");
                json.append(id);
                json.append("{\"name\":\"");
                json.append(name);
                json.append("\",\"age\":");
                json.append(age);
                json.append("\",\"addr\":");
                json.append(addr);
                json.append("\"},");
            }
            jsonStr=json.substring(0,json.length()-1)+"]";
    }catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        //响应json格式的字符给前端
        out.print(jsonStr);
        }
}



