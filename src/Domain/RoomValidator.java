package Domain;

public class RoomValidator {
    /**
     * Validates a room.
     * @param roomNumber the room to validate.
     * @throws RuntimeException if there are validation errors.
     */
    //Validations: roomNo empty, days > 0, id unique
    public void validate(Room roomNumber){
        if (roomNumber.getDays () <= 0){
            throw new RuntimeException ("The number of days cannot be 0 or negative");
        }
        if (roomNumber.getPersons() <= 0){
            throw new RuntimeException ("The number of persons cannot be 0 or negative");
        }

        //
        if (roomNumber.isFree() && (roomNumber.getRating() < 1 || roomNumber.getRating() > 5)) {
            throw new RuntimeException("Rating must be between 1 and 5!");
        }

        if (roomNumber.isFree() &&  roomNumber.getFeedback() == null) {
            throw new RuntimeException("Feedback cannot be null!");
        }

    }
}
