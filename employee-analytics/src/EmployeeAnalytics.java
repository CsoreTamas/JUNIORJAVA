import java.util.ArrayList;

public class EmployeeAnalytics {

    public static int calculateWeeklyHours(Employee employee) {
        int hours = 0;
        for (int hour : employee.getHoursADay()) {
            hours += hour;
        }
        return hours;
    }

    public static double calculateAverageOfEach(Employee employee) {
        ArrayList<Integer> hours = employee.getHoursADay();
        int total = 0;
        for (int hour : hours) {
            total += hour;
        }
        return (double) total / hours.size();
    }

    public static ArrayList<String> getAverageByDepartments(ArrayList<Employee> employees) {
        ArrayList<String> departments = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (!departments.contains(emp.getDepartment())) {
                departments.add(emp.getDepartment());
            }
        }
        for (String department : departments) {
            int total = 0;
            int empCounter = 0;

            for (Employee employee : employees) {
                if (employee.getDepartment().equals(department)) {
                    total += calculateWeeklyHours(employee);
                    empCounter++;
                }
            }
            double average = (double) total / empCounter;
            result.add(String.format("%s weekly average is %.2f hours.", department, average));
        }
        return result;
    }

    public static Employee searchTheMostDiligentEmployee(ArrayList<Employee> employees) {
        Employee topEmployee = null;
        int highest = 0;
        for (Employee emp : employees) {
            if (calculateWeeklyHours(emp) > highest) {
                highest = calculateWeeklyHours(emp);
                topEmployee = emp;
            }
        }
        return topEmployee;
    }

    public static ArrayList<String> searchTheMostDiligentEmployeeByDepartment(ArrayList<Employee> employees) {
        ArrayList<String> departments = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (!departments.contains(employee.getDepartment())) {
                departments.add(employee.getDepartment());
            }
        }
        for (String department : departments) {
            Employee topEmp = null;
            int maxHour = 0;

            for (Employee employee : employees) {
                if (employee.getDepartment().equals(department)) {
                    int hours = calculateWeeklyHours(employee);
                    if (hours > maxHour) {
                        topEmp = employee;
                        maxHour = hours;
                    }
                }
            }
            if (topEmp != null) {
                result.add(String.format("Top employee in %s: %s worked %d hours.", department, topEmp.getName(), maxHour));
            }
        }
        return result;
    }
}
