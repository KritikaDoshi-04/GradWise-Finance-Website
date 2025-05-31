public class DebtDecoder {
    public void explainLoanType(String loanType) {
        switch (loanType.toLowerCase()) {
            case "subsidized":
                System.out.println("Subsidized: Government pays interest while you're in school.");
                break;
            case "unsubsidized":
                System.out.println("Unsubsidized: Interest accrues from day one.");
                break;
            case "private":
                System.out.println("Private: Varies by lender. Higher interest rates.");
                break;
            default:
                System.out.println("Unknown loan type.");
        }
    }
}

