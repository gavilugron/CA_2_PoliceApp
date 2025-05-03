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

    int binarySearch_nonRecursive(ElemType key, int start, int end) {
        boolean found;
        int middle = 0;
        found = false;
        while ((start <= end) && (found == false)) {
            middle = (start + end) / 2;
            if (((Comparable) get(middle)).compareTo((Comparable) key) == 0) {
                found = true;
            } else if (((Comparable) get(middle)).compareTo((Comparable) key) < 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (found == true) {
            return middle;
        } else {
            return -1;
        }
    }

    int binarySearch_recursive(ElemType key, int start, int end) {
        int middle = 0;
        int result;
        middle = (start + end) / 2;

        if (((Comparable) get(middle)).compareTo((Comparable) key) == 0) {
            result = middle;
        } else if (start == end) {
            result = -1;
        } else {
            if (((Comparable) get(middle)).compareTo((Comparable) key) > 0) {
                result = binarySearch_recursive(key, start, middle - 1);
            } else {
                result = binarySearch_recursive(key, middle + 1, end);
            }
        }

        return result;
    }
//----------------------------- Bubble Sort - MyArrayList ------------------------------------------//

    public void bubblesort(){
        int i,j;
        Comparable elemAtJ, elemAtJPlus;
        for(i = 0; i < size(); i++)
        {
            for(j = 0; j < size()-1 -i; j++)
            {
                elemAtJ = (Comparable) get(j);
                elemAtJPlus = (Comparable) get(j + 1);
                if(elemAtJ.compareTo(elemAtJPlus) > 0)
                {
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
