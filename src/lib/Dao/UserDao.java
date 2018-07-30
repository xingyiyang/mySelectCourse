package lib.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.Model.Classroom;
import lib.Model.User;

/**
 * @date 2018年6月8日
 * @time 上午10:33:12
 */
public class UserDao {
	
	//登录
	public User signin (Connection con, User user) throws SQLException{
        User resultUser = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "select * from user where email=? and password=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                resultUser = new User();
                resultUser.setEmail(rs.getString("email"));
                resultUser.setPassword(rs.getString("password"));
                resultUser.setRole(rs.getInt("role"));
                resultUser.setName(rs.getString("name"));
            }

            return resultUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
	
	//添加用户
	public boolean UserAdd(Connection con, User user) throws SQLException{
		
		PreparedStatement pst = null;
		String sql = "insert into user (school_num, name, sex, grade, school, major, qq, phone, email, password, adress, role) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
        try {
           
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getSchool_num());
            pst.setString(2, user.getName());
            pst.setString(3, user.getSex());
            pst.setString(4, user.getGrade());
            pst.setString(5, user.getSchool());
            pst.setString(6, user.getMajor());
            pst.setString(7, user.getQq());
            pst.setString(8, user.getPhone());
            pst.setString(9, user.getEmail());
            pst.setString(10, user.getPassword());
            pst.setString(11, user.getAdress());
            pst.setString(12, String.valueOf(user.getRole()));        
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //是否添加的判断
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
		
	}
	
	//删除用户
	public boolean UserDelete(Connection con, int id){
		
		PreparedStatement pst = null;
		String sql = "delete from user where user_id = ?";
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //是否删除的判断
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//修改用户
	public boolean UserModify(Connection con, User user){
		
		PreparedStatement pst = null;
		String sql = "UPDATE `user` SET `school_num`=?,`name`=? ,`sex`=?,`grade`=?,`school`=?,`major`=?,`class`=?,`qq`=?,`phone`=?,`email`=?,`password`=?,`adress`=?,`role`=?"
				+ "WHERE `user_id` = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getSchool_num());
            pst.setString(2, user.getName());
            pst.setString(3, user.getSex());
            pst.setString(4, user.getGrade());
            pst.setString(5, user.getSchool());
            pst.setString(6, user.getMajor());
            pst.setString(7, user.getSchollclass());
            pst.setString(8, user.getQq());
            pst.setString(9, user.getPhone());
            pst.setString(10, user.getEmail());
            pst.setString(11, user.getPassword());
            pst.setString(12, user.getAdress());
            pst.setString(13, String.valueOf(user.getRole()));
            pst.setString(14, String.valueOf(user.getUserid()));
            int count = pst.executeUpdate();
            pst.close();  //关闭
            return count>0 ? true:false;  //是否修改的判断
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//查看用户
	public User UserFindById(Connection con, int id){
		PreparedStatement pst = null;
		String sql  = "select * from user where user_id = ?";
		User user = null;
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                user = new User();
                user.setUserid(rst.getInt("user_id"));
                user.setSchool_num(rst.getString("school_num"));
                user.setName(rst.getString("name"));
                user.setSex(rst.getString("grade"));
                user.setSchool(rst.getString("major"));
                user.setSchollclass(rst.getString("class"));
                user.setQq(rst.getString("qq"));
                user.setPhone(rst.getString("phone"));
                user.setEmail(rst.getString("email"));
                user.setPassword(rst.getString("password"));
                user.setAdress(rst.getString("adress"));
                user.setRole(rst.getInt("role"));
            }
            rst.close();
            pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//列表
	public List<User> userList(Connection con){
    	PreparedStatement pst = null;
		String sql  = "select * from user";
		List<User> users = null;
		try {
			users = new ArrayList<User>();
			pst = con.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	User user = new User();
            	user.setUserid(rst.getInt("user_id"));
                user.setSchool_num(rst.getString("school_num"));
                user.setName(rst.getString("name"));
                user.setSex(rst.getString("sex"));
                user.setGrade(rst.getString("grade"));
                user.setSchool(rst.getString("school"));
                user.setMajor(rst.getString("major"));
                user.setSchollclass(rst.getString("class"));
                user.setQq(rst.getString("qq"));
                user.setPhone(rst.getString("phone"));
                user.setEmail(rst.getString("email"));
                user.setPassword(rst.getString("password"));
                user.setAdress(rst.getString("adress"));
                user.setRole(rst.getInt("role"));
                users.add(user);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
    }

}
