package edu.xmu.java.rational;

public class Rational extends Number implements Comparable<Rational> { // 实现 Comparable 接口
    private int numerator;
    private int denominator;

    // 构造方法
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("分母不能为0");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = getGCD(Math.abs(numerator), denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Rational() {
        this(0, 1);
    }

    public Rational(int numerator) {
        this(numerator, 1);
    }

    public Rational(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("字符串不能为空");
        }
        String[] parts = str.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("字符串格式不正确");
        }
        try {
            int num = Integer.parseInt(parts[0].trim());
            int den = Integer.parseInt(parts[1].trim());
            this.numerator = num;
            this.denominator = den;
            if (denominator == 0) {
                throw new IllegalArgumentException("分母不可为零");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("分子分母必须是整数");
        }
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        int gcd = getGCD(Math.abs(this.numerator), this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    public Rational add(Rational r) {
        int num = numerator * r.denominator + denominator * r.numerator;
        int den = denominator * r.denominator;
        return new Rational(num, den);
    }

    public Rational subtract(Rational r) {
        int num = numerator * r.denominator - denominator * r.numerator;
        int den = denominator * r.denominator;
        return new Rational(num, den);
    }

    public Rational multiply(Rational r) {
        int num = numerator * r.numerator;
        int den = denominator * r.denominator;
        return new Rational(num, den);
    }

    public Rational divide(Rational r) {
        int num = numerator * r.denominator;
        int den = denominator * r.numerator;
        return new Rational(num, den);
    }

    public Rational abs() {
        return new Rational(Math.abs(numerator), denominator);
    }

    public boolean isPositive() {
        return numerator > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rational other = (Rational) obj;
        return numerator == other.numerator && denominator == other.denominator;
    }

    //  让 Rational 实现 Comparable<Rational> 接口，并重写 compareTo 方法
    @Override
    public int compareTo(Rational other) {
        // a/b 和 c/d 比较大小，转换成交叉相乘：
        return Integer.compare(this.numerator * other.denominator, other.numerator * this.denominator);
    }
}
