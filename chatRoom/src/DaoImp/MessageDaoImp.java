package DaoImp;

import java.util.ArrayList;

import Main.Message;
/*
 * Message类接口：提供Message类各方法的接口，包括发送消息，显示最新消息，显示所有消息,更新消息状态
 */
public interface MessageDaoImp {
	public boolean insertMessage(Message msg);
	public boolean updateMessage(Message msg);
	public Message getMessage();
	public ArrayList<Message> getAllMessage();
}
