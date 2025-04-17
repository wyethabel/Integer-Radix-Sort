/* Main runner class used by my radix sort class to test
    its functionality with two test arrays.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] requiredTestArray = {783, 99, 472, 182, 264, 543,
                356, 295, 692, 491, 94};
        int[] personalTestArray = {58923, 8, 963, 81, 5000001, 473};

        System.out.println(Arrays.toString(requiredTestArray));
        IntegerRadixSort.radixSort(requiredTestArray);
        System.out.println(Arrays.toString(requiredTestArray));
        System.out.println("-----------------------");
        System.out.println(Arrays.toString(personalTestArray));
        IntegerRadixSort.radixSort(personalTestArray);
        System.out.println(Arrays.toString(personalTestArray));
    }
}