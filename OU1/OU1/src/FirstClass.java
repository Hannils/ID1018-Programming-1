import java.util.*;

public class FirstClass {

    public static void main(String[] args) {

        System.out.println("Temperaturer\n");

        //inmatningsverktyg
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        //mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print("antalet veckor: ");
        int antalveckor = in.nextInt();
        System.out.print("antalet mätningar per vecka : ");
        int antalMatningarPerVecka = in.nextInt();

        //plats att lagra temperaturer
        double[][] t = new double[antalveckor + 1][antalMatningarPerVecka + 1];

        //mata in temperaturerna
        for (int vecka = 1; vecka <= antalveckor; vecka++) {
            System.out.println("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {

                t[vecka][matning] = in.nextDouble();
            }
            System.out.println();
        }

        //visa temperaturerna
        System.out.println("temperaturerna:");
        for (int vecka = 1; vecka <= antalveckor; vecka++) {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.print(t[vecka][matning] + " ");
            System.out.println();
        }

        //den minsta, den största, och medeltemperaturen - veckovis
        double[] minT = new double[antalveckor + 1];
        double[] maxT = new double[antalveckor + 1];
        double[] sumT = new double[antalveckor + 1];
        double[] medelT = new double[antalveckor + 1];


        //kod ska skrivas här
        for (int i = 1; i <= antalveckor; i++) {
            minT[i] = t[i][1];
            maxT[i] = t[i][1];
            for (int j = 1; j <= antalMatningarPerVecka; j++) {
                sumT[i] += t[i][j];
                if (minT[i] > t[i][j]) {
                    minT[i] = t[i][j];
                }
                if (maxT[i] < t[i][j]) {
                    maxT[i] = t[i][j];
                }
            }
            medelT[i] = sumT[i] / antalMatningarPerVecka;

        }
        //Utmatning
        for (int i = 1; i <= antalveckor; i++)
        {
            System.out.println("Vecka " + i + " min: " + minT[i]);
            System.out.println("Vecka " + i + " max: " + maxT[i]);
            System.out.println("Vecka " + i + " medel: " + medelT[i] + "\n");
        }

        //Den minsta, den största och medeltemperaturen för hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double medelTemp = 0;

        //Kod ska skrivas här
        for (int i = 1; i <= antalveckor; i++) {
            medelTemp += medelT[i];
            if (minTemp > minT[i]) {
                minTemp = minT[i];
            }
            if (maxTemp < maxT[i]) {
                maxTemp = maxT[i];
            }
        }
        medelTemp /= antalveckor;

        //Utmatning
        System.out.println("Största: " + maxTemp);
        System.out.println("Minsta: " + minTemp);
        System.out.println("Medel: " + medelTemp);

    }

}
