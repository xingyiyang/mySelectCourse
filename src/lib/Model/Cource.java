package lib.Model;

/**
 * @date 2018年6月8日
 * @time 下午5:25:44
 */
public class Cource {
	
	private int cource_id;
	private String cource_name;
	private String credit;
	private int teacher;
	private int classroom;
	private String schooltime;
	
	public int getCource_id() {
		return cource_id;
	}
	public void setCource_id(int cource_id) {
		this.cource_id = cource_id;
	}
	public String getCource_name() {
		return cource_name;
	}
	public void setCource_name(String cource_name) {
		this.cource_name = cource_name;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public int getTeacher() {
		return teacher;
	}
	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public String getSchooltime() {
		return schooltime;
	}
	public void setSchooltime(String schooltime) {
		this.schooltime = schooltime;
	}
	
	@Override
	public String toString() {
		return "Cource [cource_id=" + cource_id + ", cource_name=" + cource_name + ", credit=" + credit + ", teacher="
				+ teacher + ", classroom=" + classroom + ", schooltime=" + schooltime + "]";
	}


}
