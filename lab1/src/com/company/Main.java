package com.company;
import java.lang.*;

public class Main
{
    public static double func(double t, double y)
    {
        return (-y/t+((t+1)/t)*Math.exp(t));
    }
    public static void explicit()
    {
        double y0=Math.E;
        double h=0.05;
        double t0=1;
        int i=0;
        do{
            double y1=y0+h*func(t0,y0);
            double dif=Math.abs(y1-y0);
            System.out.println("i= "+i+" t= "+t0+" y= "+y1+" difference between y= "+dif);
            y0=y1;
            t0+=h;
            i++;
        }while(t0<2);
    }
    public static void koshieiler()
    {
        double y0=Math.E;
        double h=0.1;
        double t0=1;
        int i=0;
        do{
            double y_1=y0+h*func(t0,y0);
            double y1=y0+h/2*(func(t0,y0)+func(t0+h,y_1));
            double dif=Math.abs(y1-y0);
            System.out.println("i= "+i+" t= "+t0+" y= "+y1+" difference between y= "+dif);
            y0=y1;
            t0+=h;
            i++;
        }while(t0<2);
    }
    public static void main(String[] args) {
	explicit();
	System.out.println("\n\n");
	koshieiler();
    }
}
