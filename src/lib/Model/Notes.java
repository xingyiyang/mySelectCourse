package lib.Model;

/**
 * @date 2018年6月7日
 * @time 下午11:01:03
 */
public class Notes {
	private int notes_id;
    private String title;
    private String start_time;
    private String stop_time;
    private String description;
    
	public int getNotes_id() {
		return notes_id;
	}
	public void setNotes_id(int notes_id) {
		this.notes_id = notes_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getStop_time() {
		return stop_time;
	}
	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Notes [notes_id=" + notes_id + ", title=" + title + ", start_time=" + start_time + ", stop_time="
				+ stop_time + ", description=" + description + "]";
	}

}
