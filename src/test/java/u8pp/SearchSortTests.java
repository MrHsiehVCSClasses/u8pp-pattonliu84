package u8pp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SearchSortTests {

    private int[] arrayEmpty = {};
    private int[] arraySingle = {1};
    private int[] arraySingleCopy = {1};
    private int[] arrayDoubleSorted = {10,20};
    private int[] arrayDoubleSortedCopy = {10,20};
    private int[] arrayDoubleUnsorted = {20,10};
    private int[] arrayMidsizeUnsorted = {2, 4, 1, -1, 0, 9, -80, 3};
    private int[] arrayMidsizeSorted = {-80, -1, 0, 1, 2, 3, 4, 9};;
    private int[] arrayMidsizeSortedCopy = {-80, -1, 0, 1, 2, 3, 4, 9};;
    private int[] arrayLongUnsorted = new int[100];
    private int[] arrayLongSorted = new int[100];
    private int[] arrayLongSortedCopy = new int[100];
    private int[] arrayLongReversed = new int[100];

    private ArrayList<Student> listEmpty;
    private ArrayList<Student> listSingle;
    private ArrayList<Student> listDoubleSortedDiffYear;
    private ArrayList<Student> listDoubleUnsortedDiffYear;
    private ArrayList<Student> listDoubleSortedDiffLast;
    private ArrayList<Student> listDoubleUnsortedDiffLast;
    private ArrayList<Student> listDoubleSortedDiffFirst;
    private ArrayList<Student> listDoubleUnsortedDiffFirst;
    private ArrayList<Student> listMidsizeUnsorted;
    private ArrayList<Student> listMidsizeSorted;
    private ArrayList<Student> listLongUnsorted;
    private ArrayList<Student> listLongSorted;
    private ArrayList<Student> listLongReversed;

    // this method runs once before each test.
    @BeforeEach
    public void beforeEach() {
        
        Student s0 = new Student(12, "Logan", "Byeon");
        Student s1 = new Student(12, "Carter", "Hastings");
        Student s2 = new Student(12, "Arnold", "Kim");
        Student s3 = new Student(12, "Rebecca", "Kim");
        Student s4 = new Student(12, "Sarah", "Kim");
        Student s5 = new Student(12, "Chaehyun", "Lim");
        Student s6 = new Student(12, "Junjian", "Liu");
        Student s7 = new Student(12, "Kenneth", "Min");
        Student s8 = new Student(12, "Rebecca", "Park");
        Student s9 = new Student(12, "Sarah", "Park");
        Student s10 = new Student(12, "Owen", "Swanson");
        Student s11 = new Student(11, "Andrew", "Kim");
        Student s12 = new Student(11, "Kaiden", "Ko");
        Student s13 = new Student(11, "Rhiana", "McKee");
        Student s14 = new Student(10, "Bob", "McBobby");
        Student s15 = new Student(9, "Bob", "McBobby");

        listEmpty = new ArrayList<Student>();
        listSingle = new ArrayList<Student>();
        listSingle.add(s1);

        listDoubleSortedDiffYear = new ArrayList<Student>(List.of(s14, s15));
        listDoubleUnsortedDiffYear = new ArrayList<Student>(List.of(s15, s14));

        listDoubleSortedDiffLast = new ArrayList<Student>(List.of(s3, s8));
        listDoubleUnsortedDiffLast = new ArrayList<Student>(List.of(s8, s3));

        listDoubleSortedDiffFirst = new ArrayList<Student>(List.of(s3, s4));
        listDoubleUnsortedDiffFirst = new ArrayList<Student>(List.of(s4, s3));

        listMidsizeUnsorted = new ArrayList<Student>(List.of(
            s3,s13,s6,s5,s0,s1,s11,s7,s15,s12,s2,s9,s8,s10,s4,s14
        ));

        listMidsizeSorted = new ArrayList<Student>(List.of(
            s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15
        ));
        
        listLongUnsorted = new ArrayList<Student>();
        for(int i = 0; i < 100; i ++) {
            listLongUnsorted.add(Student.generateRandomStudent());
        }

        listLongSorted = new ArrayList<Student>(listLongUnsorted);
        listLongSorted.sort(new StudentSorter());

        listLongReversed = new ArrayList<Student>(listLongSorted);
        Collections.reverse(listLongReversed);

        for(int i = 0; i < arrayLongUnsorted.length; i++) {
            int x  = (int)(Math.random() * 1800) - 900;
            arrayLongUnsorted[i] = x; 
            arrayLongSorted[i] = x;
            arrayLongSortedCopy[i] = x;
            arrayLongReversed[i] = x;
        }

        Arrays.sort(arrayLongSorted);
        Arrays.sort(arrayLongSortedCopy);
        arrayLongReversed = IntStream.rangeClosed(1, arrayLongSorted.length).map(i -> arrayLongSorted[arrayLongSorted.length-i]).toArray();
    } 

    /*
     * Selection Sort Tests - int array
     */
    @Test
    public void selectionSort_array_empty_noError() {
        SearchSort.selectionSort(arrayEmpty);
    }
    
    @Test
    public void selectionSort_array_1elem_noChange() {
        SearchSort.selectionSort(arraySingle);
        assertArrayEquals(arraySingleCopy, arraySingle);
    }

    @Test
    public void selectionSort_array_2elemSorted_noChange() {
        SearchSort.selectionSort(arrayDoubleSorted);
        assertArrayEquals(arrayDoubleSortedCopy, arrayDoubleSorted);
    }

    @Test
    public void selectionSort_array_2elemUnsorted_orderCorrect() {
        SearchSort.selectionSort(arrayDoubleUnsorted);
        assertArrayEquals(arrayDoubleSorted, arrayDoubleUnsorted);
    }

    @Test
    public void selectionSort_array_MidsizeSorted_noChange() {
        SearchSort.selectionSort(arrayMidsizeSorted);
        assertArrayEquals(arrayMidsizeSortedCopy, arrayMidsizeSorted);
    }

    @Test
    public void selectionSort_array_MidsizeUnsorted_orderCorrect() {
        SearchSort.selectionSort(arrayMidsizeUnsorted);
        assertArrayEquals(arrayMidsizeSorted, arrayMidsizeUnsorted);
    }

    @Test
    public void selectionSort_array_LongUnsorted_orderCorrect() {
        SearchSort.selectionSort(arrayLongUnsorted);
        assertArrayEquals(arrayLongSorted, arrayLongUnsorted);
    }

    @Test
    public void selectionSort_array_LongSorted_noChange() {
        SearchSort.selectionSort(arrayLongSorted);
        assertArrayEquals(arrayLongSorted, arrayLongSorted);
    }

    @Test
    public void selectionSort_array_LongReversed_orderCorrect() {
        SearchSort.selectionSort(arrayLongReversed);
        assertArrayEquals(arrayLongSorted, arrayLongReversed);
    }

    @Test
    public void selectionSort_list_doesNotModifyArgument() {
        ArrayList<Student> listLongUnsortedCopy = new ArrayList<Student>(listLongUnsorted);
        SearchSort.selectionSort(listLongUnsorted);
        assertEquals(listLongUnsortedCopy, listLongUnsorted);
    }

    /*
     * Selection Sort Tests - ArrayList<Student>
     */
    @Test
    public void selectionSort_list_empty_noChange() {
        ArrayList<Student> output = SearchSort.selectionSort(listEmpty);
        assertEquals(new ArrayList<Student>(), output);
    }
    
    @Test
    public void selectionSort_list_1elem_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listSingle);
        ArrayList<Student> output = SearchSort.selectionSort(listSingle);
        assertEquals(copy, output);
    }

    @Test
    public void selectionSort_list_2elemSortedDiffYear_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffYear);
        ArrayList<Student> output = SearchSort.selectionSort(listDoubleSortedDiffYear);
        assertEquals(copy, output);
    }

    @Test
    public void selectionSort_list_2elemUnsortedDiffYear_orderCorrect() {
        ArrayList<Student> output = SearchSort.selectionSort(listDoubleUnsortedDiffYear);
        assertEquals(listDoubleSortedDiffYear, output);
    }

    @Test
    public void selectionSort_list_2elemSortedDiffLast_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffLast);
        ArrayList<Student> output = SearchSort.selectionSort(listDoubleSortedDiffLast);
        assertEquals(copy, output);
    }

    @Test
    public void selectionSort_list_2elemUnsortedDiffLast_orderCorrect() {
        ArrayList<Student> output = SearchSort.selectionSort(listDoubleUnsortedDiffLast);
        assertEquals(listDoubleSortedDiffLast, output);
    }

    @Test
    public void selectionSort_list_2elemSortedDiffFirst_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffFirst);
        ArrayList<Student> output = SearchSort.selectionSort(listDoubleSortedDiffFirst);
        assertEquals(copy, output);
    }

    @Test
    public void selectionSort_list_2elemUnsortedDiffFirst_orderCorrect() {
        ArrayList<Student> output = SearchSort.selectionSort(listDoubleUnsortedDiffFirst);
        assertEquals(listDoubleSortedDiffFirst, output);
    }

    @Test
    public void selectionSort_list_MidsizeSorted_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listMidsizeSorted);
        ArrayList<Student> output = SearchSort.selectionSort(listMidsizeSorted);
        assertEquals(copy, output);
    }

    @Test
    public void selectionSort_list_MidsizeUnsorted_orderCorrect() {
        ArrayList<Student> output = SearchSort.selectionSort(listMidsizeUnsorted);
        assertEquals(listMidsizeSorted, output);
    }

    @Test
    public void selectionSort_list_LongSorted_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listLongSorted);
        ArrayList<Student> output = SearchSort.selectionSort(listLongSorted);
        assertEquals(copy, output);
    }

    @Test
    public void selectionSort_list_LongUnsorted_orderCorrect() {
        ArrayList<Student> output = SearchSort.selectionSort(listLongUnsorted);
        assertEquals(listLongSorted, output);
    }

    @Test
    public void selectionSort_list_LongReversed_orderCorrect() {
        ArrayList<Student> output = SearchSort.selectionSort(listLongReversed);
        assertEquals(listLongSorted, output);
    }

    /*
     * Insertion Sort Tests - int array
     */
    @Test
    public void insertionSort_array_empty_noError() {
        SearchSort.insertionSort(arrayEmpty);
    }
    
    @Test
    public void insertionSort_array_1elem_noChange() {
        SearchSort.insertionSort(arraySingle);
        assertArrayEquals(arraySingleCopy, arraySingle);
    }

    @Test
    public void insertionSort_array_2elemSorted_noChange() {
        SearchSort.insertionSort(arrayDoubleSorted);
        assertArrayEquals(arrayDoubleSortedCopy, arrayDoubleSorted);
    }

    @Test
    public void insertionSort_array_2elemUnsorted_orderCorrect() {
        SearchSort.insertionSort(arrayDoubleUnsorted);
        assertArrayEquals(arrayDoubleSorted, arrayDoubleUnsorted);
    }

    @Test
    public void insertionSort_array_MidsizeSorted_noChange() {
        SearchSort.insertionSort(arrayMidsizeSorted);
        assertArrayEquals(arrayMidsizeSortedCopy, arrayMidsizeSorted);
    }

    @Test
    public void insertionSort_array_MidsizeUnsorted_orderCorrect() {
        SearchSort.insertionSort(arrayMidsizeUnsorted);
        assertArrayEquals(arrayMidsizeSorted, arrayMidsizeUnsorted);
    }

    @Test
    public void insertionSort_array_LongUnsorted_orderCorrect() {
        SearchSort.insertionSort(arrayLongUnsorted);
        assertArrayEquals(arrayLongSorted, arrayLongUnsorted);
    }

    @Test
    public void insertionSort_array_LongSorted_noChange() {
        SearchSort.insertionSort(arrayLongSorted);
        assertArrayEquals(arrayLongSorted, arrayLongSorted);
    }

    @Test
    public void insertionSort_array_LongReversed_orderCorrect() {
        SearchSort.insertionSort(arrayLongReversed);
        assertArrayEquals(arrayLongSorted, arrayLongReversed);
    }

    @Test
    public void insertionSort_list_doesNotModifyArgument() {
        ArrayList<Student> listLongUnsortedCopy = new ArrayList<Student>(listLongUnsorted);
        SearchSort.insertionSort(listLongUnsorted);
        assertEquals(listLongUnsortedCopy, listLongUnsorted);
    }

    /*
     * Insertion Sort Tests - ArrayList<Student>
     */
    @Test
    public void insertionSort_list_empty_noChange() {
        ArrayList<Student> output = SearchSort.insertionSort(listEmpty);
        assertEquals(new ArrayList<Student>(), output);
    }
    
    @Test
    public void insertionSort_list_1elem_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listSingle);
        ArrayList<Student> output = SearchSort.insertionSort(listSingle);
        assertEquals(copy, output);
    }

    @Test
    public void insertionSort_list_2elemSortedDiffYear_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffYear);
        ArrayList<Student> output = SearchSort.insertionSort(listDoubleSortedDiffYear);
        assertEquals(copy, output);
    }

    @Test
    public void insertionSort_list_2elemUnsortedDiffYear_orderCorrect() {
        ArrayList<Student> output = SearchSort.insertionSort(listDoubleUnsortedDiffYear);
        assertEquals(listDoubleSortedDiffYear, output);
    }

    @Test
    public void insertionSort_list_2elemSortedDiffLast_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffLast);
        ArrayList<Student> output = SearchSort.insertionSort(listDoubleSortedDiffLast);
        assertEquals(copy, output);
    }

    @Test
    public void insertionSort_list_2elemUnsortedDiffLast_orderCorrect() {
        ArrayList<Student> output = SearchSort.insertionSort(listDoubleUnsortedDiffLast);
        assertEquals(listDoubleSortedDiffLast, output);
    }

    @Test
    public void insertionSort_list_2elemSortedDiffFirst_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffFirst);
        ArrayList<Student> output = SearchSort.insertionSort(listDoubleSortedDiffFirst);
        assertEquals(copy, output);
    }

    @Test
    public void insertionSort_list_2elemUnsortedDiffFirst_orderCorrect() {
        ArrayList<Student> output = SearchSort.insertionSort(listDoubleUnsortedDiffFirst);
        assertEquals(listDoubleSortedDiffFirst, output);
    }

    @Test
    public void insertionSort_list_MidsizeSorted_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listMidsizeSorted);
        ArrayList<Student> output = SearchSort.insertionSort(listMidsizeSorted);
        assertEquals(copy, output);
    }

    @Test
    public void insertionSort_list_MidsizeUnsorted_orderCorrect() {
        ArrayList<Student> output = SearchSort.insertionSort(listMidsizeUnsorted);
        assertEquals(listMidsizeSorted, output);
    }

    @Test
    public void insertionSort_list_LongSorted_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listLongSorted);
        ArrayList<Student> output = SearchSort.insertionSort(listLongSorted);
        assertEquals(copy, output);
    }

    @Test
    public void insertionSort_list_LongUnsorted_orderCorrect() {
        ArrayList<Student> output = SearchSort.insertionSort(listLongUnsorted);
        assertEquals(listLongSorted, output);
    }

    @Test
    public void insertionSort_list_LongReversed_orderCorrect() {
        ArrayList<Student> output = SearchSort.insertionSort(listLongReversed);
        assertEquals(listLongSorted, output);
    }

    /*
     * Merge Sort Tests - int array
     */
    @Test
    public void mergeSort_array_empty_noError() {
        SearchSort.mergeSort(arrayEmpty);
    }
    
    @Test
    public void mergeSort_array_1elem_noChange() {
        SearchSort.mergeSort(arraySingle);
        assertArrayEquals(arraySingleCopy, arraySingle);
    }

    @Test
    public void mergeSort_array_2elemSorted_noChange() {
        SearchSort.mergeSort(arrayDoubleSorted);
        assertArrayEquals(arrayDoubleSortedCopy, arrayDoubleSorted);
    }

    @Test
    public void mergeSort_array_2elemUnsorted_orderCorrect() {
        SearchSort.mergeSort(arrayDoubleUnsorted);
        assertArrayEquals(arrayDoubleSorted, arrayDoubleUnsorted);
    }

    @Test
    public void mergeSort_array_MidsizeSorted_noChange() {
        SearchSort.mergeSort(arrayMidsizeSorted);
        assertArrayEquals(arrayMidsizeSortedCopy, arrayMidsizeSorted);
    }

    @Test
    public void mergeSort_array_MidsizeUnsorted_orderCorrect() {
        SearchSort.mergeSort(arrayMidsizeUnsorted);
        assertArrayEquals(arrayMidsizeSorted, arrayMidsizeUnsorted);
    }

    @Test
    public void mergeSort_array_LongUnsorted_orderCorrect() {
        SearchSort.mergeSort(arrayLongUnsorted);
        assertArrayEquals(arrayLongSorted, arrayLongUnsorted);
    }

    @Test
    public void mergeSort_array_LongSorted_noChange() {
        SearchSort.mergeSort(arrayLongSorted);
        assertArrayEquals(arrayLongSorted, arrayLongSorted);
    }

    @Test
    public void mergeSort_array_LongReversed_orderCorrect() {
        SearchSort.mergeSort(arrayLongReversed);
        assertArrayEquals(arrayLongSorted, arrayLongReversed);
    }

    @Test
    public void mergeSort_list_doesNotModifyArgument() {
        ArrayList<Student> listLongUnsortedCopy = new ArrayList<Student>(listLongUnsorted);
        SearchSort.mergeSort(listLongUnsorted);
        assertEquals(listLongUnsortedCopy, listLongUnsorted);
    }

    /*
     * Merge Sort Tests - ArrayList<Student>
     */
    @Test
    public void mergeSort_list_empty_noChange() {
        ArrayList<Student> output = SearchSort.mergeSort(listEmpty);
        assertEquals(new ArrayList<Student>(), output);
    }
    
    @Test
    public void mergeSort_list_1elem_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listSingle);
        ArrayList<Student> output = SearchSort.mergeSort(listSingle);
        assertEquals(copy, output);
    }

    @Test
    public void mergeSort_list_2elemSortedDiffYear_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffYear);
        ArrayList<Student> output = SearchSort.mergeSort(listDoubleSortedDiffYear);
        assertEquals(copy, output);
    }

    @Test
    public void mergeSort_list_2elemUnsortedDiffYear_orderCorrect() {
        ArrayList<Student> output = SearchSort.mergeSort(listDoubleUnsortedDiffYear);
        assertEquals(listDoubleSortedDiffYear, output);
    }

    @Test
    public void mergeSort_list_2elemSortedDiffLast_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffLast);
        ArrayList<Student> output = SearchSort.mergeSort(listDoubleSortedDiffLast);
        assertEquals(copy, output);
    }

    @Test
    public void mergeSort_list_2elemUnsortedDiffLast_orderCorrect() {
        ArrayList<Student> output = SearchSort.mergeSort(listDoubleUnsortedDiffLast);
        assertEquals(listDoubleSortedDiffLast, output);
    }

    @Test
    public void mergeSort_list_2elemSortedDiffFirst_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listDoubleSortedDiffFirst);
        ArrayList<Student> output = SearchSort.mergeSort(listDoubleSortedDiffFirst);
        assertEquals(copy, output);
    }

    @Test
    public void mergeSort_list_2elemUnsortedDiffFirst_orderCorrect() {
        ArrayList<Student> output = SearchSort.mergeSort(listDoubleUnsortedDiffFirst);
        assertEquals(listDoubleSortedDiffFirst, output);
    }

    @Test
    public void mergeSort_list_MidsizeSorted_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listMidsizeSorted);
        ArrayList<Student> output = SearchSort.mergeSort(listMidsizeSorted);
        assertEquals(copy, output);
    }

    @Test
    public void mergeSort_list_MidsizeUnsorted_orderCorrect() {
        ArrayList<Student> output = SearchSort.mergeSort(listMidsizeUnsorted);
        assertEquals(listMidsizeSorted, output);
    }

    @Test
    public void mergeSort_list_LongSorted_noChange() {
        ArrayList<Student> copy = new ArrayList<Student>(listLongSorted);
        ArrayList<Student> output = SearchSort.mergeSort(listLongSorted);
        assertEquals(copy, output);
    }

    @Test
    public void mergeSort_list_LongUnsorted_orderCorrect() {
        ArrayList<Student> output = SearchSort.mergeSort(listLongUnsorted);
        assertEquals(listLongSorted, output);
    }

    @Test
    public void mergeSort_list_LongReversed_orderCorrect() {
        ArrayList<Student> output = SearchSort.mergeSort(listLongReversed);
        assertEquals(listLongSorted, output);
    }
}

    

