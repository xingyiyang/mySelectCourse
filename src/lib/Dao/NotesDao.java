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
 * @time ����2:53:48
 */
public class NotesDao {

	//���
	public boolean NotesAdd(Connection con, Notes notes){
		
		PreparedStatement pst = null;
		String sql = "insert into notes (title, start_time, stop_time, description) values (?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, notes.getTitle());
            pst.setString(2, notes.getStart_time());
            pst.setString(3, notes.getStop_time());
            pst.setString(4, notes.getDescription());
            
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //�Ƿ���ӵ��ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//ɾ��
	public boolean NotesDelete(Connection con, int id){
		PreparedStatement pst = null;
		String sql = "delete from notes where notes_id = ?";
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            int count = pst.executeUpdate();
            pst.close();
            return count>0 ? true:false;  //�Ƿ�ɾ�����ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//�޸�
    public boolean NotesModify(Connection con, Notes notes){
		
		PreparedStatement pst = null;
		String sql = "UPDATE `notes` SET `title`=?,`start_time`=? ,`stop_time`=?,`description`=?"
				+ "WHERE `notes_id` = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, notes.getTitle());
            pst.setString(2, notes.getStart_time());
            pst.setString(3, notes.getStop_time());
            pst.setString(4, notes.getDescription());
            pst.setInt(5, notes.getNotes_id());          
            int count = pst.executeUpdate();
            pst.close();  //�ر�
            return count>0 ? true:false;  //�Ƿ��޸ĵ��ж�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//�鿴
    public Notes NotesFindById(Connection con, int id){
		PreparedStatement pst = null;
		String sql  = "select * from notes where notes_id = ?";
		Notes notes = null;
		try {
			pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                notes = new Notes();
                notes.setNotes_id(rst.getInt("notes_id"));
                notes.setTitle(rst.getString("title"));
                notes.setStart_time(rst.getString("start_time"));
                notes.setStop_time(rst.getString("stop_time"));
                notes.setDescription(rst.getString("description"));
            }
            rst.close();
            pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notes;
	}
    
    //�б�
    public List<Notes> notesList(Connection con){
    	PreparedStatement pst = null;
		String sql  = "select * from notes";
		List<Notes> notess = null;
		try {
			notess = new ArrayList<Notes>();
			pst = con.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	Notes notes = new Notes();
            	 notes.setNotes_id(rst.getInt("notes_id"));
                 notes.setTitle(rst.getString("title"));
                 notes.setStart_time(rst.getString("start_time"));
                 notes.setStop_time(rst.getString("stop_time"));
                 notes.setDescription(rst.getString("description"));
                notess.add(notes);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notess;
    }
}
