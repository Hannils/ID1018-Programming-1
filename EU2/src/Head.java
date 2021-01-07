public class Head {

    public static void main(String args[]){

        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;
        int vektor[] = (sortera(n, arr));
        for (int i = 0; i < vektor.length; i++){
            System.out.println(vektor[i]);
        }
    }

    public static int[] sortera(int n, int[] X){
        int i = 0;
        int temp = 0;
        while (i < n){
            int j = i + 1;
            while (j < n){
                if (X[j] < X[i])
                {
                    temp = X[i];
                    X[i] = X[j];
                    X[j] = temp;
                }

                j++;
            }
            i++;
        }
        return X;
    }

}
