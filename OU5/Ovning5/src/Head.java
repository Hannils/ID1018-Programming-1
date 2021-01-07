import java.io.*;
import java.util.*;

public class Head {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out, true);

        //Testa en konstruktor och en transformator
        Punkt p1 = new Punkt("A", 3, 4);
        Punkt p2 = new Punkt("B", 5, 6);
        out.println(p1 + "  " + p2);

        //Testa inspektorer
        String n = p1.getNamn();
        int x = p1.getX();
        int y = p1.getY();
        //out.println(String.format("%s %s %s", n, x, y));
        out.println(n + " " + x + " " + y);

        //Testa en kombinator och en komparator
        double d = p1.avstand(p2);
        out.println(d);
        boolean b = p1.equals(p2);
        out.println(b);

        //Testa mutatorer
        p2.setX(1);
        p2.setY(2);
        out.println(p2);

        //Testa en konstruktor till
        Punkt p = new Punkt(p1);
        out.println(p);

        Punkt[] polylinjepunkter = new Punkt[]{new Punkt("A", 3, 4),
                                            new Punkt("B", 1, 2),
                                            new Punkt("C", 2, 3),
                                            new Punkt("D", 5, 1),};

        Polylinje poly1 = new Polylinje(polylinjepunkter);
        out.println(poly1.getBredd());
        out.println(poly1.getFarg());
        poly1.setFarg("Röd");
        poly1.setBredd(2);
        poly1.getHorn();
        out.println(poly1.langd());

        Punkt p10 = new Punkt("Q", 10, 2);
        poly1.laggTillFramfor(p10, "B");
        out.println(poly1.toString());
        poly1.taBort("Q");
        out.println(poly1.toString());
        Polylinje.PolylinjeIterator it = poly1.new PolylinjeIterator();
        it.printPunkt();


    }
}
