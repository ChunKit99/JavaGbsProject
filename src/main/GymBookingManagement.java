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
    static String usernameLogin;//username for login success

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
        timeSlotList[2] = new TimeSlot(3, "1400", "1600");

        bookingRecord[0] = new BookingGym(1, "user1", LocalDate.now().minusDays(2), gymRoomList[0], timeSlotList[0]);
        bookingRecord[1] = new BookingGym(2, "user1", LocalDate.now().minusDays(1), gymRoomList[0], timeSlotList[0]);
        bookingRecord[2] = new BookingGym(3, "user2", LocalDate.now(), gymRoomList[0], timeSlotList[0]);
    }

    /**
     * Use for check password valid or not
     *
     * @author Liew Chun Kit
     * @param usernameCheck
     * @param passwordCheck
     * @param userType
     * @return
     */
    public static boolean isValidPassword(String usernameCheck, String passwordCheck, int userType) {
        boolean isValid = false;
        boolean isExist = false;
        Account userLogin = null;

        if (userType == 1) {// get user type
            if (isExistUsername(usernameCheck)) {//exist customer username
                userLogin = customer[findIndexCustomer(usernameCheck)];
                isExist = true;
            }
        } else {//admin user type
            userLogin = admin;
            if (userLogin.username.equals(usernameCheck)) {
                isExist = true;
            }
        }
        if (isExist) {
            if (userLogin.username.equals(usernameCheck)) {//check match password
                if (userLogin.getPassword().equals(passwordCheck)) {
                    isValid = true;
                } else {// username correct but wrong passwd
                    System.out.println("Invalid password");
                }
            }
        } else {//not exist username
            System.out.println("Invalid Username or User Type");

        }

        return isValid;
    }

    /**
     * Use for check exist username for customer when register and login
     *
     * @author Liew Chun Kit
     * @param usernameCheck
     * @return
     */
    public static boolean isExistUsername(String usernameCheck) {
        boolean isExist = false;
        for (Customer cus : customer) {
            if (cus == null) {// empty object
                break;
            }
            //s1.equals(s2)
            if (cus.getUsername().equals(usernameCheck)) {//found the username
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
     * @param username
     * @return
     */
    public static int findIndexCustomer(String username) {
        int index = 0;
        for (Customer cus : customer) {
            if (cus.getUsername().equals(username)) {
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
     * @param ID
     * @return
     */
    public static int findIndexGymRoomList(int ID) {
        int index = 0;
        for (int i = 0; i < findNullObject(gymRoomList); i++) {
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
     * @param ID
     * @return
     */
    public static int findIndexTimeSlotList(int ID) {
        int index = 0;
        for (int i = 0; i < findNullObject(timeSlotList); i++) {
            if (timeSlotList[i].ID == ID) {
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
     * @param ID
     * @return
     */
    public static int findIndexBookingRecord(int ID) {
        int index = 0;
        for (int i = 0; i < findNullObject(bookingRecord); i++) {
            if (bookingRecord[i].ID == ID) {
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
     * @param objCheck
     * @return
     */
    public static int findNullObject(Object[] objCheck) {// use for check empty space array in object array
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
     * @param indexDelete
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
        System.out.println("\nMain Menu:");
        System.out.println("1 = Login");
        System.out.println("2 = Register");
        System.out.println("0 = Exit");
    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void promptCustomerMenu() {
        System.out.println("\n1 = Add Booking");
        System.out.println("2 = Edit Booking");
        System.out.println("3 = Delete Booking");
        System.out.println("4 = View Booking");
        System.out.println("5 = View Personal detail");
        System.out.println("0 = Log out");
    }

    /**
     *
     * @author Liew Chun Kit
     */
    public static void promptAdminMenu() {
        System.out.println("\n1 = Manage Gym Room");
        System.out.println("2 = Manage Time Slot");
        System.out.println("3 = View All Booking");
        System.out.println("0 = Log out");
    }

    /**
     *
     * @author Liew Chun Kit
     * @param args
     */
    public static void main(String[] args) {
        initialize();
        int askMenu = 1;
        while (askMenu != 0) {
            promptMenu();
            askMenu = input.nextInt();
            input.nextLine();//clear buffer
            System.out.println();//an empty line
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
                    System.out.println("Please only input above\n");
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
                usernameLogin = usernameInput;
                customerMenu();
            } else {// admin
                // into admin menu
                adminMenu();
            }
        } else {// fail to valid
            System.out.println("Please Try Again\n");
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
        String newUserName;
        String newPassword;
        String newName;
        String newEmail;
        String newPhoneNumber;
        String newGender;

        System.out.println("Please Enter Username: ");
        newUserName = input.nextLine();

        if (isExistUsername(newUserName) == true) {
            System.out.println("Username have been use, please change a username.");
            register();
        } else if (isExistUsername(newUserName) == false) {
            System.out.println("Please Enter Password: ");
            newPassword = input.nextLine();
            System.out.println("Customer name: ");
            newName = input.nextLine();
            System.out.println("Customer email: ");
            newEmail = input.nextLine();
            System.out.println("Customer phone number: ");
            newPhoneNumber = input.nextLine();
            System.out.println("Customer gender: ");
            newGender = input.nextLine();
            int indexRegister = findNullObject(customer);
            customer[indexRegister] = new Customer(newUserName, newPassword, newName, newEmail, newPhoneNumber, newGender);

        }
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
            input.nextLine();
            System.out.println();//an empty line
            switch (askMenu) {
                case 1:// add
                    System.out.println("Add Booking:");
                    addBooking();
                    break;
                case 2:// edit
                    System.out.println("Edit Booking:");
                    editBooking();
                    break;
                case 3:// delete
                    System.out.println("Delete Booking:");
                    deleteBooking();
                    break;
                case 4:// View
                    System.out.println("View Booking:");
                    viewBooking();
                    break;
                case 5:// personal
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
        int idGymRoom;
        int idTimeSlot;
        int indexGymRoom;
        int indexTimeSlot;

        System.out.println("Gym Room to be choose: ");
        viewGymRoom();
        System.out.println("Please Enter Gym Room ID For Booking: ");
        idGymRoom = input.nextInt();

        System.out.println("Time Slot to be choose: ");
        viewTimeSlot();
        System.out.println("Please Enter Time Slot For Booking: ");
        idTimeSlot = input.nextInt();

        indexGymRoom = findIndexGymRoomList(idGymRoom);
        indexTimeSlot = findIndexTimeSlotList(idTimeSlot);
        bookingRecord[findNullObject(bookingRecord)] = new BookingGym(findLatestIDBooking(), usernameLogin, LocalDate.now(), gymRoomList[indexGymRoom], timeSlotList[indexTimeSlot]);

    }

    /**
     * find the latest id in booking record
     *
     * @author Liew Chun Kit
     * @return
     */
    public static int findLatestIDBooking() {
        int id = 0;
        for (int i = 0; i < findNullObject(bookingRecord); i++) {
            if (bookingRecord[i].ID > id) {
                id = bookingRecord[i].ID;
            }
        }
        id++;
        return id;
    }

    /**
     *
     * @author LWC
     */
    // edit booking
    public static void editBooking() {
        System.out.println("Current Booking:");
        viewBooking();
        System.out.println("Please Select Which Line To Edit:");
        int ID = input.nextInt();
        int indexToEdit = findIndexBookingRecord(ID);
        bookingRecord[indexToEdit].setDate(LocalDate.now());
        System.out.println("Please Select Which To Edit(1-Gym Room, 2-Time Slot, 3-Both :)");
        int option = input.nextInt();
        if (option == 1) {
            System.out.println("Your Choice: 1 - Gym Room");
            System.out.println("Gym Room Option Have:");
            viewGymRoom();
            System.out.println("Please Enter New Gym Room ID: ");
            int RoomID = input.nextInt();
            bookingRecord[indexToEdit].setGymRoom(gymRoomList[findIndexGymRoomList(RoomID)]);
            System.out.println("Your Choice Has Been Recorded.");
        } else if (option == 2) {
            System.out.println("Your Choice: 2 - Time Slot");
            System.out.println("Time Slot Option Have:");
            viewTimeSlot();
            System.out.println("Please Enter New Time Slot ID: ");
            int TimeID = input.nextInt();
            bookingRecord[indexToEdit].setTimeSlot(timeSlotList[findIndexTimeSlotList(TimeID)]);
            System.out.println("Your Choice Has Been Recorded.");
        } else if (option == 3) {
            System.out.println("Your Choice: 3 - Both");
            System.out.println("Gym Room Option Have:");
            viewGymRoom();
            System.out.println("Please Enter New Gym Room ID: ");
            int RoomID = input.nextInt();
            bookingRecord[indexToEdit].setGymRoom(gymRoomList[findIndexGymRoomList(RoomID)]);
            System.out.println("Time Slot Option Have:");
            viewTimeSlot();
            System.out.println("Please Enter New Time Slot ID: ");
            int TimeID = input.nextInt();
            bookingRecord[indexToEdit].setTimeSlot(timeSlotList[findIndexTimeSlotList(TimeID)]);
            System.out.println("Your Choice Has Been Recorded.");
        } else {
            System.out.println("Invalid Option");
        }
    }

    /**
     *
     * @author TYL
     */
    // delete booking
    public static void deleteBooking() {
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
        int index = findIndexCustomer(usernameLogin);

        System.out.println("Username: " + customer[index].getUsername());
        System.out.println("Name: " + customer[index].getName());
        System.out.println("Email: " + customer[index].getEmail());
        System.out.println("Phone Number: " + customer[index].getPhoneNumber());
        System.out.println("Gender: " + customer[index].getGender());

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
            input.nextLine();
            System.out.println();//an empty line
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
     * @author TYL prompt user based on the input option, do the add, edit,
     * delete, view and exit promptManageGymRoom
     */
    // manage gym Room
    public static void manageGymRoom() {
        int option = 1;

        while (option != 0) {
            System.out.println("Please select the option below.");
            System.out.println("1 = Add \n2 = Edit \n3 = View\n");
            System.out.println("Option: ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1://add gymRoom
                    System.out.println("\nAdd Booking:");
                    addGymRoom();
                    break;
                case 2://edit gymRoom
                    System.out.println("\nEdit Booking:");
                    editGymRoom();
                    break;
                case 3://delete gymRoom
                    System.out.println("\nEdit Booking:");
                    deleteGymRoom();
                    break;
                case 4://view gymRoom
                    System.out.println("\nView Booking:");
                    viewGymRoom();
                    break;
                case 0://exit manageGymRoom
                    System.out.println("\nExit Manage Gym Room...\n");
                    option = 0;
                    break;
                default:
                    System.out.println("\nPlease only input the available option above!\n");
            }
        }
    }

    public static void addGymRoom() {
        System.out.println("Previous Gym Room Record.\n");
        viewGymRoom();
        System.out.println("\nAdding Gym Room Detail...");
        System.out.println("\nID: ");
        int ID = input.nextInt();
        String name = "Room " + input.nextInt();
        System.out.println("Level ( Gold / Silver / Bronze ): ");
        String level = input.nextLine();
        gymRoomList[findNullObject(gymRoomList)] = new GymRoom(ID, name, level);
        viewGymRoom();
        System.out.println("\nSuccessful Added New Gym Room!");
    }

    public static void editGymRoom() {
        System.out.println("\nWhich Gym Room need to edit?\n");
        viewGymRoom();
        System.out.println("\nEnter the Gym Room ID need to edit: ");
        int ID = input.nextInt();
        System.out.println(gymRoomList[findIndexGymRoomList(ID)].ID + " " + gymRoomList[findIndexGymRoomList(ID)].getName() + " " + gymRoomList[findIndexGymRoomList(ID)].getLevel());
        System.out.println("\nEditing Gym Room Detail...");
        int editIndex = findIndexGymRoomList(ID);
        System.out.println("\nPlease select which section to edit (1 = Gym Room Name \t2 = Level \t3 = Both Name & Level): ");
        int option = input.nextInt();

        while(option != 0){
            if (option == 1) {
                System.out.println("Edit Gym Room Name...\n");
                /*int newID = gymRoomList[findIndexGymRoomList(ID)].ID;
            String newLevel = gymRoomList[findIndexGymRoomList(ID)].getLevel();*/
                System.out.println("Please enter new Gym Room Name: ");
                String newName = input.nextLine();
                //gymRoomList[editIndex].setName(gymRoomList[findIndexGymRoomList(newName)]);
                gymRoomList[editIndex].setName(newName);
            } 
            else if (option == 2) {
                System.out.println("Delete Gym Room Level...\n");
                System.out.println("Please enter new Gym Room Level: ");
                String newLevel = input.nextLine();
                gymRoomList[editIndex].setLevel(newLevel);
            } 
            else {
                System.out.println("Error input option!\n");
                option = 0;
            }
        }
        viewGymRoom();
    }

    public static void deleteGymRoom() {
        System.out.println("\nWhich Gym Room need delete?\n");
        viewGymRoom();
        System.out.println("\nEnter the Gym Room ID need to delete: ");
        int ID = input.nextInt();
        System.out.println(gymRoomList[findIndexGymRoomList(ID)].ID + " " + gymRoomList[findIndexGymRoomList(ID)].getName() + " " + gymRoomList[findIndexGymRoomList(ID)].getLevel());
        System.out.println("\nDeleting Gym Room Detail...");
        int deleteIndex = findIndexGymRoomList(ID);
        deleteElementArrayGymRoom(deleteIndex);
        System.out.println("Gym Room List After Delete ID " + deleteIndex + "\n");
        viewGymRoom();
    }

    public static void deleteElementArrayGymRoom(int deleteIndex) {

        GymRoom[] gymRoomListCopy = new GymRoom[gymRoomList.length];
        for (int i = 0, j = 0; i < gymRoomList.length; i++) {
            if (i != deleteIndex) {
                gymRoomListCopy[j++] = gymRoomList[i];
            }
        }
        gymRoomList = gymRoomListCopy;
    }

    public static void viewGymRoom() {
        System.out.println("\n");
        System.out.println("\tGYM ROOM LIST");
        System.out.println("--------------------------------------------");
        System.out.println("ID\t NAME\t LEVEL");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < findNullObject(gymRoomList); i++) {
            System.out.println(gymRoomList[i].ID + "\t" + gymRoomList[i].getName() + "\t" + gymRoomList[i].getLevel());
        }
        System.out.println("--------------------------------------------");
    }

    /**
     * base on user input option, do the add edit delete view add
     * promptManageTimeSlot
     *
     * @author KC
     */
    // manage time slot
    public static void manageTimeSlot() {
        int askMenu = 1;
        while (askMenu != 0) {
            System.out.println("Please Select The Option Below.");
            System.out.println("1 = Add Time Slot\n 2 = Edit\n 3 = View \n 0 = Log Out");
            System.out.println("Your Option: ");
            askMenu = input.nextInt();
            input.nextLine();
            switch (askMenu) {
                case 1:// manage gym Room
                    System.out.println("Add New Time Slot:");
                    addBooking();
                    break;
                case 2:// manage time slot
                    System.out.println("Edit Time Slot:");
                    editBooking();
                    break;
                case 3:// view all booking in system
                    System.out.println("View Time Slot");
                    viewBooking();
                    break;
                case 0:// exit
                    System.out.println("Exit!");
                    askMenu = 0;
                    break;
                default:
                    System.out.println("Please only input above\n");
                    break;
            }
        }

    }

    public static void viewTimeSlot() {

    }

    /**
     * view all customer booking record in system arrange well the record
     *
     * @author LWC
     */
    public static void viewAllBooking() {
        for (int i = 0; i < findNullObject(bookingRecord); i++) {
            System.out.println("Customer Name" + "\t" + "Booking Date" + "\t" + "Gym Room ID" + "\t" + "Time Slot ID:");
            System.out.println(bookingRecord[i].getCustomer() + "\t" + bookingRecord[i].getDate() + "\t" + bookingRecord[i].getGymRoom() + "\t" + bookingRecord[i].getTimeSlot());
        }
    }

}
