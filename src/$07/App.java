package $07;

import $07.employee.*;
import $07.hotel.Hotel;
import $07.hotel.Room;
import $07.management.Salary;

import java.util.Scanner;

public class App {

    private static Hotel hotel = new Hotel("Ronin Hotel");
    private static EmployeeManagement employeeManagement = new EmployeeManagement();


    public static void printMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("------------  HOTEL MANAGEMENT  --------------");
        System.out.println("----------------------------------------------");
        System.out.println("1. Configure room");
        System.out.println("2. Configure employee");
        System.out.println("3. Assign room to employee");
        System.out.println("4. Get list of rooms by employee");
        System.out.println("5. Get salary of employee");
        System.out.println("0. Exit");
        System.out.print("Select option: ");
    }

    public static void configRoom() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter room id: ");
        String roomId = input.nextLine();

        System.out.print("Enter room name: ");
        String roomName = input.nextLine();

        if (hotel.getRoomMap().get(roomId) != null) {
            throw new RuntimeException("The room exists!!!");
        }

        Room room = new Room(roomId, roomName);
        hotel.getRoomMap().put(roomId, room);
        System.out.println("Inserted a new room: " + roomId);
    }

    public static void configEmployee() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee id: ");
        String employeeId = input.nextLine();

        System.out.print("Enter employee name: ");
        String employeeName = input.nextLine();

        System.out.println("Types of employee:");
        System.out.println("1. Labor");
        System.out.println("2. Receptionist");
        System.out.println("3. Manager");
        System.out.println("4. Boss");

        System.out.print("Enter type of employee: ");
        String employeeType = input.nextLine();

        if (employeeManagement.getEmployeeMap().containsKey(employeeId)) {
            throw new RuntimeException("The employee exists!");
        }

        Employee employee;
        switch (employeeType) {
            case "1" -> employee = new Labor(employeeId, employeeName);
            case "2" -> employee = new Receptionist(employeeId, employeeName);
            case "3" -> employee = new Manager(employeeId, employeeName);
            case "4" -> employee = new Boss(employeeId, employeeName);
            default -> throw new RuntimeException("Invalid Type of Employee!");
        }

        employeeManagement.getEmployeeMap().put(employeeId, employee);
        System.out.println("Inserted employee: " + employeeId);
    }

    public static void assignRoomToEmployee() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter room id: ");
        String roomId = input.nextLine();
        Room room = hotel.getRoomMap().get(roomId);
        if (room == null) {
            throw new RuntimeException("Room not found");
        }

        System.out.print("Enter employee id: ");
        String employeeId = input.nextLine();
        employeeManagement.assignRoom(employeeId, room);
        System.out.println("Assigned room: " + roomId + " to employee: " + employeeId);
    }

    public static void getRoomsByEmployee() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee id: ");
        String employeeId = input.nextLine();
        Employee employee = employeeManagement.getEmployeeMap().get(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found");
        }

        System.out.println("Employee " + employee.getId() + " (" + employee.getName() + ") takes care rooms:");
        for (Room room: employee.getRooms()) {
            System.out.printf("Room: %s - %s\n", room.getId(), room.getName());
        }
    }

    public static void getSalary() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee id: ");
        String employeeId = input.nextLine();
        Employee employee = employeeManagement.getEmployeeMap().get(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found");
        }


        Salary salaryEmployee;
        if (employee instanceof Labor) {
            salaryEmployee = ((Labor) employee);
        }
        else if (employee instanceof Receptionist) {
            salaryEmployee = ((Receptionist) employee);
        }
        else if (employee instanceof Manager) {
            salaryEmployee = ((Manager) employee);
        }
        else {
            throw new RuntimeException("Boss has no salary!");
        }

        int salary = salaryEmployee.getSalary();
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] agrs) {
        int option;
        Scanner input = new Scanner(System.in);

        while (true) {
            printMenu();
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("Exception at scanning option: " + e);
                continue;
            }

            if (option == 0)
                break;

            try {
                switch (option) {
                    case 1 -> configRoom();
                    case 2 -> configEmployee();
                    case 3 -> assignRoomToEmployee();
                    case 4 -> getRoomsByEmployee();
                    case 5 -> getSalary();
                    default -> System.out.println("Invalid Option! Please try again");
                }
            }
            catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
