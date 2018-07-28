

public class inversion_check{
    public static void main(String args[]){
        int [] A = {5, 4, 3, 2, 1};
     
        System.out.println("The number of inversions: "+mergeSort(A,0,4));   
    }

    public static int mergeSort(int []A, int p, int r){
        if(p<r){
            int q = (p+r)/2;
            int left  = mergeSort(A,p,q);
            int right = mergeSort(A,q+1,r);
            return merge(A,p,q,r) + left + right;
        }

        return 0;
    }

    public static int merge(int []A, int p, int q, int r){
        int []L = new int[q-p+1];
        int []R = new int[r-q];

        for(int i=0;i<L.length;i++)
            L[i] = A[p+i];


        for(int i=0;i<R.length;i++)
            R[i] = A[q+1+i];


        int i=0, j=0, k=0, inv=0;
        while(i<L.length && j<R.length){
            if(L[i] <= R[j]){
                A[p+k] = L[i];
                i++;
            }
            else{
                A[p+k] = R[j];
                j++;
		inv += (L.length-i);
            }
            k++;
        }

        if(i==L.length){
            while(j<R.length){
                A[p+k] = R[j];
                k++;
                j++;
            }
        }
        else{
            while(i<L.length){
                A[p+k] = L[i];
                i++;
                k++;
                //inv += R.length;
            }

        }

        return inv;
    }
}
