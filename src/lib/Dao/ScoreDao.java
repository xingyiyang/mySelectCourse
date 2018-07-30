package lib.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lib.Model.Classroom;
import lib.Model.Notes;
import lib.Model.Score;
import lib.Model.User;


/**
 * @date 2018��6��8��
 * @time ����2:53:48
 */
public class ScoreDao {

	//���
	public boolean ScoreAdd(Connection con, Score score){
		
		PreparedStatement pst = null;
		String sql = "insert into score (student, cource, pingshi_score, qimo_score, final_score) values (?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
            pst.setInt(1, score.getStudent());
            pst.setInt(2, score.getCourse());
            pst.setString(3, score.getPingshi_score());
            pst.setString(4, score.getQimo_score());
            pst.setString(5, score.getFinal_score());
            
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //�Ƿ���ӵ��ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//ɾ��
	public boolean ScoreDelete(Connection con, int id){
		PreparedStatement pst = null;
		String sql = "delete from score where score_id = ?";
		try {
			pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //�Ƿ�ɾ�����ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//�޸�
    public boolean ScoreModify(Connection con, Score score){
		
		PreparedStatement pst = null;
		String sql = "UPDATE `score` SET `student`=?,`cource`=? ,`pingshi_score`=?,`qimo_score`=?,`final_score`=?"
				+ "WHERE `score_id` = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, score.getStudent());
			pst.setInt(2, score.getCourse());
            pst.setString(3, score.getPingshi_score());
            pst.setString(4, score.getQimo_score());
            pst.setString(5, score.getFinal_score());
            pst.setInt(6, score.getScore_id());
            int count = pst.executeUpdate();
            pst.close();  //�ر�
            return count>0 ? true:false;  //�Ƿ��޸ĵ��ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//�鿴
    public Score ScoreFindById(Connection con, int id){
		PreparedStatement pst = null;
		String sql  = "select * from score where score_id = ?";
		Score score = null;
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                score = new Score();
                score.setScore_id(id);
                score.setStudent(rst.getInt("student"));
                score.setCourse(rst.getInt("cource"));
                score.setPingshi_score(rst.getString("pingshi_score"));
                score.setQimo_score(rst.getString("qimo_score"));
                score.setFinal_score(rst.getString("final_score"));

            }
            rst.close();
            pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return score;
	}
    
    //�б�
    public List<Score> scoreList(Connection con){
    	PreparedStatement pst = null;
		String sql  = "select * from score";
		List<Score> scores = null;
		try {
			scores = new ArrayList<Score>();
			pst = con.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	Score score = new Score();
            	score.setScore_id(rst.getInt("score_id"));
                score.setStudent(rst.getInt("student"));
                score.setCourse(rst.getInt("cource"));
                score.setPingshi_score(rst.getString("pingshi_score"));
                score.setQimo_score(rst.getString("qimo_score"));
                score.setFinal_score(rst.getString("final_score"));
                scores.add(score);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scores;
    }
}
