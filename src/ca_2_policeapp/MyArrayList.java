/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2_policeapp;
import java.util.*;
/**
 *
 * @author gvilu
 */
public class MyArrayList<ElemType> extends ArrayList<ElemType> {

    //----------------------------- Binary Search - MyArrayList ------------------------------------------//

    int binarySearch_nonRecursive(ElemType key, int start, int end) {
        boolean found = false;
        int middle = 0;
        while ((start <= end) && (!found)) {
            middle = (start + end) / 2;
            if (((Comparable) get(middle)).compareTo((Comparable) key) == 0) {
                found = true;
            } else if (((Comparable) get(middle)).compareTo((Comparable) key) < 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return found ? middle : -1;
    }

    int binarySearch_recursive(ElemType key, int start, int end) {
        int middle = (start + end) / 2;
        if (start > end) return -1;
        if (((Comparable) get(middle)).compareTo((Comparable) key) == 0) {
            return middle;
        } else if (((Comparable) get(middle)).compareTo((Comparable) key) > 0) {
            return binarySearch_recursive(key, start, middle - 1);
        } else {
            return binarySearch_recursive(key, middle + 1, end);
        }
    }

//----------------------------------------MERGE SORT ----------------------------------------------------//
    public static void mergeSort(Employee[] list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(list, left, middle);
            mergeSort(list, middle + 1, right);
            merge(list, left, middle, right);
        }
    }


    // Merge two sorted parts of the list
    private static void merge(Employee[] list, int left, int middle, int right) {
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        // Create temporary arrays which help with the sorting storing temporary data, one for the left and other for the right side of the array
        Employee[] leftPart = new Employee[sizeLeft];
        Employee[] rightPart = new Employee[sizeRight];

        // Copy data into the temporary arrays
        for (int i = 0; i < sizeLeft; i++) {
            leftPart[i] = list[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            rightPart[j] = list[middle + 1 + j];
        }

        // Merge the two arrays back into the main list
        int i = 0, j = 0, k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (leftPart[i].getFullName().compareToIgnoreCase(rightPart[j].getFullName()) <= 0) {
                list[k] = leftPart[i];
                i++;
            } else {
                list[k] = rightPart[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements in the left part
        while (i < sizeLeft) {
            list[k] = leftPart[i];
            i++;
            k++;
        }

        // Copy any remaining elements in the right part
        while (j < sizeRight) {
            list[k] = rightPart[j];
            j++;
            k++;
        }
    }
}
