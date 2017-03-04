package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DaoImp.MessageDaoImp;
import Main.Message;
import Util.DButil;

/*
 * Message类方法：发送消息，显示最新消息，显示所有消息,更新消息状态,测试方法
 */
public class MessageDao implements MessageDaoImp{
	public boolean insertMessage(Message msg){
		Connection conn=DButil.getConnection();
		Statement stmt=null;
		String sql="insert into message(time,sender,content,isread) values('"+msg.getTime()+"','"+msg.getSender()+"','"+msg.getContent()+"',"+msg.getIsread()+")";
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.close(conn, stmt, null);
		}
		return false;
	}
	public boolean updateMessage(Message msg){
		Connection conn=DButil.getConnection();
		Statement stmt=null;
		String sql="update message set isread=1 where isread='"+msg.getIsread()+"'";
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.close(conn, stmt, null);
		}
		return false;
	}
	public Message getMessage(){
		Connection conn=DButil.getConnection();
		Statement stmt=null;
		String sql="select * from message where isread="+0+"";
		ResultSet rs=null;
		Message msg=new Message();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				msg.setTime(rs.getString("time"));
				msg.setSender(rs.getString("sender"));
				msg.setContent(rs.getString("content"));
				msg.setIsread(rs.getInt("isread"));
			}
			if(msg.getTime()==null)
			{
				return null;
			}
			else
			{
				return msg;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.close(conn, stmt, rs);
		}
		return null;
	}
	public ArrayList<Message> getAllMessage(){
		Connection conn=DButil.getConnection();
		Statement stmt=null;
		String sql="select * from message";
		ResultSet rs=null;
		ArrayList<Message> messageList=new ArrayList<Message>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Message newMessage=new Message();
				newMessage.setTime(rs.getString("time"));
				newMessage.setSender(rs.getString("sender"));
				newMessage.setContent(rs.getString("content"));
				newMessage.setIsread(rs.getInt("isread"));
				messageList.add(newMessage);
			}
			if(messageList.size()==0)
			{
				return null;
			}
			else
			{
				return messageList;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.close(conn, stmt, rs);
		}
		return null;
	} 
	public static void main(String[] args) {
		MessageDao msgd=new MessageDao();
		Message msg=new Message();
		ArrayList<Message> messageList=new ArrayList<Message>();
		msg.setTime("2017-2-13 13:37:52");
		msg.setSender("110873204");
		msg.setContent("Hello World!");
		msg.setIsread(0);
		if(msgd.insertMessage(msg)){
			System.out.println("Success!");
			msg=msgd.getMessage();
			System.out.println(msg.getTime()+"\n"+msg.getSender()+"\n"+msg.getContent()+"\n"+msg.getIsread());
			msgd.updateMessage(msg);
			messageList=msgd.getAllMessage();
			System.out.println(messageList.get(0).getTime()+"\n"+messageList.get(0).getSender()+"\n"+messageList.get(0).getContent()+"\n"+messageList.get(0).getIsread());
		}
		else
		{
			System.out.println("Fail!");
		}
	}
}
