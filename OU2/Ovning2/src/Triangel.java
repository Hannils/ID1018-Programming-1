import java.util.*;

public class Triangel {

    public static void main(String[] args) {
        Funktioner t = new Funktioner();
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);


        double[] sides = new double[3];
        for (int i = 0; i < 3; i++){
            System.out.print("Sida " + (i+1) + ": ");
            sides[i] = in.nextDouble();
        }
        System.out.println("Arean är: " + t.returnarea(sides[0], sides[1], sides[2]));
        System.out.println(t.entriangelochdesscirklar(sides[0], sides[1], sides[2]));
    }
}
