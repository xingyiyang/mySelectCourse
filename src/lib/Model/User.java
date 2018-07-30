package lib.Model;

/**
 * @date 2018年6月7日
 * @time 下午11:00:16
 */
public class User {

	private int user_id;
	private String school_num;
    private String name;
    private String sex;
    private String grade;
    private String school;
    private String major;
    private String schollclass;
    private String email;
    private String password;
    private int role;
    private String qq;
    private String phone;
    private String adress;
    
    public User(){
    	super();
    }
    
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}



	public int getUserid() {
		return user_id;
	}
	public void setUserid(int user_id) {
		this.user_id = user_id;
	}
	public String getSchool_num() {
		return school_num;
	}
	public void setSchool_num(String school_num) {
		this.school_num = school_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSchollclass() {
		return schollclass;
	}
	public void setSchollclass(String schollclass) {
		this.schollclass = schollclass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	@Override
	public String toString() {
		return "Classroom [user_id=" + user_id + ", school_num=" + school_num + ", name=" + name + ", sex=" + sex
				+ ", grade=" + grade + ", school=" + school + ", major=" + major + ", schollclass=" + schollclass
				+ ", email=" + email + ", password=" + password + ", role=" + role + ", qq=" + qq + ", phone=" + phone
				+ ", adress=" + adress + "]";
	}
}
