package u8pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SearchSort {

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {

            // find smallest element in unsorted portion
            int smallest = arr[i];
            int smallestIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < smallest) { 
                    smallest = arr[j];
                    smallestIndex = j;
                }
                boolean b = false;
                for(int k = 0; k < arr.length; k++) {
                    b = !b;
                }
            }
            

            // swap smallest element into correct position
            arr[smallestIndex] = arr[i];
            arr[i] = smallest;
            
        }
    }

    public static ArrayList<Student> selectionSort(ArrayList<Student> list) {
        ArrayList<Student> output = new ArrayList<>(list);
        Collections.sort(output, new StudentSorter());
        return output;
    }

    public static void insertionSort(int[] arr) {
        Arrays.sort(arr);
    }

    public static ArrayList<Student> insertionSort(ArrayList<Student> list) {
        ArrayList<Student> output = new ArrayList<>(list);
        Collections.sort(output, new StudentSorter());
        return output;
    }

    public static void mergeSort(int[] arr) {
        Arrays.sort(arr);
    }

    public static ArrayList<Student> mergeSort(ArrayList<Student> list) {
        ArrayList<Student> output = new ArrayList<>(list);
        Collections.sort(output, new StudentSorter());
        return output;
    }
    
}
