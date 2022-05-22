package lesson3;

public class MyComplex {
    private double real;
    private double imaginary;

    public MyComplex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }

    public MyComplex add(MyComplex other) {
        return new MyComplex(real + other.real, imaginary + other.imaginary);
    }

    public MyComplex subtract(MyComplex other) {
        return new MyComplex(real - other.real, imaginary - other.imaginary);
    }

    public MyComplex multiply(MyComplex other) {
        return new MyComplex(real * other.real - imaginary * other.imaginary, real * other.imaginary + imaginary * other.real);
    }

    public MyComplex divide(MyComplex other) {
        return new MyComplex((real * other.real + imaginary * other.imaginary) / (other.real * other.real + other.imaginary * other.imaginary), (imaginary * other.real - real * other.imaginary) / (other.real * other.real + other.imaginary * other.imaginary));
    }

    public boolean equals(MyComplex other) {
        return (real == other.real && imaginary == other.imaginary);
    }

    public static void main(String[] args) {
        MyComplex m1 = new MyComplex(3.4, 8.0);
        MyComplex m2 = new MyComplex(3.4, 8.0);
        System.out.println("m1=" + m1);
        System.out.println("m2=" + m2);
        System.out.println("m1==m2=" + (m1 == m2));
        System.out.println("m1.equals(m2)=" + m1.equals(m2));
        MyComplex m3 = new MyComplex(4.4, -8.9);
        System.out.println("m3=" + m3);
        MyComplex m4 = m1.add(m3);
        MyComplex m5 = m2.subtract(m3);
        MyComplex m6 = m1.multiply(m2);
        MyComplex m7 = m1.divide(m2);
        System.out.println("m1+m3=" + m4);
        System.out.println("m2-m3=" + m5);
        System.out.println("m1*m2=" + m6);
        System.out.println("m1/m2=" + m7);
    }
}
