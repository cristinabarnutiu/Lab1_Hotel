import Domain.RoomValidator;
import Repository.RoomRepository;
import Service.Hotel;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        RoomValidator validator = new RoomValidator();
        RoomRepository repository = new RoomRepository(validator);
        Hotel hotel = new Hotel(repository);

        hotel.checkIn(1, 1, 1, 1);
        hotel.checkIn(2, 2, 2, 2);
        hotel.checkIn(3, 3, 3, 3);
        hotel.checkIn(4, 4, 4, 4);
        Console console = new Console(hotel);
        console.run();
    }
}