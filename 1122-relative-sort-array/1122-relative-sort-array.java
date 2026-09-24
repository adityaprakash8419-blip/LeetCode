//import java.util.arrays;
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k= 0;
        for(int i=0;i<arr2.length;i++){
            for(int j= 0;j<arr1.length;j++){
                if(arr1[j]==arr2[i]){
                    int temp = arr1[j];

                    arr1[j]= arr1[k];
                    arr1[k]= temp;
                    k++;
                    
                }
            }
        }
        for(int i=k;i<arr1.length;i++){
            for(int j=i+1;j<arr1.length;j++){
                if(arr1[j]<arr1[i]){
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        return arr1;
        

    }
}