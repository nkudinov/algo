public class BudgetCalculation {
    // Ψ(x) = 1 - e^(-x)
    public static double psiFunction(double x) {
        return 1 - Math.exp(-x);
    }

    // Method to calculate θ based on budgetrem and budgetorig
    public static double calculateTheta(double budgetRem, double budgetOrig) {
        if (budgetOrig <= 0) {
            throw new IllegalArgumentException("Original budget (budgetOrig) must be greater than 0.");
        }

        double x = budgetRem / budgetOrig; // x = budgetrem / budgetorig
        double theta = psiFunction(x) / psiFunction(1); // θ = Ψ(x) / Ψ(1)
        return theta;
    }

    public static void main(String[] args) {
        // Example inputs
        double budgetRem = 1;   // Remaining budget
        double budgetOrig = 100; // Original budget

        try {
            double theta = calculateTheta(budgetRem, budgetOrig);
            System.out.println("Theta (θ) value: " + theta);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
