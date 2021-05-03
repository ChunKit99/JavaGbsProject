
package basic;

/**
 *
 * @author Angie
 * This is GymRoom class, function to set ID, name, level
 */
public class GymRoom {
	public final int ID;
	private String name;
	private String level;
	
	//constructor
	public GymRoom(int ID, String name, String level) {
		this.ID = ID;
		this.name = name;
		this.level = level;
	}
        
        /*public int getID(){
            return ID;
        }
        
        /*public void setID(int ID){
            this.ID = ID;
        }*/

	public String getName() {
		return name;
	}

	public void setName(String name) {//
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
