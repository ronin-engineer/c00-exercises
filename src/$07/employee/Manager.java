package $07.employee;

import $07.management.Salary;

public class Manager extends Employee implements Salary {

    public static final int SALARY_RATE = 3;

    public Manager() {
    }

    public Manager(String id, String name) {
        super(id, name);
    }

    public void interview() {
        System.out.println("Interview...");
    }

    @Override
    public Integer getSalary() {
        return getRooms().size() * SALARY_RATE;
    }
}
