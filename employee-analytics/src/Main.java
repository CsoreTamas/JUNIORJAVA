import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = FileReader.reader(Path.of("/Users/csoretamas/files/employee_hours.csv"));

        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.println("................");
        }
        //Determine the total weekly hours worked for each employee
        for (Employee emp : employees) {
            int total = EmployeeAnalytics.calculateWeeklyHours(emp);
            System.out.printf("%s worked %d hours a week. %n", emp.getName(), total);
        }
        System.out.println("--------------------------------------");

        //Calculate the average daily hours for each employee
        for (Employee emp : employees) {
            double average = EmployeeAnalytics.calculateAverageOfEach(emp);
            System.out.printf("%s's average is %.2f hours. %n", emp.getName(), average);
        }
        System.out.println("--------------------------------------");

        //Determine the average weekly hours in each department
        List<String> departmentsAverage = EmployeeAnalytics.getAverageByDepartments(employees);
        for (String line : departmentsAverage) {
            System.out.println(line);
        }
        System.out.println("--------------------------------------");

        //Identify the employee with the highest total hours globally
        System.out.println("The most diligent employee is:");
        Employee employee = EmployeeAnalytics.searchTheMostDiligentEmployee(employees);
        System.out.println(employee);

        System.out.println("--------------------------------------");

        //Identify the employee with the highest total hours in each department
        ArrayList<String> result = EmployeeAnalytics.searchTheMostDiligentEmployeeByDepartment(employees);
        for (String emp : result) {
            System.out.println(emp);
        }
    }
}