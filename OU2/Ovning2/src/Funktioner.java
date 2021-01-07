
import java.lang.Math;

public class Funktioner {

    public double returnarea(double sida0, double sida1, double sida2) {
        return area(sida0, sida1, sida2);
    }

    public double entriangelochdesscirklar(double sida0, double sida1, double sida2) {
        System.out.println("Outer: " + getRadiusforOuterCircle(sida0, sida1, sida2));
        System.out.println("Inner: "+ getRadiusforInnerCircle(sida0, sida1, sida2));
        return getRadiusforInnerCircle(sida0, sida1, sida2);
    }

    public double getRadiusforInnerCircle(double sida0, double sida1, double sida2) {
        double p = omkrets(sida0, sida1, sida2) / 2;
        return Math.sqrt(p * (p - sida0) * (p - sida1) * (p - sida2)) / p;
    }

    public double getRadiusforOuterCircle(double sida0, double sida1, double sida2) {
        return (sida0 * sida1 * sida2) / (4 * area(sida0, sida1, sida2));
    }

    public double area(double sida0, double sida1, double sida2) {
        double p = omkrets(sida0, sida1, sida2) / 2;
        return Math.sqrt(p * (p - sida0) * (p - sida1) * (p - sida2));
    }

    public double omkrets(double sida0, double sida1, double sida2) {
        return sida0 + sida1 + sida2;
    }

}