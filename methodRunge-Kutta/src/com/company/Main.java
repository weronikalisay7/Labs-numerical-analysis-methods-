package com.company;

public class Main {
    public static double a = 0.2, b = 7.7, f0 = 3;
    public static double h = 0.5; //частота
    public static double N = (b-a)/h; // Шаги
    public static double[] y2 = new double[(int) (N +2)];
    public static double[] y3 = new double[(int) (N +2)];
    public static double[] y4 = new double[(int) (N +2)];

    public static void Rungecut2(){
        y2[0] = f0;
        double x;
        for(int i=0;i<N;i++){
            x = a+(i+1)*h;
            y2[i+1] = y2[i] + h*F(x + h/2,y2[i] + h/2*F(x,y2[i]));
            System.out.println(y2[i+1]);
        }

    }
    public static void Rungecut3(){
        y3[0] = f0;
        double x;
        for(int i=0;i<N;i++){
            x = a+(i)*h;
            y3[i+1] = y3[i] + h*(K1(x,y3[i])+4*K2(x,y3[i])+K3(x,y3[i]))/6;
            System.out.println(y3[i+1]);
        }

    }
    public static void Rungecut4(){
        y4[0] = f0;
        double x;
        for(int i=0;i<N;i++){
            x = a+(i+1)*h;
            y4[i+1] = y4[i] + h/6*(K1(x,y4[i])+2*K2(x,y4[i])+2*K3(x,y4[i])+K4(x,y4[i]));
            System.out.println(y4[i+1]);
        }

    }

    public static double F(double x,double y){
        return ((Math.sin(y)/(Math.pow(x,2)+5))+x*Math.cos(x));
    }
    public static double K1(double x,double y){
        return F(x,y);
    }
    public static double K2(double x,double y){
        return F(x + h/2,y + h*K1(x,y)/2);
    }
    public static double K3(double x,double y){
        return F(x + h/2,y + h*K2(x,y)/2);
    }
    public static double K4(double x,double y){
        return F(x + h,y + h*K3(x,y));
    }

    public static void main(String[] args)
    {
        System.out.println("Метод Рунге-Кутта 2:");
	    Rungecut2();
        System.out.println("Метод Рунге-Кутта 3:");
	    Rungecut3();
        System.out.println("Метод Рунге-Кутта 4:");
	    Rungecut4();
    }
}
