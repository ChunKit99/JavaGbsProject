
package basic;

/**
 *
 * @author WoeiChi Liong
 */
public class TimeSlot {
	public final int ID;
	private String timeStart;
	private String timeEnd;

	public TimeSlot(int ID, String timeStart, String timeEnd) {
		this.ID = ID;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public String findNameTime() {
		return timeStart + " to " + timeEnd;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
		
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
		
	}

}
