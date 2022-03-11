package org.pg4200.ex04;

public class SortingTest {
    public static void main(String[] args) {
        int[] testarray = {5,5,4,4,3,3,2,2,1,1,7,7,6,6};

        //Debug print statement to see what happens
        printArray(splitArray(testarray));

       //See if I can assert the final sorted list to a variable
        int[] test = splitArray(testarray);
        System.out.println("Before print");
        printArray(test);
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

        int middle = array.length/2;

        //Create new arrays based on if youre splitting an even or odd number array
        if (array.length % 2 == 0) {
            arr1 = new int[middle];
            arr2 = new int[middle];
        } else {
            arr1 = new int[middle];
            arr2 = new int[middle + 1];
        }

        //Copies half original array into arr1
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = array[i];
        }
        //Copies second half of original array into arr2
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = array[i+arr1.length];
        }

        //Simply prints the newly split arrays for debug purposes
        printArray(arr1);
        System.out.print("|");
        printArray(arr2);
        System.out.print("|");

        //Look at me mom im doing recursion
        //Simply keeps splitting the arrays until the exit condition of array size 1 is met
        arr1 = splitArray(arr1);
        arr2 = splitArray(arr2);

        //A print for debug that shows every time a merge has been made
        System.out.print("?");

        return merge(arr1,arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int arr1elements = arr1.length;
        int arr2elements = arr2.length;
        int[] arr3 = new int[arr1elements+arr2elements];

        //Keeps track of amount of times youve added anything to the new sorted arr3
        int amountlooped = 0;
        //Keeps track of amount of times youve "popped" something from arr1 and the same thing for arr2
        int arr1iter = 0;
        int arr2iter = 0;

        //This is the loop with the main comparator, keeps going until either arr1 or arr2 is emptied (sorted)
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
