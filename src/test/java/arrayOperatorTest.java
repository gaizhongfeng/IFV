import com.IFV.array.arrayOperator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class arrayOperatorTest {

    //arrayOperator.mergeOrderedArrays
    @Test
    void mergeOrderedArraysTest(){

       int[] nums1 = new int[]{ 1,2,3,0,0,0};
       int[] nums2 = new int[]{2,5,6};
       int[] expectedValue = new int[]{1, 2, 2, 3, 5, 6 };

       int m = 3,  n = 3;
        arrayOperator.mergeOrderedArrays(nums1, m, nums2, n);
        assertAll(
                () -> assertArrayEquals(nums1,expectedValue)
        );
//        System.out.println(Arrays.toString(nums1));
    }

    //arrayOperator.removeElement
    @Test
    void removeElementTest(){
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        int[] expectedValue = new int[]{2,2};
        int resultLength = arrayOperator.removeElement(nums , val);

        assertAll(
                () -> assertArrayEquals(expectedValue,Arrays.copyOfRange(nums, 0, resultLength))
        );
//        System.out.println(Arrays.toString(arrayOperator.removeElement(nums,val)));
    }

    //arrayOperator.removeDuplicates
    @Test
    void removeDuplicatesTest(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] expectedValue = new int[]{0, 1, 2, 3, 4};
        int resultLength = arrayOperator.removeDuplicates(nums);

        assertAll(
                () -> assertArrayEquals(expectedValue,Arrays.copyOfRange(nums, 0, resultLength))
        );

    }

    @Test
    void removeDuplicatesTestII(){
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] expectedValue = new int[]{1,1,2,2,3};
        int resultLength = arrayOperator.removeDuplicatesII(nums);

//        System.out.println(resultLength);
//        Arrays.stream(nums).forEach(System.out::println);
        assertAll(
                () -> assertArrayEquals(expectedValue,Arrays.copyOfRange(nums, 0, resultLength))
        );

    }
}
