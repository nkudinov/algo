public class PID {
    static int f(int t) {
        return t;
    }

    public static void main(String[] args) {
        double target = 100; // Desired setpoint
        double kp = 1.5; // Proportional gain
        double ki = 0.1; // Integral gain
        double kd = 0.5; // Derivative gain
        double currentOutput = f(100); // Initial system output
        double cumulativeError = 0; // For integral term
        double previousError = 0; // For derivative term

        for (int t = 100; t < 200; t++) {
            double error = target - currentOutput; // Calculate the error
            cumulativeError += error; // Update cumulative error
            double derivative = error - previousError; // Calculate rate of error change

            // Calculate PID terms
            double proportional = kp * error; // Proportional term
            double integral = ki * cumulativeError; // Integral term
            double derivativeTerm = kd * derivative; // Derivative term

            // Combine PID terms
            double control = proportional + integral + derivativeTerm; // PID control

            // Update the system's output
            currentOutput = f(t) + control;

            // Save the current error for the next iteration
            previousError = error;

            // Print results for the current step
            System.out.println("Time: " + t + ", Output: " + currentOutput);
        }
    }
}
