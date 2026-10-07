import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // default loan: 2.5%, 1 year, 1000
    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date(); // current date at creation
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // rate is a percentage (2.5 means 2.5%), so monthly rate = rate / 1200
    public double getMonthlyPayment() {
        double r = annualInterestRate / 1200;
        int n = numberOfYears * 12;
        if (r == 0) {
            return loanAmount / n; // no interest, avoid dividing by zero
        }
        return loanAmount * r / (1 - Math.pow(1 + r, -n));
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}
