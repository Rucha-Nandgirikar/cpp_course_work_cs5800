package cpp.cs5800.adv_swe.assignment1.inheritance;

public class SalariedEmployee extends Employee{
    Double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, Double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    public Double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(Double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", weeklySalary= $" + weeklySalary +
                '}';
    }
}
