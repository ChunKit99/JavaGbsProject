package main;

import java.time.LocalDate;
import java.util.Scanner;

import basic.*;

/**
 *
 * @author Liew Chun Kit
 */
public class GymBookingManagement {

    static Scanner input = new Scanner(System.in);
    static int maxArrNum = 20;
    static Customer[] customer = new Customer[maxArrNum];
    static Admin admin;// assume one admin only
    static BookingGym[] bookingRecord = new BookingGym[maxArrNum];
    static GymRoom[] gymRoomList = new GymRoom[maxArrNum];
    static TimeSlot[] timeSlotList = new TimeSlot[maxArrNum];

    /**
     * create some default data
     *
     * @author Liew Chun Kit
     */
    public static void initialize() {
        // String username, String password, String name, String email, String
        // phoneNumber, String gender
        customer[0] = new Customer("user1", "123", "Bobo Boy", "boboboy@email.com", "012345678", "male");
        customer[1] = new Customer("user2", "456", "Miku Zan", "abuPaba@email.com", "011222222", "female");
        admin = new Admin("Admin", "123456");

        gymRoomList[0] = new GymRoom(1, "Room 1", "Gold");
        gymRoomList[1] = new GymRoom(2, "Room 2", "Sliver");
        gymRoomList[2] = new GymRoom(3, "Room 3", "Bronze");

        timeSlotList[0] = new TimeSlot(1, "0800", "1000");
        timeSlotList[1] = new TimeSlot(2, "1000", "1200");
        timeSlotList[1] = new TimeSlot(3, "1400", "1600");

        bookingRecord[0] = new BookingGym(1, "user1", LocalDate.now(), gymRoomList[0], timeSlotList[0]);
        bookingRecord[1] = new BookingGym(2, "user1", LocalDate.now().plusDays(1), gymRoomList[0], timeSlotList[0]);
        bookingRecord[2] = new BookingGym(3, "user2", LocalDate.now().minusDays(1), gymRoomList[0], timeSlotList[0]);
    }

    /**
     * Use for check password valid or not
     *
     * @author Liew Chun Kit
     */
    public static boolean isValidPassword(String usernameCheck, String passwordCheck, int userType) {
        boolean isValid = false;
        Account userLogin = null;

        if (isExistUsername(usernameCheck)) {//exist
            if (userType == 1) {// get user type
                userLogin = customer[findIndexCustomer(usernameCheck)];
            } else {// admin
                userLogin = admin;
            }
            if (userLogin.getUsername() == usernameCheck) {//check match password
                if (userLogin.getPassword() == passwordCheck) {
                    isValid = true;
                }
            } else {// username correct but wrong passwd
                System.out.println("Invalid password");
            }
        } else {//not exist
            System.out.println("Invalid Username or User Type");
        }
        return isValid;
    }

    /**
     * Use for check exist username for customer when register and login
     *
     * @author Liew Chun Kit
     */
    public static boolean isExistUsername(String usernameCheck) {
        boolean isExist = false;
        for (Customer cus : customer) {
            if (cus == null) {// empty object
                break;
            }
            if (cus.getUsername() == usernameCheck) {//found the username
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    /**
     * Use for check exist username for customer when register, only use it when
     * username exist
     *
     * @author Liew Chun Kit
     */
    public static int findIndexCustomer(String username) {
        int index = 0;
        for (Customer cus : customer) {
            if (cus.getUsername() == username) {
                break;
            }
            index++;

        }
        return index;
    }

    /**
     * find index of array base on id input
     *
     * @author Liew Chun Kit
     */
    public static int findIndexGymRoomList(int ID) {
        int index = 0;
        for (int i = 0; i < findNullObejct(gymRoomList); i++) {
            if (gymRoomList[i].ID == ID) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * find index of array base on id input
     *
     * @author Liew Chun Kit
     */
    public static int findIndexTimeSlotList(int ID) {
        int index = 0;
        for (int i = 0; i < findNullObejct(timeSlotList); i++) {
            if (timeSlotList[i].ID == ID) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * can know current object array use until where, example use to add new
     * object into array, print and stop before empty object
     *
     * @author Liew Chun Kit
     */
    public static int findNullObejct(Object[] objCheck) {// use for check empty space array in object array
        int num = 0;
        for (Object ob : objCheck) {
            if (ob == null) {
                break;
            }
            num++;
        }
        return num;
    }

    /**
     * currently an idea only, provide for delete element in array
     *
     * @author Liew Chun Kit
     */
    public static void deleteElementArray(int indexDelete) {
        // let say indexDelete = 1;
        // index = 0, *1, 2, 3, 4
        // value = 1, *2, 3, 4, 5
        int[] oriNum = {1, 2, 3, 4, 5};
        int[] objCopy = new int[oriNum.length];
        // System.out.println("before :"+oriNum.length);
        for (int i = 0, j = 0; i < oriNum.length; i++) {
            if (i != indexDelete) {
                objCopy[j++] = oriNum[i];
            }
        }
        oriNum = objCopy;
        // System.out.println("after :"+oriNum.length);
        for (int p : oriNum) {
            System.out.println(p);

            /*
			 * ;Object[] objCopy = new Object[ objOri.length];
			 * 
			 * for (int i = 0, j = 0; i < objOri.length; i++) {
			 *  if (i != indexDelete) {
			 *  objCopy[j++] = objOri[i]; 
			 *  }
			 * } 
			 * objOri = objCopy
			 * 
             */
        }
    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void promptMenu() {
        System.out.println("Main Menu:");
        System.out.println("1 = Login");
        System.out.println("2 = Register");
        System.out.println("0 = Exit");
    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void promptCustomerMenu() {
        System.out.println("1 = Add Booking");
        System.out.println("2 = Edit/Delete Booking");
        System.out.println("3 = View Booking");
        System.out.println("4 = View Personal detail");
        System.out.println("0 = Log out");
    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void promptAdminMenu() {
        System.out.println("1 = Manage Gym Room");
        System.out.println("2 = Manage Time Slot");
        System.out.println("3 = View All Booking");
        System.out.println("0 = Log out");
    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void main(String[] args) {
        initialize();
        int askMenu = 1;
        while (askMenu != 0) {
            promptMenu();
            askMenu = input.nextInt();

            switch (askMenu) {
                case 1:// login
                    System.out.println("Login:");
                    login();
                    break;
                case 2:// register
                    System.out.println("Register:");
                    register();
                    break;
                case 0:// exit
                    System.out.println("Bye!");
                    askMenu = 0;
                    break;
                default:
                    System.out.println("Please only input above");
                    break;
            }
        }
    }

    /**
     *
     * @author Liew Chun Kit
     *
     */
    public static void login() {
        String usernameInput;
        String passwordInput;
        int typeUser;

        System.out.println("Please Enter Username");
        usernameInput = input.nextLine();
        System.out.println("Please Enter Password");
        passwordInput = input.nextLine();
        System.out.println("Please Select User");
        System.out.println("1 = Customer");
        System.out.println("2 = Admin");
        typeUser = Integer.parseInt(input.nextLine());//convert String to int

        // check username password type
        if (isValidPassword(usernameInput, passwordInput, typeUser)) {
            if (typeUser == 1) {// customer
                // into customer menu
                customerMenu();
            } else {// admin
                // into admin menu
                adminMenu();
            }
        } else {// fail to valid
            System.out.println("Please Try Again");
        }
    }

    /**
     * can check repeat username
     *
     * @author OHG
     *
     */
    public static void register() {// create customer here
        // prompt user to enter information
        // check repeat of username, using do while repeat until valid
        // check valid of password, using do while repeat until valid
        // find empty object location of customer array, create new customer object
        // using the data

    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void customerMenu() {

        int askMenu = 1;
        while (askMenu != 0) {
            promptCustomerMenu();
            askMenu = input.nextInt();
            switch (askMenu) {
                case 1:// add
                    System.out.println("Add Booking:");
                    addBooking();
                    break;
                case 2:// edit
                    System.out.println("Edit Delete Booking:");
                    editBooking();
                    break;
                case 3:// View
                    System.out.println("View Booking:");
                    viewBooking();
                    break;
                case 4:// personal
                    System.out.println("View Personal Detail:");
                    viewPersonalDetail();
                    break;
                case 0:// exit
                    System.out.println("Log out!");
                    askMenu = 0;
                    break;
                default:
                    System.out.println("Please only input above");
                    break;
            }
        }
    }

    /**
     *
     * @author OHG
     */
    // add booking
    public static void addBooking() {

    }

    /**
     *
     * @author LWC
     */
    // edit or delete booking
    public static void editBooking() {
        //newnewnew
    }

    /**
     * view customer booking record
     *
     * @author LWC
     */
    // view booking
    public static void viewBooking() {

    }

    /**
     *
     * @author OHG
     */
    // view Personal Detail
    public static void viewPersonalDetail() {

    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void adminMenu() {

        int askMenu = 1;
        while (askMenu != 0) {
            promptAdminMenu();
            askMenu = input.nextInt();
            switch (askMenu) {
                case 1:// manage gym Room
                    System.out.println("Manage Gym Room:");
                    manageGymRoom();
                    break;
                case 2:// manage time slot
                    System.out.println("Manage Time Slot:");
                    manageTimeSlot();
                    break;
                case 3:// view all booking in system
                    System.out.println("View All Booking In System");
                    viewAllBooking();
                    break;
                case 0:// exit
                    System.out.println("Log out!");
                    askMenu = 0;
                    break;
                default:
                    System.out.println("Please only input above");
                    break;
            }
        }
    }

    /**
     *
     * @author TYL base on user input option, do the add edit delete view add
     * promptManageGymRoom
     */
    // manage gym Room
    public static void manageGymRoom() {
        /*
		 * while(){ //new //view //edit
		 * 
		 * }
         */
        int askMenu = 1;
        
        while(askMenu != 0){
            System.out.println("Please select the option below."); 
            System.out.println("1 = Add \n2 = Edit \n3 = View\n");
            System.out.println("Option: ");
            askMenu = input.nextInt();
            switch (askMenu){
                case 1://add booking
                    System.out.println("\nAdd Booking:");
                    addBooking();
                    break;
                case 2://edit booking
                    System.out.println("\nEdit Booking:");
                    editBooking();
                    break;
                case 3://view booking
                    System.out.println("\nView Booking:");
                    viewBooking();
                    break;
                case 0://exit
                    System.out.println("\nExit Manage Gym Romm\n");
                    askMenu = 0;
                    break;
                default:
                    System.out.println("\nPlease only input the available option above!\n");
            }
        }
    }

    /**
     * base on user input option, do the add edit delete view add
     * promptManageTimeSlot
     *
     * @author KC
     */
    // manage time slot
    public static void manageTimeSlot() {

    }

    /**
     * view all customer booking record in system arrange well the record
     *
     * @author LWC
     */
    public static void viewAllBooking() {

    }

}
