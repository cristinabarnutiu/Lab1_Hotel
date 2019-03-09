package Domain;

public class Room {
    private int id;
    private int roomNumber;
    private int rating;
    private int days;
    private int persons;
    private String feedback;
    private boolean available;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", rating=" + rating +
                ", days=" + days +
                ", persons=" + persons +
                ", feedback='" + feedback + '\'' +
                ", available=" + available +
                '}';
    }

    //CheckIn: id, persons, roomNumber; days
    public Room(int id, int roomNumber, int persons, int days){
        this.id = id;
        this.roomNumber = roomNumber;
        this.persons = persons;
        this.days = days;
        available = false; //default value, assignment not necessary
    }

    public Room(int id, int roomNumber, int rating, int days, int persons, String feedback, boolean available) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.rating = rating;
        this.days = days;
        this.persons = persons;
        this.feedback = feedback;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
