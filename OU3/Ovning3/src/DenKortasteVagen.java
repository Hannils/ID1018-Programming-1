public class DenKortasteVagen {

    /*mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
    vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
    av den andra mellanstationen finns på index 2 i vektorn.*/

    public int[] mellanstationer(double[] a, double[][] b, double[] c) {
        int[] corrindex = index(a, b, c);
        return corrindex;
    }
    public int[] index(double[] a, double[][] b, double[] c) {
        double kortaste = algoritm(a, b, c);
        int[] corrindex = new int[2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < c.length; j++) {
                double sum = a[i] + b[i][j] + c[j];
                if (sum == kortaste) {
                    corrindex[0] = i;
                    corrindex[1] = j;

                }
            }
        }
        return corrindex;

    }

    //langd returnerar längden av den kortaste vägen.
    public double langd (double[] a, double[][] b, double[] c) {
    return algoritm(a, b, c);
    }

    public double algoritm(double[] a, double[][] b, double[] c){
        int m = a.length;
        int n = c.length;
        double kortaste = Double.POSITIVE_INFINITY;

        for (int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                double langd = a[i] + b[i][j] + c[j];
                if (langd < kortaste) kortaste = langd;
            }
        }
        return kortaste;
    }

}
