public class Main {
    public static void main(String[] args) {
        Loan loan = new Loan(2.5, 5, 10000);
        System.out.printf("Monthly: %.2f  Total: %.2f%n", loan.getMonthlyPayment(), loan.getTotalPayment());
        System.out.println("Date: " + loan.getLoanDate());
        Loan d = new Loan();
        System.out.printf("Default monthly: %.2f%n", d.getMonthlyPayment());

        BMI b = new BMI("Ali", 150, 68);
        System.out.printf("%s age %d BMI %.2f %s%n", b.getName(), b.getAge(), b.getBMI(), b.getStatus());

        Course c = new Course("Java");
        for (String s : new String[]{"A", "B", "C", "D", "E", "F"}) c.addStudent(s);
        c.dropStudent("C");
        System.out.println(c.getNumberOfStudents() + " " + String.join(",", c.getStudents()));
    }
}
