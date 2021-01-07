import java.sql.SQLOutput;

public class Head {
    public static void main (String[] args){
        int[] element = new int[]{10, 97, 13, 37, 23, 68, 34, 26, 52, 6, 77, 47, 90, 49, 2, 83, 72, 32};
        System.out.println(min(element));
        System.out.println(minsta(element));
    }

    //min returnerar det minsta elementet i en sekventiell samling heltal.
    //Om samlingen är tom, kastas ett undantag av typen Illegalargumentexception
    public static int min (int[] element) throws IllegalArgumentException{
        if(element.length == 0)
            throw new IllegalArgumentException("Tom samling");

        //Hör ihop med spårutskriften 2:
        int antalVarv = 1;

        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antalOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antalOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];
        int i = 0;
        int j = 0;
        while (antaletTankbaraElement > 1) {
            //Skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;
            while (j < antaletPar) {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
                i += 2;
            }
            if (antalOparadeElement == 1){
                delsekvens[j] = sekvens[i];
                if (delsekvens[0] > sekvens[i])
                    delsekvens[0] = sekvens[i];
            }


            //utgå nu från delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2;
            antalOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antalOparadeElement;

            //Spårutskrift 1 - för att följa sekvensen
            //System.out.println("Tänkbara: " + antaletTankbaraElement);
            System.out.println(java.util.Arrays.toString(sekvens));

            //Spårutskrift 2 - för att avsluta loopen i förväg
            //(för att kunna se vad som händer i början)
            if (antalVarv++ == 10)
            System.exit(0);
        }
        //sekvens[0] är det enda återstående tänkbara elementet
        // - det är det minsta elementet
        return sekvens[0];

        }
    public static int minsta (int[] element){
        int minsta = element[0];

        for (int i = 0; i < element.length; i++){
            minsta = (element[i] < minsta) ? element[i] : minsta;
        }

        return minsta;
    }
}
