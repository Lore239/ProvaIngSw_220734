package org.example;

import org.joda.time.DateTime;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FunnyAlgorithmsTest {
    private static FunnyAlgorithms fat;
    private static final String pattern = "dd/MM/yyyy HH:mm:ss.SSS";

    @Before
    public void prepareTest(){
        fat = new FunnyAlgorithms();
    }

    @Test
    public void binarySearchTestArray() {
        int[] nums = new int[]{1,2,3,4};
        int t = fat.binarySearch(nums, 3);
        assertEquals(2, t);
    }


    @Test
    public void selectionSortTestOrder0() {
        int[] nums = genRandomArray(100);
        int[] arr = nums.clone();

        fat.selectionSort(nums, 0);
        arr = Arrays.stream(arr).sorted().toArray();

        for (int i=0; i < 100; ++i){
            assertEquals(nums[i], arr[i]);
        }
    }

    @Test
    public void selectionSortTestOrder1() {
        int[] nums = genRandomArray(100);
        int[] arr = nums.clone();
        fat.selectionSort(nums, 1);

        for( int i = 0; i < arr.length/2; ++i )
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        for (int i=0; i < 100; ++i){
            assertEquals(nums[i], arr[i]);
        }
    }


    @Test(expected = NumberFormatException.class)
    public void stringToIntConverterTestNumberException(){
        fat.stringToIntConverter("A1");
    }

    @Test
    public void stringToIntConverterTestNumber(){
        Integer a = (int) (Math.random()*100);
        String s = a.toString();
        fat.stringToIntConverter(s);
    }



    private int[] genRandomArray(int n){
        int[] nums = new int[n];
        for (int i=0; i < n; ++i){
            nums[i] = (int) (Math.random()*100);
        }
        return nums;
    }

    @BeforeClass
    public static void startTest(){
        DateTime dt = new DateTime();
        System.out.println(dt.toString(pattern));
    }

    @AfterClass
    public static void endTest(){
        DateTime dt = new DateTime();
        System.out.println(dt.toString(pattern));
    }
}
