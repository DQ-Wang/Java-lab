package edu.xmu.java.rational;


public class Main {
    public static void main(String[] args) {
        // 创建两个有理数对象
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(5, 6);

        // 测试加法
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));

        // 测试减法
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));

        // 测试乘法
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));

        // 测试除法
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));

        // 测试相等性
        Rational r3 = new Rational(6, 8); // 6/8 和 3/4 是相等的
        System.out.println(r1 + " 是否等于 " + r3 + "? " + r1.equals(r3));

        // 测试 compareTo 方法
        // 获取最大值
        Rational max = r1.compareTo(r2) > 0 ? r1 : r2;
        System.out.println("较大的有理数是: " + max);

        // 获取最小值
        Rational min = r1.compareTo(r2) < 0 ? r1 : r2;
        System.out.println("较小的有理数是: " + min);

        // 其他测试
        Rational r4 = new Rational(-7, 8);
        System.out.println("绝对值: " + r4 + " -> " + r4.abs());
        System.out.println(r4 + " 是否为正数? " + r4.isPositive());
    }
}
