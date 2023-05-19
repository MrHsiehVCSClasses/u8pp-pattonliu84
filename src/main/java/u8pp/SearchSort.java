package u8pp;

import java.util.ArrayList;

public class SearchSort {
 // Sorts an array of integers using selection sort
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // Sorts an array of integers using insertion sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    // Sorts an array of integers using merge sort
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = array[j];
            j++;
            k++;
        }
        for (k = 0; k < temp.length; k++) {
            array[start + k] = temp[k];
        }
    }
//Does the same thing for students
    public static ArrayList<Student> mergeSort(ArrayList<Student> students) {
        if (students.size() < 2) {
            return students;
        }
        int mid = students.size() / 2;
        ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(students.subList(mid, students.size()));
        left = mergeSort(left);
        right = mergeSort(right);
        ArrayList<Student> merged = merge(left, right);
        return merged;
    }
    
    private static ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right) {
        ArrayList<Student> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (new StudentSorter().compare(left.get(i), right.get(j)) <= 0) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }

    // Sorts an ArrayList of Student objects using selection sort
    public static ArrayList<Student> selectionSort(ArrayList<Student> list) {
        ArrayList<Student> done = new ArrayList<Student>(list);
        for (int i = 0; i < done.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < done.size(); j++) {
                if (compare(done.get(j), done.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = done.get(i);
                done.set(i, done.get(minIndex));
                done.set(minIndex, temp);
            }
        }
        return done;
    }

    // Sorts an ArrayList of Student objects using insertion sort
    public static ArrayList<Student> insertionSort(ArrayList<Student> list) {
        ArrayList<Student> done = new ArrayList<Student>(list);
        for (int i = 1; i < done.size(); i++) {
            Student current = done.get(i);
            int j = i - 1;
            while (j >= 0 && compare(done.get(j), current) > 0) {
                done.set(j + 1, done.get(j));
                j--;
            }
            done.set(j + 1, current);
        }
        return done;
    }

 public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
 
    public static int compare(Student o1, Student o2) {
        if (o1.getYear() != o2.getYear()) {
            return o2.getYear() - o1.getYear();
        }
        if (!o1.getLastName().equals(o2.getLastName())) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
