import controller.BookingResource;
import service.BuildingService;
import service.ReservationService;
import service.RoomService;
import service.UserService;
import view.CLI.CommandLine;
import view.GUI.Main_GUI;


/**
 * This is the main class of the entire Program.
 * Calling view. GUI AND COMMAND LINE - TWO UI VIEWS.
 *
 * @author 220031985
 */

public class RBSystem extends Thread {


    /**
     * Creating instances and calling the views.
     *
     * @param args no arguments.
     */
    public static void main(String[] args) {

        // Instances of the Service Layer.
        UserService userService = new UserService();
        RoomService roomService = new RoomService();
        ReservationService reservationService = new ReservationService();
        BuildingService buildingService = new BuildingService();

        // Instance of the Controller Layer
        BookingResource bookingResource = new BookingResource(userService, roomService, reservationService, buildingService);

        // GUI View is called.
        new Main_GUI(bookingResource);


// Terminal View Method is called.
        System.out.println("\nCommand Line Interface is Called: ");
        CommandLine cmdLine = new CommandLine(bookingResource);
        cmdLine.commandLine();


    }

    /**
     * Implementing Thread Function.
     */
    public void run() {
        System.out.println("This code is running in a thread");
    }
}
