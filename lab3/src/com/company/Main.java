package com.company;

public class Main {

    public static double a = 0.2, b = 7.7, f0 = 3;
    public static double h = 0.5; //частота
    public static double N = (b - a) / h; // Шаги
    public static double[] y2 = new double[(int) (N + 2)];
    public static double[] y3 = new double[(int) (N + 2)];
    public static double[] y4 = new double[(int) (N + 2)];
    public static double[] ynow2 = new double[(int) (N + 2)];
    public static double[] ynow3 = new double[(int) (N + 2)];
    public static double[] ynow4 = new double[(int) (N + 2)];

    public static void A2() {
        y2[0] = f0;
        double x;
        x = a + h;
        y2[1] = y2[0] + h * F(x + h / 2, y2[0] + h / 2 * F(x, y2[0]));
        for (int i = 0; i < N - 1; i++) {
            x = x + (i + 1) * h;
            ynow2[i + 2] = y2[i + 1] + h / 2 * (3 * F(x, y2[i + 1] - F(x, y2[i])));
            y2[i + 2] = y2[i + 1] + h / 2 * (F(x, ynow2[i + 2] + F(x, y2[i + 1])));
            System.out.println(ynow2[i+2]);
            System.out.println(y2[i+2]);

        }

    }

    public static void A3() {
        y3[0] = f0;
        double x;
        x = a + h;
        y3[1] = y3[0] + h * (K1(x, y3[0]) + 4 * K2(x, y3[0]) + K3(x, y3[0])) / 6;
        x = x + h;
        y3[2] = y3[1] + h * (K1(x, y3[1]) + 4 * K2(x, y3[1]) + K3(x, y3[1])) / 6;
        for (int i = 0; i < N - 2; i++) {
            x = x + (i + 1) * h;
            ynow3[i + 3] = y3[i + 2] + h / 12 * (23 * F(x, y3[i + 2]) - 16 * F(x, y3[i + 1]) + 5 * F(x, y3[i]));
            y3[i + 3] = y3[i + 2] + h / 12 * (5 * F(x, ynow3[i + 3]) + 8 * F(x, y3[i + 2]) - F(x, y3[i + 1]));
            System.out.println(ynow3[i+3]);
            System.out.println(y3[i+3]);
        }

    }

    public static void A4() {
        y4[0] = f0;
        double x;
        x = a + h;
        y4[1] = y4[0] + h / 6 * (K1(x, y4[0]) + 2 * K2(x, y4[0]) + 2 * K3(x, y4[0]) + K4(x, y4[0]));
        x = x + h;
        y4[2] = y4[1] + h / 6 * (K1(x, y4[1]) + 2 * K2(x, y4[1]) + 2 * K3(x, y4[1]) + K4(x, y4[1]));
        x = x + h;
        y4[3] = y4[2] + h / 6 * (K1(x, y4[2]) + 2 * K2(x, y4[2]) + 2 * K3(x, y4[2]) + K4(x, y4[2]));
        for (int i = 0; i < N - 3; i++) {
            x = x + (i + 1) * h;
            ynow4[i + 4] = y4[i + 3] + h / 24 * (55 * F(x, y4[i + 3]) - 59 * F(x, y4[i + 2]) + 37 * F(x, y4[i + 1]) - 9 * F(x, y4[i]));
            y4[i + 4] = y4[i + 3] + h / 24 * (9 * F(x, ynow4[i + 4]) + 19 * F(x, y4[i + 3]) - 5 * F(x, y4[i + 2]) + F(x, y4[i + 1]));
            System.out.println(ynow4[i+4]);
            System.out.println(y4[i+4]);

        }
    }


    public static double F ( double x, double y)
    {
        return ((Math.sin(y) / (Math.pow(x, 2) + 5)) + x * Math.cos(x));
    }
    public static double K1 ( double x, double y)
    {
        return F(x, y);
    }
    public static double K2 ( double x, double y)
    {
        return F(x + h / 2, y + h * K1(x, y) / 2);
    }
    public static double K3 ( double x, double y)
    {
        return F(x + h / 2, y + h * K2(x, y) / 2);
    }
    public static double K4 ( double x, double y)
    {
        return F(x + h, y + h * K3(x, y));
    }

    public static void main(String[] args)
    {
        System.out.println("Явный и неявный методы Адамса 2-го порядка:");
        A2();
        System.out.println("Явный и неявный методы Адамса 3-го порядка:");
        A3();
        System.out.println("Явный и неявный методы Адамса 4-го порядка:");
        A4();

    }
}
