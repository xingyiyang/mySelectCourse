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
 * @date 2018年6月8日
 * @time 下午2:53:48
 */
public class ClassroomDao {

	//添加
	public boolean ClassroomAdd(Connection con, Classroom classroom){
		
		PreparedStatement pst = null;
		String sql = "insert into classroom (capacity, location) values (?,?)";
		try {
			pst = con.prepareStatement(sql);
            pst.setInt(1, classroom.getCapacity());
            pst.setString(2, classroom.getLocation());
            
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //是否添加的判断
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//删除
	public boolean ClassroomDelete(Connection con, int id){
		PreparedStatement pst = null;
		String sql = "delete from classroom where classroom_id = ?";
		try {
			pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //是否删除的判断
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//修改
    public boolean ClassroomModify(Connection con, Classroom classroom){
		
		PreparedStatement pst = null;
		String sql = "UPDATE `classroom` SET `capacity`=?,`location`=?"
				+ "WHERE `classroom_id` = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, classroom.getCapacity());
			pst.setString(2, classroom.getLocation());
            pst.setInt(3, classroom.getClassroom_id());
            int count = pst.executeUpdate();
            pst.close();  //关闭
            return count>0 ? true:false;  //是否修改的判断
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//查看
    public Classroom ClassroomFindById(Connection con, int id){
		PreparedStatement pst = null;
		String sql  = "select * from classroom where classroom_id = ?";
		Classroom classroom = null;
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                classroom = new Classroom();
                classroom.setClassroom_id(id);
                classroom.setCapacity(rst.getInt("capacity"));
                classroom.setLocation(rst.getString("location"));

            }
            rst.close();
            pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classroom;
	}
    
    //列表
    public List<Classroom> classroomList(Connection con){
    	PreparedStatement pst = null;
		String sql  = "select * from classroom";
		List<Classroom> classrooms = null;
		try {
			classrooms = new ArrayList<Classroom>();
			pst = con.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	Classroom classroom = new Classroom();
                classroom.setClassroom_id(rst.getInt("classroom_id"));
                classroom.setCapacity(rst.getInt("capacity"));
                classroom.setLocation(rst.getString("location"));
                classrooms.add(classroom);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classrooms;
    }
}
