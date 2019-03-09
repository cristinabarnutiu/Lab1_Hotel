package UI;

import Domain.Room;
import Domain.RoomNumberAverageRatingViewModel;
import Service.Hotel;

import java.util.Scanner;

public class Console {
    private Hotel hotel;
    private Scanner scanner;

    public Console(Hotel hotel) {
        this.hotel = hotel;
        scanner = new Scanner(System.in);
    }



    private void showMenu() {
        System.out.println("1. Check-in");
        System.out.println("2. Check-out");
        System.out.println("3. Room Rating");
        System.out.println("a. Display all");
        System.out.println("x. Exit");
    }
    public void run() {
        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleCheckIn();
            } else if (option.equals("2")) {
                handleCheckOut();
            } else if (option.equals("3")) {
                handleRoomRatingReport();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

    private void handleRoomRatingReport() {
        for (RoomNumberAverageRatingViewModel ratingAverage : hotel.getRoomNumberRatingAverage())
            System.out.println(ratingAverage);
    }

    private void handleCheckOut() {
        try {
            System.out.println("Enter Room Number:");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Feedback:");
            String feedback = scanner.nextLine();
            System.out.println("Enter Rating:");
            int rating = Integer.parseInt(scanner.nextLine());

            hotel.checkOut(roomNumber, rating, feedback);
        } catch (RuntimeException runtimeException) {
            System.out.println("Errors: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Room c : hotel.getAll())
            System.out.println(c);
    }

    private void handleCheckIn() {

        try {
            System.out.println("Enter ID:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Room Number:");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter persons:");
            int persons = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter days:");
            int days = Integer.parseInt(scanner.nextLine());

            hotel.checkIn(id, roomNumber, persons, days);
        } catch (RuntimeException runtimeException) {
            System.out.println("Errors: " + runtimeException.getMessage());
        }
    }
}
