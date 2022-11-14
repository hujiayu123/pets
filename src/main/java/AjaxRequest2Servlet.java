import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxrequest2")
public class AjaxRequest2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //设置响应内容类型及字符串
        response.setContentType("text/html;charset=UTF-8");
        //获取响应源
        PrintWriter out=response.getWriter();
        //获取Ajax get请求提交的数据
        String usercode=request.getParameter("usercode");
        String username=request.getParameter("username");
        out.print("usercode="+usercode+",username="+username);
    }
}
