package Sorting.MergeSort;

public class MergeSort {
    private int[] numbers;
    private int[] helper;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        helper = new int[number];

        mergeSort(0, number-1);
    }

    private void mergeSort (int low, int high) {
        //check if low is smaller than high, if not then list is already sorted
        if (low<high) {
            //get the index of the element which is in the middle
            int middle  = low+(high-low) /2;

            //sort the left side of the array
            mergeSort(low, middle);
            //sort right side of the array
            mergeSort(middle+1, high);

            //combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        //copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i  = low;
        int j = middle+1;
        int k = low;

        //copy the smallest values either from the left or side side back to the original array
        while (i<=middle && j<=high) {
            if (helper[i] <= helper[j]){
                numbers[k] = helper[i];
                i++;
            }else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        //copy rest of the left side of the array into target array
        while (i<=middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }
}
