package lib.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lib.Model.Classroom;
import lib.Model.Cource;
import lib.Model.Notes;
import lib.Model.Score;
import lib.Model.User;


/**
 * @date 2018��6��8��
 * @time ����2:53:48
 */
public class CourceDao {

	//���
	public boolean CourceAdd(Connection con, Cource cource){
		
		PreparedStatement pst = null;
		String sql = "insert into cource (cource_name, credit, teacher, classroom, schooltime) values (?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, cource.getCource_name());
            pst.setString(2, cource.getCredit());
            pst.setInt(3, cource.getTeacher());
            pst.setInt(4, cource.getClassroom());
            pst.setString(5, cource.getSchooltime());
            
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //�Ƿ���ӵ��ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//ɾ��
	public boolean CourceDelete(Connection con, int id){
		PreparedStatement pst = null;
		String sql = "delete from cource where cource_id = ?";
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
    public boolean CourceModify(Connection con, Cource cource){
		
		PreparedStatement pst = null;
		String sql = "UPDATE `cource` SET `cource_name`=?,`credit`=? ,`teacher`=?,`classroom`=?,`schooltime`=?"
				+ "WHERE `cource_id` = ?";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, cource.getCource_name());
			pst.setString(2, cource.getCredit());
            pst.setInt(3, cource.getTeacher());
            pst.setInt(4, cource.getClassroom());
            pst.setString(5, cource.getSchooltime());
            pst.setInt(6, cource.getCource_id());
            int count = pst.executeUpdate();
            pst.close();  //�ر�
            return count>0 ? true:false;  //�Ƿ��޸ĵ��ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//�鿴
    public Cource CourceFindById(Connection con, int id){
		PreparedStatement pst = null;
		String sql  = "select * from cource where cource_id = ?";
		Cource cource = null;
		try {
			pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                cource = new Cource();
                cource.setCource_id(id);
                cource.setCource_name(rst.getString("cource_name"));
                cource.setCredit(rst.getString("credit"));
                cource.setTeacher(rst.getInt("teacher"));
                cource.setClassroom(rst.getInt("classroom"));
                cource.setSchooltime(rst.getString("schooltime"));

            }
            rst.close();
            pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cource;
	}
    
    //�б�
    public List<Cource> courceList(Connection con){
    	PreparedStatement pst = null;
		String sql  = "select * from cource";
		List<Cource> cources = null;
		try {
			cources = new ArrayList<Cource>();
			pst = con.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	Cource cource = new Cource();
            	cource.setCource_id(rst.getInt("cource_id"));
                cource.setCource_name(rst.getString("cource_name"));
                cource.setCredit(rst.getString("credit"));
                cource.setTeacher(rst.getInt("teacher"));
                cource.setClassroom(rst.getInt("classroom"));
                cource.setSchooltime(rst.getString("schooltime"));
                cources.add(cource);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cources;
    }
}
