import java.util.*;

public class BestamDenKortasteVagen {

    public static void main(String[] args){
        DenKortasteVagen fadil = new DenKortasteVagen();
        int m;
        int n;

        Scanner in = new Scanner(System.in);
        System.out.print("Stationer för Z2: ");
        m = in.nextInt();
        System.out.print("Stationer för Z3: ");
        n = in.nextInt();

        double[] a = new double[m];
        double[][] b = new double[m][n];
        double[] c = new double[n];

        for (int i = 0; i<m; i++){
            System.out.print("Längd mellan X och U" + (i+1) + " ");
            a[i] = in.nextDouble();
        }

        for (int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                System.out.print("Längder från U" + (i+1) + " " );
                b[i][j] = in.nextDouble();
            }
        }

        for(int j=0; j<n; j++){
            System.out.print("Längder från V" + (j+1) + " ");
            c[j] = in.nextDouble();
        }
        System.out.println(fadil.langd(a, b, c));
        int[] corrindex = fadil.mellanstationer(a,b,c);
        System.out.println("[" + corrindex[0] +
                "] -> [" +
                corrindex[0]+ "]" +
                "[" + corrindex[1] +
                "] -> [" +
                corrindex[1] + "]");


    }
}
