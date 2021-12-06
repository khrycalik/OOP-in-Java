public class ComplexOperations{

    public static Complex add(Complex c1, Complex c2) {
            class Adding implements ComplexFunction {
                @Override
                public Complex calculate(Complex c1, Complex c2) {
                    return new Complex(c1.getRe() + c2.getRe(), c1.getIm() + c2.getIm());
                }
            }
            Adding add = new Adding();
        return calculate(c1, c2, add);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        ComplexFunction subtract = new ComplexFunction() {
            @Override
            public Complex calculate(Complex c1, Complex c2) {
                return new Complex(c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm());
            }
        };
        return calculate(c1, c2, subtract);
    }

    public static Complex multiply(Complex c1, Complex c2) {
        ComplexFunction multiply = (x,y) -> new Complex(x.getRe() * y.getRe() - x.getIm() * y.getIm(), x.getRe() * y.getIm() + x.getIm() * y.getRe());

        return calculate(c1, c2, multiply);
    }

    public static Complex divide(Complex c1, Complex c2) {
        ComplexFunction divide = (x,y) -> {
            double re = (x.getRe() * y.getRe() + x.getIm() * y.getIm()) / ( y.getRe() *  y.getRe() + y.getIm() * y.getIm()) ;
            double im = (x.getIm() * y.getRe() - x.getRe() * y.getIm()) / ( y.getRe() *  y.getRe() + y.getIm() * y.getIm());
            return new Complex(re, im);
        };
        return calculate(c1, c2, divide);
    }

    private static Complex calculate(Complex c1, Complex c2, ComplexFunction s) {
        return s.calculate(c1, c2);
    }
}
