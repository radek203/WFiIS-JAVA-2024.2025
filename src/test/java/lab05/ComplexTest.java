package lab05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexTest {

    @Test
    public void testComplex() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex c3 = new Complex(5);
        Complex c4 = new Complex();
        assertEquals("1.0+2.0i", c1.toString());
        assertEquals("3.0+4.0i", c2.toString());
        assertEquals("5.0+0.0i", c3.toString());
        assertEquals("0.0+0.0i", c4.toString());
    }

    @Test
    public void testSet() {
        Complex c = new Complex();
        c.set(1, 2);
        assertEquals("1.0+2.0i", c.toString());
    }

    @Test
    public void testSetRe() {
        Complex c = new Complex();
        c.setRe(1);
        assertEquals("1.0+0.0i", c.toString());
    }

    @Test
    public void testSetIm() {
        Complex c = new Complex();
        c.setIm(2);
        assertEquals("0.0+2.0i", c.toString());
    }

    @Test
    public void testGetRe() {
        Complex c = new Complex(1, 2);
        assertEquals(1, c.getRe());
    }

    @Test
    public void testGetIm() {
        Complex c = new Complex(1, 2);
        assertEquals(2, c.getIm());
    }

    @Test
    void addTwoComplexNumbers() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex result = Complex.add(c1, c2);
        assertEquals(4, result.getRe());
        assertEquals(6, result.getIm());
    }

    @Test
    void addComplexNumberAndDouble() {
        Complex c1 = new Complex(1, 2);
        double d = 3;
        Complex result = Complex.add(c1, d);
        assertEquals(4, result.getRe());
        assertEquals(2, result.getIm());
    }

    @Test
    void addDoubleAndComplexNumber() {
        double d = 3;
        Complex c1 = new Complex(1, 2);
        Complex result = Complex.add(d, c1);
        assertEquals(4, result.getRe());
        assertEquals(2, result.getIm());
    }

    @Test
    void subtractTwoComplexNumbers() {
        Complex c1 = new Complex(5, 6);
        Complex c2 = new Complex(3, 4);
        Complex result = Complex.sub(c1, c2);
        assertEquals(2, result.getRe());
        assertEquals(2, result.getIm());
    }

    @Test
    void subtractComplexNumberAndDouble() {
        Complex c1 = new Complex(5, 6);
        double d = 3;
        Complex result = Complex.sub(c1, d);
        assertEquals(2, result.getRe());
        assertEquals(6, result.getIm());
    }

    @Test
    void subtractDoubleAndComplexNumber() {
        double d = 5;
        Complex c1 = new Complex(3, 4);
        Complex result = Complex.sub(d, c1);
        assertEquals(2, result.getRe());
        assertEquals(-4, result.getIm());
    }

    @Test
    void multiplyTwoComplexNumbers() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex result = Complex.mul(c1, c2);
        assertEquals(-5, result.getRe());
        assertEquals(10, result.getIm());
    }

    @Test
    void multiplyComplexNumberAndDouble() {
        Complex c1 = new Complex(1, 2);
        double d = 3;
        Complex result = Complex.mul(c1, d);
        assertEquals(3, result.getRe());
        assertEquals(6, result.getIm());
    }

    @Test
    void multiplyDoubleAndComplexNumber() {
        double d = 3;
        Complex c1 = new Complex(1, 2);
        Complex result = Complex.mul(d, c1);
        assertEquals(3, result.getRe());
        assertEquals(6, result.getIm());
    }

    @Test
    void divideTwoComplexNumbers() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex result = Complex.div(c1, c2);
        assertEquals(0.44, result.getRe(), 0.01);
        assertEquals(0.08, result.getIm(), 0.01);
    }

    @Test
    void divideComplexNumberAndDouble() {
        Complex c1 = new Complex(1, 2);
        double d = 2;
        Complex result = Complex.div(c1, d);
        assertEquals(0.5, result.getRe());
        assertEquals(1, result.getIm());
    }

    @Test
    void divideDoubleAndComplexNumber() {
        double d = 2;
        Complex c1 = new Complex(1, 2);
        Complex result = Complex.div(d, c1);
        assertEquals(0.4, result.getRe(), 0.01);
        assertEquals(-0.8, result.getIm(), 0.01);
    }

}
