package lib.Test;

import java.sql.Connection;
import java.util.List;

import lib.Dao.Dbutil;
import lib.Dao.NotesDao;
import lib.Dao.ScoreDao;
import lib.Dao.UserDao;
import lib.Model.Notes;
import lib.Model.Score;
import lib.Model.User;

/**
 * @date 2018年6月8日
 * @time 下午3:01:38
 */
public class ScoreDaoTest {
	
	public static void addTest(){
		ScoreDao scoreDao = new ScoreDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Score score = new Score();
		try {
			con = dbutil.getCon();
			score.setStudent(5);
			score.setCourse(3);
			score.setPingshi_score("60");
			score.setQimo_score("60");
			score.setFinal_score("60");
			boolean b = scoreDao.ScoreAdd(con, score);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTest(){
		ScoreDao scoreDao = new ScoreDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 4;
			boolean b = scoreDao.ScoreDelete(con, id);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifyTest(){
		ScoreDao scoreDao = new ScoreDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Score score = new Score();
		try {
			con = dbutil.getCon();
			score.setScore_id(4);
			score.setStudent(5);
			score.setCourse(3);
			score.setPingshi_score("60");
			score.setQimo_score("60");
			score.setFinal_score("66");
			
			boolean b = scoreDao.ScoreModify(con, score);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findTest(){
		ScoreDao scoreDao = new ScoreDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 4;
			Score score = scoreDao.ScoreFindById(con, id);
			System.out.println(score.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	private static void getList() {
		
		ScoreDao scoreDao = new ScoreDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();			
			List<Score> scores = scoreDao.scoreList(con);
			for(Score score:scores){
				System.out.println(score.toString());
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
