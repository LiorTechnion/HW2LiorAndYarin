public class Constant implements Function {
    private final double c;
    public Constant(double c) {
        this.c = c;
    }

    @Override
    public double valueAt(double x) {
        return c;
    }
    @Override
    public String toString(){
        return String.valueOf(this.c);
    }
    @Override
    public Function derivative() {
        return new Constant(0);
    }

    //TODO : 1)to ask dvir what we need to return (if c = 0 or c != 0)
    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return 0;
    }

    //TODO : ask about division with 0
    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return 0;
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        return new Polynomial(this.c);
    }
}
