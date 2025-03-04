public class BudgetTimeCalculation {

    // Ψ(x) = 1 - e^(-x)
    public static double psiFunction(double x) {
        return 1 - Math.exp(-x);
    }

    /**
     * Calculates the adjusted theta based on budget, time, and algorithm parameters.
     *
     * @param budgetRem     Remaining budget.
     * @param budgetOrig    Original budget.
     * @param timeRem       Remaining time.
     * @param timeOrig      Original time.
     * @param theta         Initial theta value.
     * @param fOver         Multiplier for ratio >= 1.
     * @param fBound        Minimum allowable theta value.
     * @return Adjusted theta value.
     */
    public static double calculateTheta(
            double budgetRem, double budgetOrig,
            double timeRem, double timeOrig,
            double theta, double fOver, double fBound) {

        if (budgetOrig <= 0 || timeOrig <= 0) {
            throw new IllegalArgumentException("Original budget and time must be greater than 0.");
        }

        // Step 1: Compute rB (budget ratio) and rT (time ratio)
        double rB = budgetRem / budgetOrig; // rB = budgetRem / budgetOrig
        double rT = timeRem / timeOrig;     // rT = timeRem / timeOrig

        // Step 2: Compute the ratio
        double ratio = rB / rT;

        // Step 3: Adjust theta based on the ratio
        if (ratio >= 1) {
            theta = theta * fOver; // Multiply theta by fOver
        } else {
            theta = 1.0; // Reset theta to 1.0
        }

        // Step 4: Enforce bounds on theta
        if (theta <= fBound) {
            theta = 0.001; // Minimum allowable theta
        }

        return theta;
    }

    public static void main(String[] args) {
        // Example inputs
        double budgetRem = 100;      // Remaining budget
        double budgetOrig = 100;    // Original budget
        double timeRem = 1440;         // Remaining time
        double timeOrig = 1440;       // Original time
        double initialTheta = 0.5;  // Initial theta
        double fOver = 1.5;         // Multiplier for ratio >= 1
        double fBound = 0.1;        // Minimum allowable theta

        try {
            double adjustedTheta = calculateTheta(
                    budgetRem, budgetOrig,
                    timeRem, timeOrig,
                    initialTheta, fOver, fBound);

            System.out.println("Adjusted Theta (θ): " + adjustedTheta);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

