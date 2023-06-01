abstract class Function {
    public abstract double valueAt(double x);
    public abstract String toString();
    public abstract Function derivative();
    public  double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid;
        /*int maxIterations = 1000; // Set a maximum number of iterations */

        /*int iterations = 0; */
        while (right - left > epsilon /*&& iterations < maxIterations*/) {
            mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
            /*iterations++;*/
        }

        return (left + right) / 2;
    }
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }
    public abstract double newtonRaphsonMethod(double a, double epsilon);
    public  double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }
    public Function taylorPolynomial(int n) {
        ItemInPolynomial[] taylorItems = new ItemInPolynomial[n + 1];
        taylorItems[0] = new ItemInPolynomial(valueAt(0), 0);

        Function function = this;
        if (taylorItems.length > 1) {
            for (int i = 1; i < n + 1; i++) {
                function =  function.derivative();
                int count = 1;
                double derivative = function.valueAt(0);
                for (int j = 1; j <= i; j++) {
                    count *= j;
                }
                double dc = derivative / count;
                /*
                String dcStr = String.valueOf(dc);
                String[] dcSplit = dcStr.split("");
                if(dcSplit[1].equals("-")) {
                    dc = -(derivative / count);
                }
                 */
                taylorItems[i] = new ItemInPolynomial(dc, i);
            }
        }

        return new Polynomial(taylorItems);

        /*
        ItemInPolynomial[] taylorItems = new ItemInPolynomial[n + 1];
        taylorItems[0] = new ItemInPolynomial(valueAt(0), 0);

        if (taylorItems.length > 1) {
            for (int i = 1; i < n + 1; i++) {
                int count = 1;
                double derivative = derivative().valueAt(i); // Calculate derivative at exponent i
                for (int j = 1; j <= i; j++) {
                    count *= j; // Calculate factorial by multiplying count with j
                }
                taylorItems[i] = new ItemInPolynomial(derivative / count, i);
            }
        }

        return new Polynomial(taylorItems);
         */

        /*
        ItemInPolynomial[] taylorItems = new ItemInPolynomial[n + 1];
        taylorItems[0] = new ItemInPolynomial(valueAt(0), 0);
        if(taylorItems.length > 1) {
            for (int i = 1; i < n + 1; i++) {
                int count = 1;
                double derivative = derivative().valueAt(0);
                for(int j = i; j != 0; j--) {
                    count *= j;
                }
                taylorItems[i] = new ItemInPolynomial(derivative/count, i);
            }
        }
        return new Polynomial(taylorItems);
         */
    }

}
