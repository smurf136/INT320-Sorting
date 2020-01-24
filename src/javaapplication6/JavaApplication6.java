/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import static javaapplication6.MergeSort.printArray;

/**
 *
 * @author int320
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    
    public static int N = 100_000;
    private  static Random r= new Random();
    
    public static void main(String[] args) {
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        Integer[] a3 = new Integer[N];
        initial(a1);
        
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.arraycopy(a1, 0, a3, 0, a1.length);
        
        long begin = System.currentTimeMillis();
//        
        Arrays.sort(a1);
        
        System.out.println("Duration" + (System.currentTimeMillis() -  begin) + "millisecond");
        
        
        int arr[] = new int[100_000];
        int arr1[] = new int[N];
  
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000000);
        }
        
        for(int i = 0; i < arr.length; i++){
            arr1[i] = arr[i];
        }
        
        System.out.println("Given Array"); 
        printArray(arr); 
  
        long beginarr = System.currentTimeMillis();
  
         Arrays.sort(arr);

        System.out.println("Time Arr " + (System.currentTimeMillis() - beginarr)); 
         
        
        long beginarr1 = System.currentTimeMillis();
        
        MergeSort ob = new MergeSort(); 
        ob.sort(arr1, 0, arr1.length-1); 
         
        System.out.println("\nArray Sorted array"); 
        printArray(arr); 
         
        System.out.println("\nMerge Sorted array"); 
        printArray(arr1); 
        
        System.out.println("Time arr1 " + (System.currentTimeMillis() - beginarr1));
//        System.out.println("Duration" + (System.currentTimeMillis() -  begin2) + "millisecond");
       
//        System.out.println(binarySearchItem(a1, 3000));
        
        
        
    }
    
    public static void initial(Integer[] a1){
        for (int i = 0; i < a1.length; i++) {
            a1[i] = r.nextInt(N);
        }
    }
    
    public static int binarySearchItem(Integer[] sortedArray, int value) {
        int index = -1;
        int low = 0;
        int high = sortedArray.length;
 
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < value) {
                low = mid + 1;
            } else if (sortedArray[mid] > value) {
                high = mid - 1;
            } else if (sortedArray[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }
    void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
}
