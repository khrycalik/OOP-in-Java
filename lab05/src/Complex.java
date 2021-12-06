import java.util.*;

public class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re=re;
        this.im=im;
    }

    public Complex(double re) {
        this(re, 0);
    }


    public Complex() {
        this.re=0;
        this.im=0;
    }

    public double getRe() {
        return this.re;
    }

    public double getIm() {
        return this.im;
    }


    @Override
    public String toString() {

        if (this.im == 0) return "" + this.re;

        if (this.re == 0) return "" + this.im + "i";

        return this.re + (im >= 0 ? " + " : " - ") + Math.abs(im) + "i";
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Complex tmp = (Complex) o;

        return this.re == tmp.re && this.im == tmp.im;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.re, this.im);
    }
}


