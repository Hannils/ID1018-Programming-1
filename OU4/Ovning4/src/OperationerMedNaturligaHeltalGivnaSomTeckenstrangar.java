import java.util.*;
import static java.lang.System.out;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {

    public static void main(String[] args)
    {
        out.println("OPERATIONER MED NATURLIGA HELTAL GIVA SOM TECKENSTRANGAR\n");

        //mata in två naturliga heltal
        Scanner in = new Scanner(System.in);
        out.println("Två naturliga heltal: ");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println();

        //addera heltalen och visa summan
        String summa = addera(tal1, tal2);
        visa(tal1, tal2, summa, '+');

        //subtrahera heltalen och visa resultatet
        String differens = subtrahera(tal1, tal2);
        visa(tal1, tal2, differens, '-');
    }

    /*Addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    summa som en teckensträng*/
    public static String addera(String tal1, String tal2)
    {
        int carry = 0;
        int m = tal1.length();
        int n = tal2.length();
        int len;
        if(m < n) { len = n; }
        else { len = m; }
        char[] res = new char[len + 1]; // length is maxLen + 1 incase of carry in adding most significant digits
        for(int i = 0; i <= len ; i++) {

            int a;
            if (i < m) { a = (tal1.charAt(m - i - 1) - '0'); }
            else { a = 0; }

            int b;
            if (i < n){ b = (tal2.charAt(n-i-1) - '0'); }
            else { b = 0; }

            res[len - i] = (char)((a + b + carry) % 10 + '0');
            carry = (a + b + carry) / 10;
        }
        return res[0] == '0' ? new String(res, 1, len) : new String(res, 0, len + 1);
    }

    /*Subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    differens som en teckensträng
    Det första heltalet är inte mindre än det andra heltalet*/
    public static String subtrahera(String tal1, String tal2)
    {
        if (check(tal1, tal2)) {
            String t = tal1;
            tal1 = tal2;
            tal2 = t;
        }

        String str = "";
        int n1 = tal1.length();
        int n2 = tal2.length();

        tal1 = new StringBuilder(tal1).reverse().toString();
        tal2 = new StringBuilder(tal2).reverse().toString();
        int carry = 0;


        for (int i = 0; i < n2; i++) {
            int sub = ((int)(tal1.charAt(i) - '0')
                    - (int)(tal2.charAt(i) - '0') - carry);


            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            }
            else
                carry = 0;
            str += (char)(sub + '0');
        }

        // subtract remaining digits of larger number
        for (int i = n2; i < n1; i++) {
            int sub = ((int)(tal1.charAt(i) - '0') - carry);

            if (sub < 0) { sub = sub + 10; carry = 1; }
            else carry = 0;
            str += (char)(sub);
        }
        // reverse resultant string
        return new StringBuilder(str).reverse().toString();
    }

    static boolean check(String tal1, String tal2)
    {
        int m = tal1.length();
        int n = tal2. length();

        if (m < n){ return true; }
        if (m > n) { return false; }

        for (int i = 0; i < m; i++)
            if(tal1.charAt(i) < tal2.charAt(i))
                return true;
            else if (tal1.charAt(i) > tal2.charAt(i))
                return false;

            return false;
    }
    /*visa visar två naturliga heltal, och resultatet av en aritmetisk operation
    utförd i samband med heltalen*/
    public static void visa(String tal1, String tal2, String resultat, char operator)
    {
        //Sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length();
        int len2 = tal2.length();
        int len = resultat.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        tal1 = sattLen(tal1, maxLen - len1);
        tal2 = sattLen(tal2, maxLen - len2);
        resultat = sattLen(resultat, maxLen - len);

        //Visa heltalen och resultatet
        out.println(" " + tal1);
        out.println("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print("-");
            out.println();
            out.println(" " + resultat + "\n");
    }

    //sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen(String s, int antal)
    {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < antal; i++)
            sb.insert(0, "");

        return sb.toString();

    }
}
