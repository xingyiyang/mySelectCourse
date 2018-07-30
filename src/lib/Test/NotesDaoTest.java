package lib.Test;

import java.sql.Connection;
import java.util.List;

import lib.Dao.Dbutil;
import lib.Dao.NotesDao;
import lib.Dao.UserDao;
import lib.Model.Notes;
import lib.Model.User;

/**
 * @date 2018��6��8��
 * @time ����3:01:38
 */
public class NotesDaoTest {
	
	public static void addTest(){
		NotesDao notesDao = new NotesDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Notes notes = new Notes();
		try {
			con = dbutil.getCon();
			notes.setTitle("���ڴ��ѡ��֪ͨ");
			notes.setStart_time("2018-06-08");
			notes.setStop_time("2018-12-29");
			notes.setDescription("ѡ��ʱ���ѡ�εĿγ��Ѿ����ţ�ϣ����Ҽ�ʱѡ��");
			boolean b = notesDao.NotesAdd(con, notes);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTest(){
		NotesDao notesDao = new NotesDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 2;
			boolean b = notesDao.NotesDelete(con, id);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifyTest(){
		NotesDao notesDao = new NotesDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		Notes notes = new Notes();
		try {
			con = dbutil.getCon();
			notes.setNotes_id(2);
			notes.setTitle("���ڴ��ѡ��֪ͨ");
			notes.setStart_time("2018-06-08");
			notes.setStop_time("2018-09-29");
			notes.setDescription("ѡ��ʱ���ѡ�εĿγ��Ѿ����ţ�ϣ����Ҽ�ʱѡ��");
			boolean b = notesDao.NotesModify(con, notes);
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findTest(){
		NotesDao notesDao = new NotesDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			int id = 2;
			Notes notes = notesDao.NotesFindById(con, id);
			System.out.println(notes.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private static void getList() {
		NotesDao notesDao = new NotesDao();
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		
		try {
			con = dbutil.getCon();
			List<Notes> notes = notesDao.notesList(con);
			for(Notes note: notes){
				System.out.println(note.toString());
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
