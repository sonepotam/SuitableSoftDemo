package ru.pavel2107.tests.suitablesoftdemo.service.finder;

import org.springframework.stereotype.Service;

/*
* Назначение класса : поиск K-го максимального элемента
* Единственный метод: findLargest возвращает Kt-ый элемент
*
* В принципе все эти поиски от лукавого. В массиве должны быть сотни тысяч элементов для появления значимых различий
* Я специально попробовал быстрый поиск, встроенный sort и еще один метод
* Значимые различия появляются на массивах длиной миллионы элементов
*
 */



@Service
public class QuickSelectElementFinderImpl implements ElementFinder{
    @Override
    public int findLargest(int[] arr, int n) {
        int len = arr.length;
        return quickSelect( arr, 0, len - 1, len - n);
    }

    private int quickSelect(int[] arr, int left, int right, int kSmallest) {
        // When the left and right pointers meet, we've found the kSmallest element
        if (left == right) {
            return arr[left];
        }

        // Initialize two pointers for the partitioning step
        int i = left - 1;
        int j = right + 1;
        // Choose pivot as the middle element
        int pivot = arr[(left + right) >>> 1];

        while( i < j) {
            // Move i right past any elements less than the pivot
            do {
                i++;
            } while( arr[i] < pivot);

            // Move j left past any elements greater than the pivot
            do {
                j--;
            } while( arr[j] > pivot);

            // Swap elements at i and j if they are out of order with respect to the pivot
            if (i < j) {
                swap( arr, i, j);
            }
        }

        // After partitioning, the pivot is now at index j
        // If we found the kSmallest element, return it
        if (j >= kSmallest) {
            return quickSelect( arr, left, j, kSmallest);
        }

        // Otherwise, continue the search in the right partition
        return quickSelect( arr, j + 1, right, kSmallest);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
