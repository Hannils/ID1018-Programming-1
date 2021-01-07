import java.sql.SQLOutput;
import java.util.*;

public class ValjPolylinje {

    public static final Random rand = new Random();
    public static final int  ANTAL_POLYLINJER = 10;
    private static Polylinje[] polylinjer;

    public static void main(String[] args){

        //Skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++)
            polylinjer[i] = slumpPolylinje();


        //Visa polylinjer
        System.out.println(toString(polylinjer)+ "\n");


        //Bestäm den koraste av de polylinjer som är gula
        Polylinje lyellow = lyellow(polylinjer);

        //Visa den valda polylinjen
        System.out.println("Den kortaste gula polylinjen är: " + lyellow);
        System.out.println("Den har längden: " + lyellow.langd());
    }

    /*SlumpPunkt returnerar en punkt med ett slumpmässitg namn, som är en stor bokstav
    i det engelska alfabetet, och slumpmässiga koordinater.*/
    public static Punkt slumpPunkt(){
        String n = "" + (char)(65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);

        return new Punkt(n, x, y);
    }

    /*slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå eller röd eller gul.
    Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn kan inte ha samma namn.*/

    public static Polylinje slumpPolylinje(){
        //Skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje();
        int antalHorn = 2 + rand.nextInt(7);
        int antalValdahorn = 0;
        boolean[] valdaNamn = new boolean[26];
        //Ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        char valdChar = 0;


        while (antalValdahorn < antalHorn){
            valdPunkt = slumpPunkt();
            valdChar = valdPunkt.getNamn().charAt(0);
            if (!valdaNamn[valdChar - 65]){
                polylinje.laggTill(valdPunkt);
                antalValdahorn += 1;
                valdaNamn[valdChar - 65 ] = true;
            }
        }
        //Sätt färg
        String farg;
        int fargint = rand.nextInt(3);
        switch (fargint){
            case 0: farg = "yellow";
            break;
            case 1: farg = "red";
            break;
            case 2: farg = "blue";
            break;
            default:farg = "";
            break;
        }
        polylinje.setFarg(farg);
        return polylinje;
    }

    public static String toString(Polylinje[] polylinjer){
        return Arrays.toString(polylinjer);

    }

    public static Polylinje[] Yellow(Polylinje[] polylinjer){
        Polylinje[] antalyellow = new Polylinje[ANTAL_POLYLINJER];
        int index = 0;
        for (int i = 0; i < ANTAL_POLYLINJER; i++){
            if (polylinjer[i].getFarg().equals("yellow") ){
                antalyellow[index] = polylinjer[i];
                index++;
            }
        }
        return antalyellow;
    }

    public static Polylinje lyellow(Polylinje[] polylinjer){
        Polylinje[] antalyellow = Yellow(polylinjer);
        if (antalyellow[0] == null){
            System.out.println("YELLOW NOT FOUND");
            return null;
        }
        double langd = antalyellow[0].langd();
        int index = 0;
        for (int i = 0; i < antalyellow.length; i++){
            if (antalyellow[i] == null){
                return antalyellow[index];
            }
            if (langd > antalyellow[i].langd()){
               langd = antalyellow[i].langd();
               index = i;
            }
        }
        return antalyellow[index];
    }
}
