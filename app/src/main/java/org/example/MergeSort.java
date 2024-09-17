package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort<Type extends Comparable<Type>> implements AlgorithmBasics {

    private ArrayList<Type> unsortedArray;
    
    public MergeSort()
    {
        unsortedArray = new ArrayList<Type>();
    }

    public MergeSort(ArrayList<Type> unsortedArray)
    {
        this.unsortedArray = unsortedArray;
    }

    public void setArray(ArrayList<Type> unsortedArray)
    {
        this.unsortedArray = unsortedArray;
    }

    public ArrayList<Type> getArray()
    {
        return unsortedArray;
    }
    
    public void sort()
    {
        mergeSort(unsortedArray, 0, unsortedArray.size()-1);
    }

    public void mergeSort(ArrayList<Type> unsortedArray, int left, int right)
    {
        if(left >= right)
        {
            return;
        }
        
        int middle = (left+right)/2;

        mergeSort(unsortedArray, left, middle);
        mergeSort(unsortedArray, middle+1, right);

        merge(unsortedArray, left, middle, right);
    }

    public void merge(ArrayList<Type> unsortedArray, int left, int middle, int right)
    {
        int n1 = middle-left+1;
        int n2 = right-middle;

        ArrayList<Type> tempLeft = new ArrayList<Type>();
        ArrayList<Type> tempRight = new ArrayList<Type>();

        for(int i=0; i<n1; i++)
        {
            tempLeft.add(unsortedArray.get(left+i));
        }
        for(int j=0; j<n2; j++)
        {
            tempRight.add(unsortedArray.get(middle+j+1));
        }

        int i = 0, j = 0;
        int k = left;

        while(i < n1 && j < n2)
        {
            if(tempLeft.get(i).compareTo(tempRight.get(j)) == -1 || tempLeft.get(i).compareTo(tempRight.get(j)) == 0)
            {
                unsortedArray.set(k, tempLeft.get(i));
                i++;
            }
            else
            {
                unsortedArray.set(k, tempRight.get(j));
                j++;
            }
            k++;
        }

        while(i < n1)
        {
            unsortedArray.set(k, tempLeft.get(i));
            i++;
            k++;
        }

        while(j < n2)
        {
            unsortedArray.set(k, tempRight.get(j));
            j++;
            k++;
        }
    }

    public String toString()
    {
        return String.valueOf(unsortedArray);
    }

    public static void main(String[] args)
    {
        MergeSort<Integer> unsortedArray = new MergeSort<Integer>(new ArrayList<Integer>(Arrays.asList(4, 5, 2, 1, 6, 3, 8, 4)));
        System.out.println("Unsorted Array: " + unsortedArray);
        unsortedArray.sort();
        System.out.println("Sorted Array: " + unsortedArray);
    }
}
