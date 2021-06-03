package Unit2Module5;

import java.util.Arrays;

public class IterationSort {

	public static void main(String[] args) {
		int[] lst = {0, 2, 5, 1, 8, 6, 4, 9, 2};
		System.out.println("initial list" + Arrays.toString(lst));
		System.out.println("final list" + Arrays.toString(mergeSort(lst)));
	}
	
	public static int[] mergeSort(int[] lst) {
		//When length of list is 0 or 1 return the same list
		if(lst.length <= 1) {
			return lst;
		}

		//When length of list is 2 
		if(lst.length == 2) {
			//swap elements of unsorted list
			if(lst[0] > lst[1]) {
				int temp;
				temp = lst[0];
				lst[0] = lst[1];
				lst[1] = temp;
			}
			//return sorted list
			return lst;
		}
		//splitting main array
		int lst1Length = lst.length / 2;
		int lst2Length = lst.length - lst1Length;

		int[] lst1 = new int[lst1Length];
		System.arraycopy(lst, 0, lst1, 0, lst1Length);		
		int[] lst2 = new int[lst2Length];
		System.arraycopy(lst, lst1Length, lst2, 0, lst2Length);

		//sort each subarray individually
		int[] firstArray = mergeSort(lst1);
		int[] secondArray = mergeSort(lst2);
		
		//merge sorted arrays
		int[] result = new int[lst.length];
		for(int i = 0, j=0, k=0; i < result.length; i++) {
			if(j >= firstArray.length && k < secondArray.length) {
				//firstArray was fully added to result, add the rest of the sorted elements in secondArray to result
				while(k < secondArray.length) {
					result[i] = secondArray[k];
					k++;
					i++;
				}
				//exit for loop
				break;			
			}
			if(j < firstArray.length && k >= secondArray.length) {
				//firstArray was fully added to result, add the rest of the sorted elements in secondArray to result
				while(j < firstArray.length) {
					result[i] = secondArray[j];
					j++;
					i++;
				}
				//exit for loop
				break;
			}
			if(firstArray[j] <= secondArray[k]) {
				//next element in firstArray is smaller than next element of secondArray
				result[i] = firstArray[j];
				j++;
				continue;
			}
			if(firstArray[j] > secondArray[k]) {
				//next element in secondArray is smaller than next element of firstArray
				result[i] = secondArray[k];
				k++;
				continue;
			}
		}
		return result;
	}
}
