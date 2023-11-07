package $07.hotel;

import java.util.HashMap;
import java.util.Map;

public class Hotel {

    private String name;

    private Map<String, Room> roomMap;  // key: roomId, value: Room


    public Hotel(String name) {
        this.name = name;
        this.roomMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Room> getRoomMap() {
        return roomMap;
    }

    public void setRoomMap(Map<String, Room> roomMap) {
        this.roomMap = roomMap;
    }
}
