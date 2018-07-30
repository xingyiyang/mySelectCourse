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
import lib.Model.User;

/**
 * @date 2018年6月8日
 * @time 上午11:03:45
 */
public class AdminDao {
	
	//获取通知列表
	public String getNotes() throws SQLException {
        NotesDao notesDao = new NotesDao();
        List<Notes> notess = new ArrayList<Notes>();
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>标题</th><th>开始时间</th><th>结束时间</th><th>公告内容</th></tr>";
        try {
            con = dbutil.getCon();
            notess = notesDao.notesList(con);
           for(Notes notes: notess) {
                str = str + "<tr>" + "<td>" + notes.getTitle() + "</td>" + "<td>" + notes.getStart_time() + "</td>" + "<td>" + notes.getStop_time() + "</td>" + "<td>" + notes.getDescription() + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">编辑</button></td>" +
                        "<td><form action=\"../deletenotes\" method=\"post\"><input name=\"notes_id\" type=\"hidden\" value=\"" + notes.getNotes_id() + "\"/><button type=\"button\" class=\"btn btn-danger\">删除</button></form></td>" + "</tr>";
           }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getUser() throws SQLException {
        
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        UserDao userDao = new UserDao();
        List<User> users = new ArrayList<User>();
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>学号</th><th>姓名</th><th>性别</th><th>年级</th><th>学院</th><th>专业</th><th>班级</th><th>QQ</th><th>电话</th><th>邮箱</th><th>地址</th><th>角色</th></tr>";
        try {
            con = dbutil.getCon();
            users = userDao.userList(con);
            for(User user: users) {
            	if(user.getRole() == 0){
            		continue;
            	}
                str = str + "<tr>" + "<td>" + user.getSchool_num() + "</td>" 
                      + "<td>" + user.getName() + "</td>" 
                	  + "<td>" + user.getSex() + "</td>" 
                	  + "<td>" + user.getGrade() + "</td>" 
                      + "<td>" + user.getSchool() + "</td>" 
                	  + "<td>" + user.getMajor() + "</td>" 
                      + "<td>" + user.getSchollclass() + "</td>" 
                	  + "<td>" + user.getQq() + "</td>" 
                      + "<td>" + user.getPhone() + "</td>" 
                	  + "<td>" + user.getEmail() + "</td>" 
                      + "<td>" + user.getAdress() + "</td>" 
                	  + "<td>" + user.getRole() + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">编辑</button></td>" +
                        "<td><form action=\"../deleteuser\" method=\"post\"><input name=\"user_id\" type=\"hidden\" value=\"" + user.getUserid() + "\"/><button type=\"button\" class=\"btn btn-danger\">删除</button></form></td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getCource() throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名称</th><th>学分</th><th>教师</th><th>上课时间</th><th>上课地点</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, name, schooltime, location from score, user, cource, classroom where teacher=user_id and cource=cource_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "<td>" + rs.getString("location") + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">编辑</button></td>" +
                        "<td><form action=\"../deletecource\" method=\"post\"><input name=\"cource_id\" type=\"hidden\" value=\"" + rs.getString("cource_id") + "\"/><button type=\"button\" class=\"btn btn-danger\">删除</button></form></td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getClassroom() throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>教室号</th><th>教室名</th><th>容纳人数</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from classroom" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("classroom_id") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "<td>" + rs.getString("capacity") + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">编辑</button></td>" +
                        "<td><form action=\"../deleteclassroom\" method=\"post\"><input name=\"classroom_id\" type=\"hidden\" value=\"" + rs.getString("classroom_id") + "\"/><button type=\"button\" class=\"btn btn-danger\">删除</button></form></td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getScource() throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名称</th><th>学分</th><th>学号</th><th>学生姓名</th><th>上课时间</th><th>上课地点</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, school_num, name, schooltime, location from score, user, cource, classroom where student=user_id and cource=cource_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getScore() throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名</th><th>学分</th><th>学号</th><th>姓名</th><th>平时成绩</th><th>期末成绩</th><th>最终成绩</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, school_num, name, pingshi_score, qimo_score, final_score from score, user, cource where student=user_id and cource=cource_id" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("pingshi_score") + "</td>" + "<td>" + rs.getString("qimo_score") + "</td>" + "<td>" + rs.getString("final_score") + "</td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    /*数据插入*/
    public Notes notesadd(Connection con, Notes notes) throws SQLException {
        PreparedStatement pst = null;

        try {
            String sql = "insert into notes (title, start_time, stop_time, description) values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, notes.getTitle());
            pst.setString(2, notes.getStart_time());
            pst.setString(3, notes.getStop_time());
            pst.setString(4, notes.getDescription());

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
