/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2_policeapp;

/**
 *
 * @author gvilu
 */
import java.util.*;

public class BubbleSort<ElemType> extends ArrayList<ElemType> {
    //-------------------  BUBBLE SORT METHOD  ---------------------//
    public void bubbleSort() {
        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - i - 1; j++) {
                Comparable a = (Comparable) get(j);
                Comparable b = (Comparable) get(j + 1);
                if (a.compareTo(b) > 0) {
                    ElemType temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }

    //-------------------  BINARY SEARCH METHOD  ---------------------//
    int binarySearchRecursive(String name, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        String middleName = ((Employee) get(middle)).getFirstName();

        int comparison = middleName.compareToIgnoreCase(name);
        if (comparison == 0) {
            return middle;
        } else if (comparison > 0) {
            return binarySearchRecursive(name, start, middle - 1);
        } else {
            return binarySearchRecursive(name, middle + 1, end);
        }
    }
}
