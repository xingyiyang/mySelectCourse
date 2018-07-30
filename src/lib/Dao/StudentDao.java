package lib.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lib.Model.Notes;

/**
 * @date 2018��6��8��
 * @time ����11:05:55
 */
public class StudentDao {

	public String getNotes() throws SQLException{
       
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        NotesDao notesDao = new NotesDao();
        List<Notes> notess = new ArrayList<Notes>();
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>����</th><th>��ʼʱ��</th><th>����ʱ��</th><th>��������</th></tr>";
        try{
            con = dbutil.getCon();
            notess = notesDao.notesList(con);
            for(Notes notes: notess) {
                str = str + "<tr>" + "<td>" + notes.getTitle() + "</td>" 
                + "<td>" + notes.getStart_time() + "</td>" 
                + "<td>" + notes.getStop_time() + "</td>" 
                + "<td>" + notes.getDescription() + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getScore(String email) throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>�γ̺�</th><th>�γ���</th><th>ѧ��</th><th>ƽʱ�ɼ�</th><th>��ĩ�ɼ�</th><th>���ճɼ�</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, pingshi_score, qimo_score, final_score from score, user, cource where student=user_id and cource=cource_id AND email='" + email + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("pingshi_score") + "</td>" + "<td>" + rs.getString("qimo_score") + "</td>" + "<td>" + rs.getString("final_score") + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getScource(String email) throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>�γ̺�</th><th>�γ�����</th><th>ѧ��</th><th>�Ͽ�ʱ��</th><th>�Ͽεص�</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, schooltime, location from score, user, cource, classroom where student=user_id and cource=cource_id and classroom=classroom_id AND email='" + email + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getUser(String email) throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>ѧ��</th><th>����</th><th>�Ա�</th><th>�꼶</th><th>ѧԺ</th><th>רҵ</th><th>�༶</th><th>QQ</th><th>�绰</th><th>����</th><th>��ַ</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from user WHERE email='" + email + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" 
                      + "<td>" + rs.getString("name") + "</td>" 
                	  + "<td>" + rs.getString("sex") + "</td>" 
                      + "<td>" + rs.getString("grade") + "</td>" 
                	  + "<td>" + rs.getString("school") + "</td>" 
                      + "<td>" + rs.getString("major") + "</td>" 
                	  + "<td>" + rs.getString("class") + "</td>" 
                      + "<td>" + rs.getString("qq") + "</td>" 
                	  + "<td>" + rs.getString("phone") + "</td>" 
                      + "<td>" + rs.getString("email") + "</td>" 
                	  + "<td>" + rs.getString("adress") + "</td>" 
                      
                	  + "<td><button type=\"button\" class=\"btn btn-success\">�༭</button></td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
