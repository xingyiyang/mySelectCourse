package lib.Model;

/**
 * @date 2018年6月7日
 * @time 下午11:01:52
 */
public class Classroom {
	
	private int classroom_id;
	private int capacity;
	private String location;
	
	public int getClassroom_id() {
		return classroom_id;
	}
	public void setClassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Classroom [classroom_id=" + classroom_id + ", capacity=" + capacity + ", location=" + location + "]";
	}

}
