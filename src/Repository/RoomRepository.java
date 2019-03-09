package Repository;
import Domain.Room;
import Domain.RoomValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepository {

    private Map<Integer, Room> storage = new HashMap<>();
    private RoomValidator validator;

    /**
     * Instantiates a repository for roomNumbers
     * @param validator
     */
    public RoomRepository (RoomValidator validator) {
        this.validator = validator;
        // low coupling, high cohesion
        // this.validator = new RoomValidator()
    }

    // method CRUD (Create, Read, Update, Delete)
    /**
     * Add method checks if id is unique
     * @param roomNumber
     */
    public void add(Room roomNumber){
        if (storage.containsKey(roomNumber.getId())){
            throw new RuntimeException("A check-in with that id already exists");
        }
        validator.validate (roomNumber);
        storage.put (roomNumber.getId(), roomNumber);
    }

    /**
     * ...
     * @param roomNumber
     */
    public void update (Room roomNumber){
        if (!storage.containsKey(roomNumber.getId())) {
        throw new RuntimeException ("There is no check-in with the given id to update!");
        }
        validator.validate(roomNumber);
        storage.put (roomNumber.getId(), roomNumber);
    }
    /**
     * @return a list of all check-ins.
     */
    public List<Room> getAll(){

        return new ArrayList<>(storage.values());
        //return (List<Room>)storage.values();
        //return storage.values().toArray();
    }
}
