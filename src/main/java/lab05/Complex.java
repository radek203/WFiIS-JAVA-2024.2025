package lab05;

public class Complex {

    private double a;
    private double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex(double a) {
        this(a, 0);
    }

    public Complex() {
        this(0, 0);
    }

    public void set(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setRe(double a) {
        this.a = a;
    }

    public void setIm(double b) {
        this.b = b;
    }

    public double getRe() {
        return a;
    }

    public double getIm() {
        return b;
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }

    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.a + c2.a, c1.b + c2.b);
    }

    public static Complex add(Complex c1, double d) {
        return new Complex(c1.a + d, c1.b);
    }

    public static Complex add(double d, Complex c1) {
        return add(c1, d);
    }

    public static Complex sub(Complex c1, Complex c2) {
        return new Complex(c1.a - c2.a, c1.b - c2.b);
    }

    public static Complex sub(Complex c1, double d) {
        return new Complex(c1.a - d, c1.b);
    }

    public static Complex sub(double d, Complex c1) {
        return new Complex(d - c1.a, -c1.b);
    }

    public static Complex mul(Complex c1, Complex c2) {
        return new Complex(c1.a * c2.a - c1.b * c2.b, c1.a * c2.b + c1.b * c2.a);
    }

    public static Complex mul(Complex c1, double d) {
        return new Complex(c1.a * d, c1.b * d);
    }

    public static Complex mul(double d, Complex c1) {
        return mul(c1, d);
    }

    public static Complex div(Complex c1, Complex c2) {
        double a = (c1.a * c2.a + c1.b * c2.b) / (c2.a * c2.a + c2.b * c2.b);
        double b = (c1.b * c2.a - c1.a * c2.b) / (c2.a * c2.a + c2.b * c2.b);
        return new Complex(a, b);
    }

    public static Complex div(Complex c1, double d) {
        return new Complex(c1.a / d, c1.b / d);
    }

    public static Complex div(double d, Complex c1) {
        double a = (d * c1.a) / (c1.a * c1.a + c1.b * c1.b);
        double b = (-d * c1.b) / (c1.a * c1.a + c1.b * c1.b);
        return new Complex(a, b);
    }

}
