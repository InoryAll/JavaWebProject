package Factory;

import Dao.MessageDao;
import Dao.UserDao;
import DaoImp.MessageDaoImp;
import DaoImp.UserDaoImp;

/*
 * 工厂：负责分发接口对象
 */
public class Factory {
	public static UserDaoImp getUserDaoImp(){
		return new UserDao();
	}
	public static MessageDaoImp getMessageDaoImp(){
		return new MessageDao();
	}
}
