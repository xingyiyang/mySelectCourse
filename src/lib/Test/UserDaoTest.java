package lib.Test;

import java.sql.Connection;
import java.util.List;

import lib.Dao.Dbutil;
import lib.Dao.UserDao;
import lib.Model.User;

/**
 * @date 2018年6月8日
 * @time 下午3:01:38
 */
public class UserDaoTest {
	
	
	public static void signTest(){
		UserDao userDao = new UserDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		User user = new User();
		try {
			con = dbutil.getCon();
			user.setEmail("admin@qq.com");
			user.setPassword("passwd");
			User user2 = userDao.signin(con, user);
			if(user2!=null){
				System.out.println(user2.toString());
			}else{
				System.out.println("false");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addTest(){
		UserDao userDao = new UserDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		User user = new User();
		try {
			con = dbutil.getCon();
			user.setSchool_num("123456");
			user.setName("teacher");
			user.setSex("男");
			user.setGrade("2018");
			user.setSchool("计算机学院");
			user.setMajor("计算机技术");
			user.setSchollclass("计科");
			user.setQq("987654321");
			user.setPhone("1234567890");
			user.setEmail("987654321@qq.com");
			user.setPassword("passwd");
			user.setAdress("海南省儋州市");
			user.setRole(1);
			boolean b = userDao.UserAdd(con, user);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTest(){
		UserDao userDao = new UserDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 6;
			boolean b = userDao.UserDelete(con, id);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifyTest(){
		UserDao userDao = new UserDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		User user = new User();
		try {
			con = dbutil.getCon();
			user.setUserid(6);
			user.setSchool_num("123456");
			user.setName("teacher");
			user.setSex("男");
			user.setGrade("2017");
			user.setSchool("计算机学院");
			user.setMajor("计算机技术");
			user.setSchollclass("计科");
			user.setQq("987654321");
			user.setPhone("1234567890");
			user.setEmail("987654321@qq.com");
			user.setPassword("passwd");
			user.setAdress("海南省儋州市");
			user.setRole(1);
			boolean b = userDao.UserModify(con, user);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findTest(){
		UserDao userDao = new UserDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 6;
			User user = userDao.UserFindById(con, id);
			System.out.println(user.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private static void getList() {
		
		UserDao userDao = new UserDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();			
			List<User> users = userDao.userList(con);
			for(User user:users){
				System.out.println(user.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//signTest();
		//addTest();
		//modifyTest();
		//findTest();
		//deleteTest();
		getList();
	}


}
