
package basic;

import java.time.LocalDate;

/**
 *
 * @author Liew Chun Kit
 */
public class BookingGym {

	public final int ID;
	private String customer;// username customer
	private LocalDate date;
	private GymRoom gymRoom;
	private TimeSlot timeSlot;

	public BookingGym(int ID, String customer, LocalDate date, GymRoom gymRoom, TimeSlot timeSlot) {
		this.ID = ID;
		this.customer = customer;
		this.date = date;
		this.gymRoom = gymRoom;
		this.timeSlot = timeSlot;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public GymRoom getGymRoom() {
		return gymRoom;
	}

	public void setGymRoom(GymRoom gymRoom) {
		this.gymRoom = gymRoom;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	

}
