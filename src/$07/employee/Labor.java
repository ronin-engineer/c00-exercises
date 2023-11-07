package $07.employee;

import $07.hotel.Room;
import $07.management.Salary;

public class Labor extends Employee implements Salary {

    public static final int SALARY_RATE = 1;

    public Labor() {
    }

    public Labor(String id, String name) {
        super(id, name);
    }

    public void clean(Room room) {
        System.out.println("Clean room: " + room.getId());
    }

    @Override
    public Integer getSalary() {
        return getRooms().size() * SALARY_RATE;
    }
}
