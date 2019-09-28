package com.company;
import java.lang.*;



    public class Main{
        public static double funcy(double x, double y, double z) {
            return (2 * x - 3 * y - 4 * z);
        }

        public static double funcz(double x, double y, double z) {
            return (x + y + z);
        }

        public static double ym(double x) {
            return (14 * (1 - Math.exp(-x)) - 2 * x * (3 + 4 * Math.exp(-x)));
        }

        public static double zm(double x) {
            return (-20 * Math.exp(2 * x) + 8 * Math.exp(3 * x) + 3 * Math.exp(x) + 12 * x + 10);
        }

        public static void main(String[] args) {
            double y0=0;
            double z0=0;
            double h=0.2;
            for(double x0=0;x0<=1;x0+=h){
                y0=y0+h*funcy(x0,y0,z0);
                z0=z0+h*funcz(x0,y0,z0);
                System.out.printf("y=%7f z=%7f Ym=%7f Zm=%7f%n",y0,z0,ym(x0),zm(x0));

        }
    }
}
