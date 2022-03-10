package org.pg4200.ex04;

public class SortingTest {
    public static void main(String[] args) {
        int[] testarray = {5,5,4,4,3,3,2,2,1,1,7,7,6,6};
        //Populate array with random ints
        /*
        for (int i = 0; i < testarray.length; i++) {
            testarray[i] = (int)Math.floor(Math.random()*(10-1+1)+1);
        }
        */
       printArray(splitArray(testarray));
    }

    public static void printArray(int[] array) {
        for (int i: array
        ) {
            System.out.print(i + ", ");
        }
    }

    public static int[] splitArray(int[] array) {

        //Exit condition of recursion, arr of size 1 or 0 already sorted
        if (array.length == 1) {
            printArray(array);
            System.out.print("|");
            return array;
        }

        int[] arr1;
        int[] arr2;

        int middle = (int)(array.length/2);

        if (array.length % 2 == 0) {
            arr1 = new int[middle];
            arr2 = new int[middle];
        } else {
            arr1 = new int[middle];
            arr2 = new int[middle + 1];
        }

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = array[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = array[i+arr1.length];
        }

        printArray(arr1);
        System.out.print("|");
        printArray(arr2);
        System.out.print("|");

        arr1 = splitArray(arr1);
        //System.out.println("Done splitting first array");
        arr2 = splitArray(arr2);

        System.out.print("?");

        return merge(arr1,arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int arr1elements = arr1.length;
        int arr2elements = arr2.length;
        int[] arr3 = new int[arr1elements+arr2elements];

        int amountlooped = 0;
        int arr1iter = 0;
        int arr2iter = 0;

        while (arr1iter < arr1elements && arr2iter < arr2elements) {
            if (arr1[arr1iter] > arr2[arr2iter]) {
                arr3[amountlooped] = arr1[arr1iter];
                arr1iter++;
            } else {
                arr3[amountlooped] = arr2[arr2iter];
                arr2iter++;
            }
            amountlooped++;
        }

        //If comparison above is done, this is done to append rest of arr1 to end of arr3
        while (arr1iter < arr1elements) {
            arr3[amountlooped] = arr1[arr1iter];
            arr1iter++;
            amountlooped++;
        }

        //If comparison above is false, this is done to append rest of arr2 to end of arr3
        while (arr2iter < arr2elements) {
            arr3[amountlooped] = arr2[arr2iter];
            arr2iter++;
            amountlooped++;
        }

        //returns the sorted, merged list
        return arr3;
    }



}
