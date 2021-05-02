package main;

import java.util.logging.Level;
import java.util.logging.Logger;

import basic.*;
import database.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Controller class, use for communicate between gui and database
 *
 * @author Liew Chun Kit, TYL, KC, OHG, LWC
 */
public class Controller {

    private static Controller instance = null;
    private Logger logger;
    private MainDatabase myDB;
    public Account loggedUser = null;

    private Controller() {
        // get the logger
        logger = Logger.getLogger(getClass().getName());
        logger.setLevel(Level.ALL);

    }

    /**
     * Returns instance of Controller class
     *
     *
     * @return static object for controller
     */
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    /**
     * use to connect database
     *
     * @author Liew Chun Kit
     * @param dbName database name
     */
    public void loadDatabase(String dbName) {
        myDB = new MainDatabase(dbName);
    }

    /**
     * use to disconnect database, disconnect when user logout
     *
     * @author Liew Chun Kit
     */
    public void disconnectDB() {
        myDB = null;
    }

    /**
     * get the customer object base on username given, if null means not exist
     *
     * @author Liew Chun Kit
     * @param username find in database
     * @return object of customer
     */
    public Customer getCustomer(String username) {
        Account account = myDB.getAccount(username);
        return (Customer) account;
    }

    /**
     * get the customer object all in the database
     *
     * @author Liew Chun Kit
     * @return array list of customer object
     */
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> list = myDB.getAllCustomer();
        return list;
    }

    /**
     * Add customer data to the database.
     *
     * @author Liew Chun Kit
     * @param username
     * @param password
     * @param name
     * @param email
     * @param phoneNumber
     * @param gender
     * @return true if add customer data into db
     */
    public boolean addCustomer(String username, String password, String name,
            String email, String phoneNumber, String gender) {
        // create the Customer instance
        Customer customer = new Customer(username, password, name, email, phoneNumber, gender);
        // store customer in db, if success will return true
        return myDB.addAccount(customer);
    }

    /**
     * login check, if valid will not null
     *
     * @author Liew Chun Kit
     * @param username
     * @param password
     * @return object of account
     */
    public Account login(String username, String password) {
        loggedUser = myDB.login(username, password);

        if (loggedUser != null) {
            logger.info("Logged in user: " + loggedUser.username);
        }
        return loggedUser;
    }

    /**
     * log gout, logged user null, disconnect db
     *
     * @author Liew Chun Kit
     */
    public void logout() {
        logger.info("Logged out user: " + loggedUser.username);
        loggedUser = null;
        disconnectDB();
    }

    /**
     * get the logged user object(Account)
     *
     * @author Liew Chun Kit
     * @return object account where currently login
     */
    public Account getLoggedUser() {
        return loggedUser;
    }

    /**
     * change data of customer
     *
     * @author Liew Chun Kit
     * @param cus Customer object to update in database
     * @return true if success update
     */
    public boolean updateCustomer(Customer cus) {
        return myDB.updateCustomer(cus);
    }

    /**
     * delete data of customer S
     *
     * @author Liew Chun Kit
     * @param cus Customer object to delete in database
     * @return true if success delete
     */
    public boolean deleteCustomer(Customer cus) {
        return myDB.deleteCustomer(cus);
    }

    /**
     * add data for gym room, from GUI to database
     *
     * @author Liew Chun Kit
     * @param name
     * @param level
     * @return true if success add
     */
    public boolean addGymRoom(String name, String level) {
        GymRoom gym = myDB.buildGymRoom();//build a gymrooom object with latest id
        gym.setName(name);
        gym.setLevel(level);
        return myDB.addGymRoom(gym);//pass and add to database
    }

    /**
     * show example how to get object booking from database to GUI
     *
     * @author Liew Chun Kit
     */
    public BookingGym getExampleBookingGym(int bookID) {
        BookingGym book = myDB.getExampleBookingGym(bookID);
        return book;
    }
    // TYL part start
    //public boolean updateGymRoom(GymRoom gym)
    //public boolean deleteGymRoom(GymRoom gym)
    //public GymRoom getGymRoom(int gymID)
    //public ArrayList<GymRoom> getAllGymRoom()
    // TYL part end
    // KC part start
    //public boolean AddTimeSlot(String timeStart, String timeEnd)
    public boolean addTimeSlot(String timeStart, String timeEnd) {
        TimeSlot time = myDB.buildTimeSlot();//build a gymrooom object with latest id
        time.setTimeStart(timeStart);
        time.setTimeEnd(timeEnd);
        return myDB.addTimeSlot(time);//pass and add to database
    }
    
    //public boolean updateTimeSlot(TimeSlot time)
    public boolean updateTimeSlot(TimeSlot time) {
        return myDB.updateTimeSlot(time);
    }
        
    //public boolean deleteTimeSlot(TimeSlot time)
    public boolean deleteTimeSlot(TimeSlot time) {
        return myDB.deleteTimeSlot(time);
    }
    
    //public TimeSlot getTimeSlot(int timeID)
    public TimeSlot getTimeSlot(int timeID) {
        TimeSlot ts = myDB.getTimeSlot(timeID);
        return ts;
    }
        
    //public ArrayList<TimeSlot> getAllTimeSlot()
    public ArrayList<TimeSlot> getAllTimeSlot() {
        ArrayList<TimeSlot> list = myDB.getAllTimeSlot();
        return list;
    }
    
    // KC part end
    // OHG part start
    //public boolean addBookingGym(String username, int gymID, int timeID, LocalDate dateBook)
    //use in your gui part(controller code):
    //1. public Customer getCustomer(String username)//get customer object given username
    //2. public Account getLoggedUser() get curerent login user account object
    // OHG part end
    // LWC part start
    //
    //public boolean updateBookingGym(BookingGym book)
    //public boolean deleteBookingGym(BookingGym book)
    //public BookingGym getBookingGym(int bookID)
    //public ArrayList<BookingGym> getAllBookingGym()
    // LWC part end
}
