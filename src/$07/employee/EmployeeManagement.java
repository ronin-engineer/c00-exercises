package $07.employee;

import $07.hotel.Room;
import $07.management.Assignment;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManagement implements Assignment {

    private Map<String, Employee> employeeMap = new HashMap<>();    // key: employeeId - value: Employee


    public EmployeeManagement() {
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    @Override
    public void assignRoom(String employeeId, Room room) {
        Employee employee = employeeMap.get(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found");
        }

        employee.getRooms().add(room);
    }
}
