package com.company;

public class Main {
    public static double A = -0.5, B = 0;
    public static double x;
    public static double Len1 = 0, Len2 = 0;
    public static double a = 0.5, b = 1;
    public static double a0 = 1, a1 = -1, b0 = 1, b1 = 0;
    public static double h = 0.05; //частота
    public static double N = (B-A)/h; // Шаги
    public static double[] Z1 = new double[(int) (N +2)];
    public static double[] Z2 = new double[(int) (N +2)];
    public static double[] y = new double[(int) (N +2)];
    public static void progonka(){
        Z_1();
        Z_2();
        Y();
    }

    public static void Z_1(){
        double Z1_0 = -a0 / a1;
        System.out.println("Начальноe Z1:"+Z1_0);
        Z1[0] = Z1_0;
        x = a;
        for (int i = 1; i < N; i++) {
            Z1[i] = Z1_0 + h * (-Math.pow(Z1_0, 2) - p(x) * Z1_0 - q(x));
            Z1_0 = Z1[i];
            x += h;
            Len1 ++;
            System.out.println("Z1:");
            System.out.println(Z1[i]);
        }
    }
    public static void Z_2(){
        double Z2_0 = A / a1;
        System.out.println("Начальноe Z2:"+Z2_0);
        Z2[0] = Z2_0;
        x = a;
        for (int i = 1; i < N; i++) {
            Z2[i] = Z2_0 + h * (f(x) - Z2_0 * Z1[i] - p(x) * Z2_0);
            Z2_0 = Z2[i];
            x += h;
            Len2 ++;
            System.out.println("Z2:");
            System.out.println(Z2[i]);
        }
    }
    public static void Y(){
        double y0 = (B - Z2[(int)N]) / (b0 + b1 * Z1[(int)N]);
        System.out.println("Окончательное Y:"+y0);
        x = b;
        for (int i = (int)N-1;i >= 0;i--) {
            y[i] = y0 - h * ((Z1[i]) * y0 + Z2[i]);
            x -= h;
            y0 = y[i];
            System.out.println("Y:");
            System.out.println(y[i]);
        }
    }

    public static double p(double x){
        return 1;
    }
    public static double q(double x){
        return (-1/x);
    }
    public static double f(double x){
        return (x+1)/x;
    }

    public static void main(String[] args)
    {
        progonka();
    }
}
