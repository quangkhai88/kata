package employee;

import java.util.function.Predicate;

public class AdultFilter extends EmployeeFilter {
    @Override
    public Predicate<Employee> getPredicate() {
        return new AdultEmployeePredicate();
    }
}
