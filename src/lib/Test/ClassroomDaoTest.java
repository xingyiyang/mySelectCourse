package lib.Test;

import java.sql.Connection;
import java.util.List;

import lib.Dao.ClassroomDao;
import lib.Dao.CourceDao;
import lib.Dao.Dbutil;
import lib.Dao.NotesDao;
import lib.Dao.ScoreDao;
import lib.Dao.UserDao;
import lib.Model.Classroom;
import lib.Model.Cource;
import lib.Model.Notes;
import lib.Model.Score;
import lib.Model.User;

/**
 * @date 2018年6月8日
 * @time 下午3:01:38
 */
public class ClassroomDaoTest {
	
	public static void addTest(){
		ClassroomDao classroomDao = new ClassroomDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Classroom classroom = new Classroom();
		try {
			con = dbutil.getCon();
			classroom.setCapacity(100);
			classroom.setLocation("6#");
			boolean b = classroomDao.ClassroomAdd(con, classroom);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTest(){
		ClassroomDao classroomDao = new ClassroomDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 5;
			boolean b = classroomDao.ClassroomDelete(con, id);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifyTest(){
		ClassroomDao classroomDao = new ClassroomDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Classroom classroom = new Classroom();
		try {
			con = dbutil.getCon();
			classroom.setClassroom_id(5);
			classroom.setCapacity(101);
			classroom.setLocation("6#306");
			
			boolean b = classroomDao.ClassroomModify(con, classroom);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findTest(){
		ClassroomDao classroomDao = new ClassroomDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 5;
			Classroom classroom = classroomDao.ClassroomFindById(con, id);
			System.out.println(classroom.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void getList(){
		ClassroomDao classroomDao = new ClassroomDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			List<Classroom> classrooms = classroomDao.classroomList(con);
			for(Classroom classroom:classrooms){
				System.out.println(classroom.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		//addTest();
		//modifyTest();
		//findTest();
		//deleteTest();
		getList();
	}

}
