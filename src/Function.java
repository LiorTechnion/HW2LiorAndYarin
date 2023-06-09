/**
 * An abstract class that represents a general function.
 * Subclasses provide implementations for the value of the function, its string representation, and its derivative.
 */
abstract class Function {
    /**
     * Calculates the value of the function at a given value.
     *
     * @param x the given value
     * @return The calculated value of the function according to the given value
     */
    public abstract double valueAt(double x);

    /**
     * Returns the string representation of the function.
     *
     * @return The string representation of the function.
     */
    public abstract String toString();

    /**
     * Calculates the derivative of the function.
     *
     * @return The derivative of the function
     */
    public abstract Function derivative();

    /**
     * Performs the bisection method for finding the root of the function according the given interval.
     *
     * @param a The left endpoint
     * @param b The right endpoint
     * @param epsilon the desired accuracy
     * @return The root of the function given the specified interval
     */
    public  double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid;
        while (right - left > epsilon) {
            mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (left + right) / 2;
    }

    /**
     * Performs the bisection method for finding the root of the function according the given interval
     * With a default accuracy of 10^-5.
     *
     * @param a the left endpoint.\
     * @param b the right endpoint
     * @return The root of the function given the specified interval
     */
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }

    /**
     * Performs the Newton Raphson method for finding the root of the function,
     * starting from the given initial value.
     *
     * @param a The initial value
     * @param epsilon The desired accuracy
     * @return The root of the function
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            double fx = valueAt(a);
            double dfx = derivative().valueAt(a);
            a = a - (fx / dfx);
        }

        return a;
    }

    /**
     * Performs the Newton Raphson method for finding the root of the function,
     * starting from the given initial value.
     * With a default accuracy of 10^-5.
     *
     * @param a The initial value
     * @return The root of the function
     */
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    /**
     * Calculates the Taylor polynomial of the function according to the specified degree.
     *
     * @param n The given degree of the Taylor polynomial
     * @return The Taylor polynomial of the function according to the specified degree
     */
    public Function taylorPolynomial(int n) {
        Function function = this;
        ItemInPolynomial[] taylorItems = new ItemInPolynomial[n + 1];
        taylorItems[0] = new ItemInPolynomial(valueAt(0), 0);
        if (taylorItems.length > 1) {
            for (int i = 1; i < n + 1; i++) {
                function =  function.derivative();
                double factorial = 1.0;
                double derivative = function.valueAt(0);
                for (int j = 1; j <= i; j++) {
                    factorial *= j;
                }
                taylorItems[i] = new ItemInPolynomial((derivative / factorial), i);
            }
        }

        return new Polynomial(taylorItems);
    }
}
