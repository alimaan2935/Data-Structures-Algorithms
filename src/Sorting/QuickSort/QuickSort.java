package Sorting.QuickSort;

import java.util.Random;

public class QuickSort {

    /**
     * Partition at last element
     * @param array
     * @param low
     * @param high
     * @return
     */
    private int partition (int[] array, int low, int high) {
        int pivot = array[high];
        int i = low-1; //index of smaller element

        for (int j = low; j<high; j++) {
            //if current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;
                //swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //swap array[i+1] and array[high] or pivot
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }

    /**
     * Main function to sort
     * @param array
     * @param low
     * @param high
     */
    public void sort(int[] array, int low, int high) {
        if (low<high) {
            //partitioning index - array[partition] is now at the right place
            int partition = partition(array, low, high);

            // recursively sort elements before and after partition
            sort(array, low, partition-1);
            sort(array, partition+1, high);

        }
    }

    private static void printArray(int[] array) {
        int n = array.length;
        for (int i=0; i<n; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10000000];
        int n = 10000000;

        for (int i = 0; i<n; i++)
            array[i] = random.nextInt(n);

        long s = System.currentTimeMillis();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, n-1);
        long e = System.currentTimeMillis();
        System.out.println("Elapsed Time = " + (e-s)+ " miliseconds");

        //System.out.println("Sorted array");
        //printArray(array);

    }
}
