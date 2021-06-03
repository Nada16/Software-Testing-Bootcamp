package Unit2Module5;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("please enter the size of the list:");
		int size = in.nextInt();
		int[] lst = new int[size];
		
		System.out.println("Please enter the elements of the list. Press enter after each number");
		for(int i = 0; i < size; i++) {
			lst[i] = in.nextInt();
		}
		System.out.print("Initial list: ");
		for(int n: lst) {
			System.out.print(" " + n);
		}
		
		System.out.println();
		System.out.println("Please enter a number to search for it in the list:");
		int num = in.nextInt();
		in.close();
		
		int numIndex = binarySearch(lst, num);
		if(numIndex == -1) {
			System.out.println("Sorry! " + num + " was not found in the list");
		}else {
			System.out.println("Index of " + num + " is " + numIndex);
		}
	}
	
	public static int binarySearch(int[] lst, int num) {
		Arrays.sort(lst);
		
		System.out.print("Sorted list: ");
		for(int n: lst) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		int searchIndex = lst.length / 2;
		int loIndex = 0;
		int hiIndex = lst.length - 1;
		
		while(searchIndex >= loIndex && searchIndex <= hiIndex) {
			//1. num is found in search index
			if(lst[searchIndex] == num) {
				return searchIndex;
			}
			//2. number in search index is larger than num
			else if(lst[searchIndex] > num) {
				//Move to the half with smaller numbers
				hiIndex = searchIndex-1;
			}
			//3. number in search index is smaller than num
			else {
				//Move to the half with larger numbers
				loIndex = searchIndex+1;
				//System.out.println("MinI: " + minIndex);
			}
			searchIndex = loIndex + ((hiIndex-loIndex) / 2);
			//System.out.println("SearchI: " + searchIndex);
		}
		
		return -1;
		
	}
}
