package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import DaoImp.UserDaoImp;
import Factory.Factory;
import Main.User;
/*
 * 用户处理服务器
 */
public class UserAction extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		if(action!=null)
		{
			if(action.equals("login"))
			{
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				UserDaoImp usd=Factory.getUserDaoImp();
				User us=new User();
				us=usd.login(username);
				String message="";
				String code="";
				String json="";
				if(us==null)
				{
					code="0";
					message="用户不存在!";	
				}
				else
				{
					if(!us.getPassword().equals(password))
					{
						code="0";
						message="密码不正确!";
					}
					else
					{
						code="1";
						message="登陆成功!";
					}
				}
				json="{"+"\"code\":"+"\""+code+"\""+","+"\"message\":"+"\""+message+"\""+"}";
				out.write(json);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
