package Service;

import Domain.Room;
import Domain.RoomNumberAverageRatingViewModel;
import Repository.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hotel {
    private RoomRepository repository;
    /**
     * ...
     * @param repository
     */
    public Hotel (RoomRepository repository){
        this.repository=repository;
    }

    /**
     *
     * @param id
     * @param persons
     * @param roomNumber
     * @param days
     */
    public void checkIn (int id, int persons, int roomNumber, int days){
    Room roomIn = new Room (id, persons, roomNumber, days);
    List<Room> rooms = repository.getAll();
    for (Room r : rooms){
       if (r.getRoomNumber() == roomNumber && !r.isFree()) {
           throw new RuntimeException("Room is occupied!");
       }
    }
    repository.add(roomIn);
}

    /**
     *
     * @param roomNumber
     * @param rating
     * @param feedback
     */
    public void checkOut(int roomNumber, int rating, String feedback){
        Room roomOut = null;
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && !r.isFree()) {
                roomOut = r;
            }
        }
   if (roomOut != null){
       roomOut.setFeedback(feedback);
       roomOut.setRating(rating);
       roomOut.setFree(true);
       repository.update(roomOut);
   } else {
       throw new RuntimeException("There is no checkin for that roomNumber!");
   }
    }

    public List<RoomNumberAverageRatingViewModel> getRoomNumberRatingAverage() {
        List<RoomNumberAverageRatingViewModel> results = new ArrayList<>();
        Map<Integer, List<Double>> ratingForRoomNumber = new HashMap<>();

        for (Room r : repository.getAll()) {
            if (r.isFree()) {
                int roomNumber = r.getRoomNumber();
                double rating = r.getRating();

                if (!ratingForRoomNumber.containsKey(roomNumber)) {
                    ratingForRoomNumber.put(roomNumber, new ArrayList<>());
                }
                ratingForRoomNumber.get(roomNumber).add(rating);
            }
        }

        for (int roomNumber : ratingForRoomNumber.keySet()) {
            List<Double> ratings = ratingForRoomNumber.get(roomNumber);
            double average = 0;
            for (double r : ratings) {
                average += r;
            }
            average /= ratings.size();
            results.add(new RoomNumberAverageRatingViewModel(roomNumber, average));
        }
//        results.sort((r1, r2) -> r1.getAverageRating() > r2.getAverageRating() ? -1 : 1);
        results.sort((r1, r2) -> {
            if (r1.getAverageRating() > r2.getAverageRating())
                return -1;
            else if (r1.getAverageRating() == r2.getAverageRating())
                return 0;
            else
                return 1;
        });
        return results;
    }
    public List<Room> getAll() {
        return repository.getAll();
    }
}

