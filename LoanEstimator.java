public class LoanEstimator {
    private double principal;
    private double annualInterestRate;
    private int years;

    public LoanEstimator(double principal, double rate, int years) {
        if (principal <= 0 || rate < 0 || years <= 0) {
            throw new IllegalArgumentException("Loan inputs must be positive. Interest rate cannot be negative.");
        }
        this.principal = principal;
        this.annualInterestRate = rate / 100.0; // Convert percent to decimal
        this.years = years;
    }

    public double calculateMonthlyPayment() {
        double monthlyRate = annualInterestRate / 12;
        int totalMonths = years * 12;

        if (annualInterestRate == 0) {
            return principal / totalMonths;
        }

        return (principal * monthlyRate) /
               (1 - Math.pow(1 + monthlyRate, -totalMonths));
    }

    public double getTotalRepayment() {
        return calculateMonthlyPayment() * years * 12;
    }

    public double getTotalInterestPaid() {
        return getTotalRepayment() - principal;
    }

    public void printLoanSummary() {
        System.out.println("\n📘 Loan Summary:");
        System.out.printf("Principal Amount    : $%.2f\n", principal);
        System.out.printf("Annual Interest Rate: %.2f%%\n", annualInterestRate * 100);
        System.out.printf("Loan Term           : %d years\n", years);
        System.out.printf("Monthly Payment     : $%.2f\n", calculateMonthlyPayment());
        System.out.printf("Total Repayment     : $%.2f\n", getTotalRepayment());
        System.out.printf("Total Interest Paid : $%.2f\n", getTotalInterestPaid());

        if (annualInterestRate > 0 && getTotalInterestPaid() > principal * 0.5) {
            System.out.println("⚠️  This loan will cost you significantly in interest. Consider larger payments if possible.");
        }
    }
}
