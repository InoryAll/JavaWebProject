package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MessageDao;
import DaoImp.MessageDaoImp;
import Factory.Factory;
import Main.Message;
/*
 * 消息处理服务器
 */
public class MessageAction extends HttpServlet{
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
			if(action.equals("sendMessage"))
			{
				String sender=request.getParameter("sender");
				String time=request.getParameter("time");
				String content=request.getParameter("message");
				Message msg=new Message();
				MessageDaoImp msgd=Factory.getMessageDaoImp();
				msg.setTime(time);
				msg.setSender(sender);
				msg.setContent(content);
				msg.setIsread(0);
				msgd.insertMessage(msg);
			}
			if(action.equals("getAllMessage"))
			{
				ArrayList<Message> msgList=new ArrayList<Message>();
				MessageDaoImp msgd=Factory.getMessageDaoImp();
				msgList=msgd.getAllMessage();
				String json="";
				if(msgList!=null)
				{
					for(int i=0;i<msgList.size();i++)
					{
						msgd.updateMessage(msgList.get(i));
						if(i==msgList.size()-1)
						{
							json+="{"+"\"time\":"+"\""+msgList.get(i).getTime()+"\""+","+"\"sender\":"+"\""+msgList.get(i).getSender()+"\""+","+"\"content\":"+"\""+msgList.get(i).getContent()+"\""+"}";
						}
						else
						{
							json+="{"+"\"time\":"+"\""+msgList.get(i).getTime()+"\""+","+"\"sender\":"+"\""+msgList.get(i).getSender()+"\""+","+"\"content\":"+"\""+msgList.get(i).getContent()+"\""+"}"+",";
						}				
					}
					json="["+json+"]";
					out.write(json);
				}
			}
			if(action.equals("getMessage"))
			{
				Message msg=new Message();
				MessageDaoImp msgd=Factory.getMessageDaoImp();
				msg=msgd.getMessage();
				String code="";
				String info="";
				String json="";
				if(msg!=null)
				{
					code="1";
					info+="\"sender\":"+"\""+msg.getSender()+"\""+","+"\"time\":"+"\""+msg.getTime()+"\""+","+"\"content\":"+"\""+msg.getContent()+"\"";
					//msgd.updateMessage(msg);
				}
				else
				{
					code="0";
					info+="\"content\":"+"\""+" "+"\"";
				}
				json+="{"+"\"code\":"+"\""+code+"\""+","+info+"}";
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
