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
//----------------------------- Bubble Sort - MyArrayList ------------------------------------------//

    public void bubblesort() {
        int i, j;
        Comparable elemAtJ, elemAtJPlus;
        for (i = 0; i < size(); i++) {
            for (j = 0; j < size() - 1 - i; j++) {
                elemAtJ = (Comparable) get(j);
                elemAtJPlus = (Comparable) get(j + 1);
                if (elemAtJ.compareTo(elemAtJPlus) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void swap(int pos1, int pos2) {
        ElemType objPos1 = get(pos1);
        ElemType objPos2 = get(pos2);
        set(pos1, objPos2);
        set(pos2, objPos1);
    }
}