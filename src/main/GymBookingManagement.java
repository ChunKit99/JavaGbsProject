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
        if (customer[findIndexCustomer(usernameCheck)].username.equals(usernameCheck)) {
            isExist = true;
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
        for (int i = 0; i < findNullObject(customer); i++) {
            if (customer[i].username.equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Use for check exist id
     *
     * @author Liew Chun Kit
     * @param idCheck
     * @return
     */
    public static boolean isExistGymRoomListID(int idCheck) {
        boolean isExist = false;
        if (idCheck == gymRoomList[findIndexGymRoomList(idCheck)].ID) {
            isExist = true;
        }
        return isExist;
    }

    /**
     * Use for check exist id
     *
     * @author Liew Chun Kit
     * @param idCheck
     * @return
     */
    public static boolean isExistTimeSlotListID(int idCheck) {
        boolean isExist = false;
        if (idCheck == timeSlotList[findIndexTimeSlotList(idCheck)].ID) {
            isExist = true;
        }
        return isExist;
    }

    /**
     * Use for check exist id
     *
     * @author Liew Chun Kit
     * @param idCheck
     * @return
     */
    public static boolean isExistBookingRecordID(int idCheck) {
        boolean isExist = false;
        if (idCheck == bookingRecord[findIndexBookingRecord(idCheck)].ID) {
            isExist = true;
        }
        return isExist;
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
        if (isExistGymRoomListID(idGymRoom) && isExistTimeSlotListID(idTimeSlot)) {
            indexGymRoom = findIndexGymRoomList(idGymRoom);
            indexTimeSlot = findIndexTimeSlotList(idTimeSlot);
            bookingRecord[findNullObject(bookingRecord)] = new BookingGym(findLatestIDBooking(), usernameLogin, LocalDate.now(), gymRoomList[indexGymRoom], timeSlotList[indexTimeSlot]);
        } else {
            System.out.println("No such Gym Room or Time Slot exists! You will be exit Add Booking option!\n");
        }
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
        boolean flag = true;//if true display edited list
        System.out.println("Current Booking:");
        viewBooking();
        System.out.println("Please Select Which ID To Edit:");
        int ID = input.nextInt();
        int indexToEdit = findIndexBookingRecord(ID);
        if (isExistBookingRecordID(ID) && bookingRecord[indexToEdit].getCustomer().equals(usernameLogin)) {//match user and id to edit
            System.out.println("Please Select Which To Edit(1-Gym Room, 2-Time Slot, 3-Both :)");
            int option = input.nextInt();
            if (option == 1) {
                System.out.println("Your Choice: 1 - Gym Room");
                System.out.println("Gym Room Option Have:");
                viewGymRoom();
                System.out.println("Please Enter New Gym Room ID: ");
                int RoomID = input.nextInt();
                if (isExistGymRoomListID(RoomID)) {
                    bookingRecord[indexToEdit].setGymRoom(gymRoomList[findIndexGymRoomList(RoomID)]);
                } else {
                    System.out.println("No Such Gym Room Exists!");
                }

            } else if (option == 2) {
                System.out.println("Your Choice: 2 - Time Slot");
                System.out.println("Time Slot Option Have:");
                viewTimeSlot();
                System.out.println("Please Enter New Time Slot ID: ");
                int TimeID = input.nextInt();
                if (isExistTimeSlotListID(TimeID)) {
                    bookingRecord[indexToEdit].setTimeSlot(timeSlotList[findIndexTimeSlotList(TimeID)]);
                } else {
                    System.out.println("No Such Time Slot Exists!");
                }

            } else if (option == 3) {
                System.out.println("Your Choice: 3 - Both");
                System.out.println("Gym Room Option Have:");
                viewGymRoom();
                System.out.println("Please Enter New Gym Room ID: ");
                int RoomID = input.nextInt();
                System.out.println("Time Slot Option Have:");
                viewTimeSlot();
                System.out.println("Please Enter New Time Slot ID: ");
                int TimeID = input.nextInt();
                if (isExistTimeSlotListID(TimeID) && isExistGymRoomListID(RoomID)) {
                    bookingRecord[indexToEdit].setTimeSlot(timeSlotList[findIndexTimeSlotList(TimeID)]);
                    bookingRecord[indexToEdit].setGymRoom(gymRoomList[findIndexGymRoomList(RoomID)]);
                } else {
                    System.out.println("No Such Gym Room OR Time Slot Exists!");
                }
            } else {
                System.out.println("Invalid Option!");
                flag = false;
            }
            if (flag) {
                bookingRecord[indexToEdit].setDate(LocalDate.now());
                System.out.println("Your Choice Has Been Recorded.");
                viewBooking();
            } else {
                System.out.println("No Change To Your Record.");
            }
        } else {
            System.out.println("No such Booking Record exists! You will be exit Edit Booking option!\n");
        }
    }

    /**
     *
     * @author TYL
     */
    // delete booking
    public static void deleteBooking() {
        //newnewnew
        System.out.println("\nWhich Booking need delete?");
        viewBooking();
        System.out.println("\nEnter the Booking ID need to delete: ");
        int ID = input.nextInt();
        int deleteIndex = findIndexBookingRecord(ID);
        if (isExistBookingRecordID(ID) && bookingRecord[deleteIndex].getCustomer().equals(usernameLogin)) {//exist id and match user login
            System.out.println("--------------------------------------------------------------------");
            System.out.println("\t\t\tBOOKING RECORD \t");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("ID" + "\t" + "CUSTOMER NAME" + "\t" + "BOOKING DATE" + "\t" + "GYM ROOM ID" + "\t" + "TIME SLOT ID");
            System.out.println("---------------------------------------------------------------------");
            System.out.println(bookingRecord[deleteIndex].ID + "\t" + bookingRecord[deleteIndex].getCustomer() + "\t\t" + bookingRecord[deleteIndex].getDate() + "\t    " + bookingRecord[deleteIndex].getGymRoom().ID + "\t\t    " + bookingRecord[deleteIndex].getTimeSlot().ID);
            System.out.println("\nDeleting Booking Detail...");
            deleteElementArrayBooking(deleteIndex);
            System.out.println("Booking Record After Delete ID " + (ID) + "\n");
            viewBooking();
        } else {
            System.out.println("No such Booking Record exists! You will be exit Delete option!\n");
        }
    }

    public static void deleteElementArrayBooking(int deleteIndex) {

        BookingGym[] bookingRecordCopy = new BookingGym[bookingRecord.length];
        for (int i = 0, j = 0; i < bookingRecord.length; i++) {
            if (i != deleteIndex) {
                bookingRecordCopy[j++] = bookingRecord[i];
            }
        }
        bookingRecord = bookingRecordCopy;
    }

    /**
     * view customer booking record
     *
     * @author LWC
     */
    // view booking
    public static void viewBooking() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\t\t\tBOOKING RECORD \t");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("ID" + "\t" + "CUSTOMER NAME" + "\t" + "BOOKING DATE" + "\t" + "GYM ROOM ID" + "\t" + "TIME SLOT ID");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < findNullObject(bookingRecord); i++) {
            if (bookingRecord[i].getCustomer().equals(usernameLogin)) {
                System.out.println(bookingRecord[i].ID + "\t" + bookingRecord[i].getCustomer() + "\t\t" + bookingRecord[i].getDate() + "\t    " + bookingRecord[i].getGymRoom().ID + "\t\t    " + bookingRecord[i].getTimeSlot().ID);
            }
        }
        System.out.println("--------------------------------------------------------------------");
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
     * prompt user based on the input option, do the add, edit, delete, view and
     * exit promptManageGymRoom
     *
     * @author TYL
     */
    // manage gym Room
    public static void manageGymRoom() {
        int option = 1;

        while (option != 0) {
            System.out.println("Please select the option below.");
            System.out.println("1 = Add \n2 = Edit \n3 = Delete \n4 = View \n0 = Exit\n");
            System.out.println("Option: ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1://add gymRoom
                    System.out.println("\nAdd Gym Room:");
                    addGymRoom();
                    break;
                case 2://edit gymRoom
                    System.out.println("\nEdit Gym Room:");
                    editGymRoom();
                    break;
                case 3://delete gymRoom
                    System.out.println("\nDelete Gym Room:");
                    deleteGymRoom();
                    break;
                case 4://view gymRoom
                    System.out.println("\nView Gym Room:");
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

    /**
     * add gym room
     *
     * 
     * @author TYL
     */
    public static void addGymRoom() {
        System.out.println("Previous Gym Room Record.");
        viewGymRoom();
        System.out.println("\nAdding Gym Room Detail...");
        System.out.println("\nID: ");
        int ID = input.nextInt();
        input.nextLine();
        String name = null;
        String level = null;

        if (isExistGymRoomListID(ID)) {
            System.out.println("This Gym Room ID already exists! You will be exit Add option!\n");
        } else {
            System.out.println("Name: ");
            name = input.nextLine();
            System.out.println("Level ( Gold / Silver / Bronze ): ");
            level = input.nextLine();
            gymRoomList[findNullObject(gymRoomList)] = new GymRoom(ID, name, level);
            viewGymRoom();
            System.out.println("Successful Added New Gym Room!\n");
        }
    }

    /**
     * edit gym room
     *
     * @author TYL
     */
    public static void editGymRoom() {
        System.out.println("\nWhich Gym Room need to edit?\n");
        viewGymRoom();
        System.out.println("Enter the Gym Room ID need to edit: ");
        int ID = input.nextInt();
        input.nextLine();
        int editIndex = findIndexGymRoomList(ID);
        if (isExistGymRoomListID(ID)) {
            System.out.println("ID: " + gymRoomList[editIndex].ID + "\tNAME: " + gymRoomList[editIndex].getName() + "\tLEVEL: " + gymRoomList[editIndex].getLevel());
            System.out.println("\nEditing Gym Room Detail...");

            boolean flag = true;//check valid input option and display edited list

            System.out.println("\nPlease select which section to edit (1 = Gym Room Name / 2 = Level / 3 = Both Name & Level): ");
            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {
                System.out.println("Edit Gym Room Name...\n");
                System.out.println("Please enter new Gym Room Name: ");
                String newName = input.nextLine();
                gymRoomList[editIndex].setName(newName);
            } else if (option == 2) {
                System.out.println("Edit Gym Room Level...\n");
                System.out.println("Please enter new Gym Room Level: ");
                System.out.println("Level: ");
                String newLevel = input.nextLine();
                gymRoomList[editIndex].setLevel(newLevel);
            } else if (option == 3) {
                System.out.println("Edit Gym Room Name...\n");
                System.out.println("Please enter new Gym Room Name: ");
                String newName = input.nextLine();
                gymRoomList[editIndex].setName(newName);
                System.out.println("Edit Gym Room Level...\n");
                System.out.println("Please enter new Gym Room Level: ");
                System.out.println("Level: ");
                String newLevel = input.nextLine();
                gymRoomList[editIndex].setLevel(newLevel);
            } else {
                System.out.println("Error input option! You will be exit Edit option!");
                flag = false;
            }
            if (flag) {
                System.out.println("Your Choice Has Been Recorded.");
                viewGymRoom();
            } else {
                System.out.println("No Change To Your Record.");
            }
        } else {
            System.out.println("No such Gym Room exists! You will be exit Edit option!\n");
        }
    }

    /**
     * delete gym room
     *
     * @author TYL
     */
    public static void deleteGymRoom() {
        System.out.println("\nWhich Gym Room need delete?");
        viewGymRoom();
        System.out.println("Enter the Gym Room ID need to delete: ");
        int ID = input.nextInt();
        int deleteIndex = findIndexGymRoomList(ID);
        if (isExistGymRoomListID(ID)) {
            System.out.println("ID: " + gymRoomList[deleteIndex].ID + "\tNAME: " + gymRoomList[deleteIndex].getName() + "\tLEVEL: " + gymRoomList[deleteIndex].getLevel());
            System.out.println("\nDeleting Gym Room Detail...");
            deleteElementArrayGymRoom(deleteIndex);
            System.out.println("Gym Room List After Delete ID " + deleteIndex + "\n");
            viewGymRoom();
        } else {
            System.out.println("No such Gym Room exists! You will be exit Edit option!\n");
        }
    }

    /**
     * delete gym room element in array
     *
     * @author TYL
     */
    public static void deleteElementArrayGymRoom(int deleteIndex) {

        GymRoom[] gymRoomListCopy = new GymRoom[gymRoomList.length];
        for (int i = 0, j = 0; i < gymRoomList.length; i++) {
            if (i != deleteIndex) {
                gymRoomListCopy[j++] = gymRoomList[i];
            }
        }
        gymRoomList = gymRoomListCopy;
    }

    /**
     * view gym room
     *
     * @author TYL
     */
    public static void viewGymRoom() {
        System.out.println("\tGYM ROOM LIST");
        System.out.println("--------------------------------------------");
        System.out.println("ID \tNAME \t\tLEVEL");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < findNullObject(gymRoomList); i++) {
            System.out.println(gymRoomList[i].ID + "\t" + gymRoomList[i].getName() + "\t\t" + gymRoomList[i].getLevel());
        }
        System.out.println("--------------------------------------------\n");
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
            System.out.println(" 1 = Add Time Slot\n 2 = Edit\n 3 = Delete\n 4 = View\n 0 = Exit");
            System.out.println("Your Option: ");
            askMenu = input.nextInt();
            input.nextLine();
            switch (askMenu) {
                case 1:// manage gym Room
                    System.out.println("Add New Time Slot:");
                    addTimeSlot();
                    break;
                case 2:// manage time slot
                    System.out.println("Edit Time Slot:");
                    editTimeSlot();
                    break;
                case 3:// Delete time slot
                    System.out.println("Delete Time Slot");
                    deleteTimeSlot();
                    break;
                case 4:// view time slot
                    System.out.println("View Time Slot");
                    viewTimeSlot();
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

    /**
     * base on user input option, do the add new Time Slot
     *
     *
     * @author KC
     */
    // Add Time Slot
    public static void addTimeSlot() {
        System.out.println("Previous Time Slot Record.");
        viewTimeSlot();
        System.out.println("\nADD TIME SLOT");
        System.out.println("\nID: ");
        int ID = input.nextInt();

        if (isExistTimeSlotListID(ID)) {
            System.out.println("This Time Slot ID already exists! You will be exit Add option!\n");
        } else {
            System.out.println("ADD TIME START");
            String timestart = input.next();
            System.out.println("ADD TIME END");
            String timeend = input.next();
            timeSlotList[findNullObject(timeSlotList)] = new TimeSlot(ID, timestart, timeend);
            viewTimeSlot();
            System.out.println("\nSuccessful Added New Time Slot!");
        }

    }

    /**
     * base on user input option, do the edit Time Slot
     *
     *
     * @author KC
     */
    // Edit Time Slot
    public static void editTimeSlot() {
        System.out.println("Time Slot Record.");
        viewTimeSlot();
        System.out.println("\nEDIT TIME SLOT");
        System.out.println("\nID: ");
        int ID = input.nextInt();
        int editIndex = findIndexTimeSlotList(ID);
        if (isExistTimeSlotListID(ID)) {
            System.out.println("EDIT TIME START");
            String timestart = input.next();
            System.out.println("EDIT TIME END");
            String timeend = input.next();
            timeSlotList[editIndex] = new TimeSlot(ID, timestart, timeend);
            viewTimeSlot();
            System.out.println("\nSuccessful Edit Time Slot!");
        } else {
            System.out.println("No such Time Slot exists! You will be exit Edit option!\n");
        }

    }

    /**
     * base on user input option, do the delete Time Slot
     *
     *
     * @author KC
     */
    // delete Time Slot
    public static void deleteTimeSlot() {
        System.out.println("\nWhich Time Slot need delete?");
        viewTimeSlot();
        System.out.println("\nEnter the Time Slot ID need to delete: ");
        int ID = input.nextInt();
        int deleteIndex = findIndexTimeSlotList(ID);
        if (isExistTimeSlotListID(ID)) {
            System.out.println(timeSlotList[deleteIndex].ID + " " + timeSlotList[deleteIndex].findNameTime());
            System.out.println("\nDeleting Time Slot Detail...");
            deleteElementArrayTimeSlot(deleteIndex);
            System.out.println("Time Slot List After Delete ID " + deleteIndex + "\n");
            viewTimeSlot();
        } else {
            System.out.println("No such Time Slot exists! You will be exit Delete option!\n");
        }

    }

    /* 
     *
     *
     * @author KC
     */
    public static void deleteElementArrayTimeSlot(int deleteIndex) {
        TimeSlot[] timeSlotListCopy = new TimeSlot[timeSlotList.length];
        for (int i = 0, j = 0; i < timeSlotList.length; i++) {
            if (i != deleteIndex) {
                timeSlotListCopy[j++] = timeSlotList[i];
            }
        }
        timeSlotList = timeSlotListCopy;
    }

    /**
     * base on user input option, do the view Time Slot
     *
     *
     * @author KC
     */
    // View Time Slot
    public static void viewTimeSlot() {
        System.out.println("\n");
        System.out.println("\tTIME SLOT LIST");
        System.out.println("--------------------------------------------");
        System.out.println("ID \t\tTime Slot");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < findNullObject(timeSlotList); i++) {
            System.out.println(timeSlotList[i].ID + "\t\t" + timeSlotList[i].findNameTime());
        }
        System.out.println("--------------------------------------------\n");
    }

    /**
     * view all customer booking record in system arrange well the record
     *
     * @author LWC
     */
    public static void viewAllBooking() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\t\t\tBOOKING RECORD \t");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("ID" + "\t" + "CUSTOMER NAME" + "\t" + "BOOKING DATE" + "\t" + "GYM ROOM ID" + "\t" + "TIME SLOT ID");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < findNullObject(bookingRecord); i++) {
            System.out.println(bookingRecord[i].ID + "\t" + bookingRecord[i].getCustomer() + "\t\t" + bookingRecord[i].getDate() + "\t    " + bookingRecord[i].getGymRoom().ID + "\t\t    " + bookingRecord[i].getTimeSlot().ID);
        }
        System.out.println("--------------------------------------------------------------------");
    }

}
