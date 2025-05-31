public class BudgetPlanner {
    double income, rent, food, utilities, tuition, other;
    double transportation, booksSupplies, healthcare;

    public BudgetPlanner(double income, double rent, double food, double utilities, double tuition, double other,
                         double transportation, double booksSupplies, double healthcare) {
        this.income = income;
        this.rent = rent;
        this.food = food;
        this.utilities = utilities;
        this.tuition = tuition;
        this.other = other;
        this.transportation = transportation;
        this.booksSupplies = booksSupplies;
        this.healthcare = healthcare;
    }

    // Sum of necessary expenses
    public double needs() {
        return rent + food + utilities + tuition + transportation + booksSupplies + healthcare;
    }

    // Optional spending
    public double wants() {
        return other;
    }

    // Money left after expenses
    public double savings() {
        return income - (needs() + wants());
    }

    // Display budgeting tips
    public void displayBudgetTips() {
        System.out.println("\nBudgeting Tips for College Students:");
        System.out.println("- Needs should be around 50% of your income (e.g., rent, tuition, food).");
        System.out.println("- Wants should be no more than 30% (e.g., entertainment, eating out).");
        System.out.println("- Save at least 20% for emergencies, future expenses, or loan repayments.");
        System.out.println("- Track your spending weekly to avoid overspending.");
        System.out.println("- Look for student discounts and budget meal plans.");
    }

    // Apply the 50/30/20 rule and show recommended budget
    public void applyBudgetRule() {
        double recommendedNeeds = income * 0.50;
        double recommendedWants = income * 0.30;
        double recommendedSavings = income * 0.20;

        System.out.println("\nRecommended 50/30/20 Budget Breakdown:");
        System.out.printf("Needs (50%%): $%.2f\n", recommendedNeeds);
        System.out.printf("Wants (30%%): $%.2f\n", recommendedWants);
        System.out.printf("Savings (20%%): $%.2f\n", recommendedSavings);
    }

    // Evaluate and display the budget status
    public double calculateRemainingBudget() {
        displayBudgetTips();
        applyBudgetRule();

        double totalExpenses = needs() + wants();

        System.out.println("\nYour Current Spending:");
        System.out.printf("Needs: $%.2f\n", needs());
        System.out.printf("Wants: $%.2f\n", wants());
        System.out.printf("Savings: $%.2f\n", savings());

        if (totalExpenses > income) {
            System.out.println("\n⚠️ You are overspending! Your expenses exceed your income.");
        }

        if (needs() > income * 0.50) {
            System.out.println("⚠️ You are spending more than 50% on needs.");
        }

        if (wants() > income * 0.30) {
            System.out.println("⚠️ You are spending more than 30% on wants.");
        }

        if (savings() < income * 0.20) {
            System.out.println("⚠️ You are saving less than the recommended 20%.");
        }

        double remaining = income - totalExpenses;
        System.out.printf("\nRemaining Budget: $%.2f\n", remaining);

        return remaining;
    }
}
