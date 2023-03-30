# u8pp

You will complete a few search & sort functions

## Functions

### Search

We are skipping this because we did binary search last unit :)

### Sort

You will implement insertion sort, selection sort, and merge sort.
You will implement 2 versions of each sort function - one for arrays and one for objects (`ArrayList`s).

You can infer the headers of each method from the tests.

For the one that takes in an array, the methods should be take in an array of `int`s and modify the array to be ordered from smallest to biggest. These methods should not return anything.

For the methods that take in an `ArrayList`, they will be lists of `Student` objects. These functions will return a new `ArrayList` of `Student` objects ordered by year, from high to low. ordered from largest year to smallest year. Ties are broken by last name in lexicographical order. Further ties are broken by first name in lexicographical order. Finally, ties are broken by lexicographical order. These functions should not modify the argument.  

**Hint**: If you find yourself doing the same complex comparison many times in different functions, maybe you should extract it into a `private` helper method.

**Hint**: The order of the tests will guide you from simpler to more complex versions of each method. It is recommended that you work in a way that targets one new test at a time. It's also more fun to code this way :)

**Hint**: It is *very* easy to find code to copy paste from the internet for this assignment. If you do so, you will have a much weaker knowledge of these sorting algorithms. You ***will*** get wrecked on the AP Exam & tests. As always, cheating is not recommended, and will be heavily punished.

## FAQs

**Q**: Why 2 versions of each sort?
**A**: First, To build additional familiarity, especially with insertion/selection sort. These are guaranteed to have a few questions about them on the AP Test. Second, to highlight the differences between arrays and `ArrayList`s.

**Q**: If the tests are same for all the different sorts, can't I just copy paste my code between them?
**A**: We will check that each of your methods implement the type of sort required.

## Extra Credit: Other sorts

Implement two versions (`int` array, `ArrayList` of `Student`s) of any other sorting algorithm.

To test them, copy paste the tests from any of the previous sorts, and change the names of the test & the names of the function that the tests run. (If you do a silly sort like Bogosort or Stooge sort, make sure to comment out the long tests, or else your computer will be stuck forever).

Here is an ASMR video with many sorting algorithms: <https://www.youtube.com/watch?v=vr5dCRHAgb0&fbclid=IwAR1RzGt65T8hUPaggYXgla6MuyXxB-yJaiCjGU2RH2obBYBeD6mD1nXboKY>

## Grading Breakdown

* Formatting/Indentation: 3 points
* All Code is DRY: 3 points
* All Code Properly JavaDoc'ed: 3 points
* no public methods/attributes besides the ones specified: 3 point
* Passes All Test Cases: 18 points ( ~1 point per 4 tests passed)
  
Total: 30 points
