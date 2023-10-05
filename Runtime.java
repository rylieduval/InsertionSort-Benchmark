import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Runtime
{
    static Random random = new Random();
    
    public static void main(String[] args)
    {
        System.out.println("Enter an array size: ");
        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();
        
        int[] myArray = new int[arraySize];
        myArray = RandomizedArray(arraySize, 0, 101);
        //print unsorted array just to test
        System.out.println("Unsorted Array = " + Arrays.toString(myArray));
        
        //see how long selection sort takes
        long start = System.nanoTime();
        SelectionSort(myArray);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;  
        System.out.println("Sorting a random array size of " + arraySize + " took selection sort " + timeElapsed + " ns to complete");
        //see how long bubble sort takes
        long start2 = System.nanoTime();
        BubbleSort(myArray);
        long finish2 = System.nanoTime();
        long timeElapsed2 = finish2 - start2;  
        System.out.println("Sorting a random array size of " + arraySize + " took bubble sort " + timeElapsed2 + " ns to complete");
        //see how long insertion sort takes
        long start3 = System.nanoTime();
        InsertionSort(myArray);
        long finish3 = System.nanoTime();
        long timeElapsed3 = finish3 - start3;  
        System.out.println("Sorting a random array size of " + arraySize + " took insertion sort " + timeElapsed3 + " ns to complete");
        System.out.println(Arrays.toString(myArray));
    }
    //fill an array with random numbers
    public static int[] RandomizedArray(int size, int start, int end)
    {
        int[] randomArray = new int[size];
    
        for (int i = 0; i < size; i++) 
        {
            randomArray[i] = random.nextInt((end) + start); 
        }
        
        return randomArray;
    }
    //selection sort function
    public static void SelectionSort(int[] arr) 
    {
        for (int i = 0; i < arr.length - 1; i++) 
        {
            //determine the smallest index
            int smallest = i;
            
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[j] < arr[smallest]) 
                {
                    smallest = j;
                }
            }
            //swap indexes if smaller
            if (smallest > i) 
            {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
            }
        
        }
    }   
    //bubble sort function
    public static void BubbleSort(int[] arr) 
    {
        int temp = 0;  
        //checking the index to the right of it
        for(int i=0; i < arr.length; i++)
        {  
            for(int j=1; j < arr.length - i; j++)
            {  
                //swapping the indexes if the left one is bigger
                if(arr[j-1] > arr[j])
                {  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }         
            }  
        } 
    }  
    //insertion sort function 
    public static void InsertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) 
        {
            //determine the unsorted and sorted part of the array
            int key = arr[i];
            int j = i - 1;

            //keeping finding sport for certain index as you move right to left, swapping indexes if smaller

            while (j >= 0 && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    }
 
