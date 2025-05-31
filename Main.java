import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to GradWise Finance - Your Financial Planning App");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Estimate Loan Payment");
            System.out.println("2. Plan Monthly Budget");
            System.out.println("3. Find Financial Aid");
            System.out.println("4. Decode Loan Types");
            System.out.println("5. Exit");
            System.out.println("_");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter loan amount: ");
                    double principal = scanner.nextDouble();
                    System.out.print("Enter annual interest rate (%): ");
                    double rate = scanner.nextDouble();
                    System.out.print("Enter loan term in years: ");
                    int years = scanner.nextInt();

                    LoanEstimator loan = new LoanEstimator(principal, rate, years);
                    System.out.printf("Monthly Payment: $%.2f\n", loan.calculateMonthlyPayment());
                    break;

                case 2:
                    System.out.print("Enter total monthly income: ");
                    double income = scanner.nextDouble();

                    System.out.print("Enter monthly rent: ");
                    double rent = scanner.nextDouble();

                    System.out.print("Enter monthly food cost: ");
                    double food = scanner.nextDouble();

                    System.out.print("Enter monthly utilities: ");
                    double utilities = scanner.nextDouble();

                    System.out.print("Enter monthly tuition: ");
                    double tuition = scanner.nextDouble();

                    System.out.print("Enter monthly other expenses (entertainment, subscriptions, etc.): ");
                    double other = scanner.nextDouble();

                    System.out.print("Enter monthly transportation cost: ");
                    double transportation = scanner.nextDouble();

                    System.out.print("Enter monthly books & supplies cost: ");
                    double booksSupplies = scanner.nextDouble();

                    System.out.print("Enter monthly healthcare/insurance cost: ");
                    double healthcare = scanner.nextDouble();

                    BudgetPlanner budget = new BudgetPlanner(
                        income, rent, food, utilities, tuition, other,
                        transportation, booksSupplies, healthcare
                    );

                    System.out.printf("Remaining Budget: $%.2f\n", budget.calculateRemainingBudget());
                    break;


                case 3:
                    AidFinder aidFinder = new AidFinder();
                    aidFinder.listScholarships();
                    break;

                case 5:
                    System.out.print("Enter loan type (subsidized/unsubsidized/private): ");
                    scanner.nextLine(); // Consume newline
                    String loanType = scanner.nextLine();
                    DebtDecoder decoder = new DebtDecoder();
                    decoder.explainLoanType(loanType);
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for using GradWise Finance!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
} 
