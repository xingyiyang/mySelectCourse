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
 * @date 2018��6��8��
 * @time ����11:03:45
 */
public class AdminDao {
	
	//��ȡ֪ͨ�б�
	public String getNotes() throws SQLException {
        NotesDao notesDao = new NotesDao();
        List<Notes> notess = new ArrayList<Notes>();
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>����</th><th>��ʼʱ��</th><th>����ʱ��</th><th>��������</th></tr>";
        try {
            con = dbutil.getCon();
            notess = notesDao.notesList(con);
           for(Notes notes: notess) {
                str = str + "<tr>" + "<td>" + notes.getTitle() + "</td>" + "<td>" + notes.getStart_time() + "</td>" + "<td>" + notes.getStop_time() + "</td>" + "<td>" + notes.getDescription() + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">�༭</button></td>" +
                        "<td><form action=\"../deletenotes\" method=\"post\"><input name=\"notes_id\" type=\"hidden\" value=\"" + notes.getNotes_id() + "\"/><button type=\"button\" class=\"btn btn-danger\">ɾ��</button></form></td>" + "</tr>";
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
                "<tr><th>ѧ��</th><th>����</th><th>�Ա�</th><th>�꼶</th><th>ѧԺ</th><th>רҵ</th><th>�༶</th><th>QQ</th><th>�绰</th><th>����</th><th>��ַ</th><th>��ɫ</th></tr>";
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
                        "<td><button type=\"button\" class=\"btn btn-success\">�༭</button></td>" +
                        "<td><form action=\"../deleteuser\" method=\"post\"><input name=\"user_id\" type=\"hidden\" value=\"" + user.getUserid() + "\"/><button type=\"button\" class=\"btn btn-danger\">ɾ��</button></form></td>" + "</tr>";
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
                "<tr><th>�γ̺�</th><th>�γ�����</th><th>ѧ��</th><th>��ʦ</th><th>�Ͽ�ʱ��</th><th>�Ͽεص�</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, name, schooltime, location from score, user, cource, classroom where teacher=user_id and cource=cource_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "<td>" + rs.getString("location") + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">�༭</button></td>" +
                        "<td><form action=\"../deletecource\" method=\"post\"><input name=\"cource_id\" type=\"hidden\" value=\"" + rs.getString("cource_id") + "\"/><button type=\"button\" class=\"btn btn-danger\">ɾ��</button></form></td>" + "</tr>";
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
                "<tr><th>���Һ�</th><th>������</th><th>��������</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from classroom" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("classroom_id") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "<td>" + rs.getString("capacity") + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">�༭</button></td>" +
                        "<td><form action=\"../deleteclassroom\" method=\"post\"><input name=\"classroom_id\" type=\"hidden\" value=\"" + rs.getString("classroom_id") + "\"/><button type=\"button\" class=\"btn btn-danger\">ɾ��</button></form></td>" + "</tr>";
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
                "<tr><th>�γ̺�</th><th>�γ�����</th><th>ѧ��</th><th>ѧ��</th><th>ѧ������</th><th>�Ͽ�ʱ��</th><th>�Ͽεص�</th></tr>";
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
                "<tr><th>�γ̺�</th><th>�γ���</th><th>ѧ��</th><th>ѧ��</th><th>����</th><th>ƽʱ�ɼ�</th><th>��ĩ�ɼ�</th><th>���ճɼ�</th></tr>";
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


    /*���ݲ���*/
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
