package Domain;

public class RoomNumberAverageRatingViewModel {
 private int roomNumber;
 private double averageRating;
    @Override
    public String toString() {
        return "RoomNumberAverageRatingViewModel{" +
                "roomNumber=" + roomNumber +
                ", averageRating=" + averageRating +
                '}';
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public RoomNumberAverageRatingViewModel(int roomNumber, double averageRating) {
        this.roomNumber = roomNumber;
        this.averageRating = averageRating;
    }

}
