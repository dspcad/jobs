public class ch1_7{
    public static void main(String args[]){
        int N = Integer.valueOf(args[0]);

        int [][] A = new int[N][N];

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                A[i][j] = i*N+j;


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.printf("%2d ", A[i][j]);

            System.out.println("");
        }


        int [][] B = naiveReplacement(A, N);
        
        System.out.println("");
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.printf("%2d ", B[i][j]);

            System.out.println("");
        }

 
        int radius;
        if(N%2 == 1)
            radius = (N+1)/2;
        else
            radius = N/2;


        for(int i=0;i<radius;i++)
            inPlaceReplacement(A, N-2*i, i);

        System.out.println("");
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.printf("%2d ", A[i][j]);

            System.out.println("");
        }


    }

    private static int [][] naiveReplacement(int [][] A, int N){
        int [][] B = new int[N][N];
        int row, col;


        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
                row = j;
                col = N-i-1;
                B[row][col] = A[i][j];
            }

        return B;
    }

    private static void inPlaceReplacement(int [][] A, int n, int origin){
        if(n != 1){

            for(int i=0;i<n-1;i++){
                int tmp = A[origin][origin+i];

                A[origin][origin+i] = A[origin+n-1-i][origin];
                A[origin+n-1-i][origin] = A[origin+n-1][origin+n-1-i];
                A[origin+n-1][origin+n-1-i] = A[origin+i][origin+n-1];
                A[origin+i][origin+n-1] = tmp;
            }
        }
    }
}
