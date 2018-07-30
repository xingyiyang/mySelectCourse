package lib.Test;

import java.sql.Connection;
import java.util.List;

import lib.Dao.CourceDao;
import lib.Dao.Dbutil;
import lib.Dao.NotesDao;
import lib.Dao.ScoreDao;
import lib.Dao.UserDao;
import lib.Model.Cource;
import lib.Model.Notes;
import lib.Model.Score;
import lib.Model.User;

/**
 * @date 2018年6月8日
 * @time 下午3:01:38
 */
public class CourceDaoTest {
	
	public static void addTest(){
		CourceDao courceDao = new CourceDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Cource cource = new Cource();
		try {
			con = dbutil.getCon();
			cource.setCource_name("软件工程");
			cource.setCredit("3");
			cource.setTeacher(3);
			cource.setClassroom(4);
			cource.setSchooltime("周二7,8节；周六3,4节；[第8-10周]");
			boolean b = courceDao.CourceAdd(con, cource);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTest(){
		CourceDao courceDao = new CourceDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 5;
			boolean b = courceDao.CourceDelete(con, id);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifyTest(){
		CourceDao courceDao = new CourceDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Cource cource = new Cource();
		try {
			con = dbutil.getCon();
			cource.setCource_id(5);
			cource.setCource_name("软件工程需求");
			cource.setCredit("3");
			cource.setTeacher(3);
			cource.setClassroom(4);
			cource.setSchooltime("周二7,8节；周六3,4节；[第8-10周]");
			
			boolean b = courceDao.CourceModify(con, cource);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findTest(){
		CourceDao courceDao = new CourceDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 5;
			Cource cource = courceDao.CourceFindById(con, id);
			System.out.println(cource.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private static void getList() {
		
		CourceDao courceDao = new CourceDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			
			List<Cource> cources = courceDao.courceList(con);
			for(Cource cource:cources){
				System.out.println(cource.toString());
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
