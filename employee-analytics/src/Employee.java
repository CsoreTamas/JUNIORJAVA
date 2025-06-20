import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String department;
    private ArrayList<String> day;
    private List<Integer> hoursADay;

    Employee() {
    }

    Employee(String firstName, String department, ArrayList<String> day, List<Integer> hoursADay) {
        this.name = firstName;
        this.department = department;
        this.day = day;
        this.hoursADay = hoursADay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getHoursADay() {
        return hoursADay;
    }

    public void setHoursADay(List<Integer> hoursADay) {
        this.hoursADay = hoursADay;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<String> getDay() {
        return day;
    }

    public void setDay(ArrayList<String> day) {
        this.day = day;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Department: ").append(department).append("\n");

        sb.append("Hours per day: ");
        for (int i = 0; i < day.size(); i++) {
            sb.append(day.get(i)).append(": ").append(hoursADay.get(i)).append("h | ");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(department, employee.department) && Objects.equals(day, employee.day) && Objects.equals(hoursADay, employee.hoursADay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, day, hoursADay);
    }
}