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
        assertAll(
                () -> assertArrayEquals(expectedValue,arrayOperator.removeElement(nums,val))
        );
//        System.out.println(Arrays.toString(arrayOperator.removeElement(nums,val)));
//        System.out.println(Arrays.toString(nums));
    }
}
