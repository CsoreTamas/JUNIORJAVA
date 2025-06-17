import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAnalyticsTest {
    @Test
    void shouldCalculateWeeklyHours() {
        Employee employee = new Employee();
        ArrayList<Integer> hours = new ArrayList<>(List.of(10, 10, 10, 10, 10));
        employee.setHoursADay(hours);
        Assertions.assertEquals(50, EmployeeAnalytics.calculateWeeklyHours(employee));
    }

    @Test
    void shouldCalculateAverage() {
        Employee employee = new Employee();
        ArrayList<Integer> hours = new ArrayList<>(List.of(10, 10, 10, 10, 10));
        employee.setHoursADay(hours);
        Assertions.assertEquals(10.0, EmployeeAnalytics.calculateAverageOfEach(employee));
    }

    @Test
    void shouldGetAverageByDepartment() {
        ArrayList<String> result = new ArrayList<>(List.of("IT weekly average is 43,50 hours.", "Actor weekly average is 36,00 hours."));
        ArrayList<Employee> employees = new ArrayList<>();

        Employee janos = new Employee();
        janos.setDepartment("IT");
        employees.add(janos);
        ArrayList<Integer> janosHours = new ArrayList<>(List.of(9, 9, 9, 9, 9));
        janos.setHoursADay(janosHours);

        Employee peti = new Employee();
        peti.setDepartment("IT");
        employees.add(peti);
        ArrayList<Integer> petiHours = new ArrayList<>(List.of(8, 9, 8, 10, 7));
        peti.setHoursADay(petiHours);

        Employee geza = new Employee();
        geza.setDepartment("Actor");
        employees.add(geza);
        ArrayList<Integer> gezaHours = new ArrayList<>(List.of(7, 6, 8, 8, 7));
        geza.setHoursADay(gezaHours);

        Assertions.assertEquals(result, EmployeeAnalytics.getAverageByDepartments(employees));

    }

    @Test
    void shouldFindTheMostDiligentEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee janos = new Employee();
        ArrayList<Integer> janosHours = new ArrayList<>(List.of(10, 10, 10, 10, 19));
        janos.setHoursADay(janosHours);
        employees.add(janos);

        Employee bela = new Employee();
        ArrayList<Integer> belaHours = new ArrayList<>(List.of(10, 10, 10, 10, 10));
        bela.setHoursADay(belaHours);
        employees.add(bela);

        Assertions.assertEquals(janos, EmployeeAnalytics.searchTheMostDiligentEmployee(employees));
    }

    @Test
    void shouldFindTheMostDiligentEmployeesByDepartment() {
        ArrayList<String> result = new ArrayList<>(List.of(
                "Top employee in IT: Janos worked 45 hours.",
                "Top employee in Actor: Geza worked 36 hours."
        ));
        ArrayList<Employee> employees = new ArrayList<>();

        Employee janos = new Employee();
        janos.setDepartment("IT");
        janos.setName("Janos");
        employees.add(janos);
        ArrayList<Integer> janosHours = new ArrayList<>(List.of(9, 9, 9, 9, 9));
        janos.setHoursADay(janosHours);

        Employee peti = new Employee();
        peti.setDepartment("IT");
        employees.add(peti);
        ArrayList<Integer> petiHours = new ArrayList<>(List.of(8, 9, 8, 10, 7));
        peti.setHoursADay(petiHours);

        Employee geza = new Employee();
        geza.setDepartment("Actor");
        geza.setName("Geza");
        employees.add(geza);
        ArrayList<Integer> gezaHours = new ArrayList<>(List.of(7, 6, 8, 8, 7));
        geza.setHoursADay(gezaHours);

        Assertions.assertEquals(result, EmployeeAnalytics.searchTheMostDiligentEmployeeByDepartment(employees));
    }
}
