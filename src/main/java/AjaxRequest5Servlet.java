import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxrequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        //连接数据库，拼接html代码
        StringBuilder html=new StringBuilder();
        html.append("  <tr>");
        html.append("<td>1</td>  ");
        html.append("<td>张三</td>  ");
        html.append("<td>21</td>  ");
        html.append("<td>北京海淀</td>  ");
        html.append("</tr>");
        html.append("  <tr>");
        html.append("<td>2</td>  ");
        html.append("<td>李四</td>  ");
        html.append("<td>21</td>  ");
        html.append("<td>北京朝阳</td>  ");
        html.append("</tr>");
        out.print(html.toString());
//        String jsonStr="[{\"name\":\"vivi\",\"age\":2,\"addr\":\"北京海淀\"},{\"name\":\"guang\",\"age\":4,\"addr\":\"北京大兴\"}]";
//        out.print(jsonStr);
    }
}
