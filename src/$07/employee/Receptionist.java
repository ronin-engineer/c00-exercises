package $07.employee;

import $07.employee.Employee;
import $07.management.Salary;

public class Receptionist extends Employee implements Salary {

    public static final int SALARY_RATE = 2;

    public Receptionist() {
    }

    public Receptionist(String id, String name) {
        super(id, name);
    }

    public void greet() {
        System.out.println("Welcome...");
    }


    @Override
    public Integer getSalary() {
        return getRooms().size() * SALARY_RATE;
    }
}
