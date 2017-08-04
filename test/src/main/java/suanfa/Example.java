package suanfa;

import java.util.Arrays;

import javax.xml.stream.events.StartDocument;

public class Example {
	public static void sort(Comparable[] a){
		
	}
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	public static void exch(int[] a,int i,int j){
		int t=a[i];a[i]=a[j];a[j]=t;
	}
	public static void show(int [] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static boolean isSorted(Comparable [] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])) return false;
		}
		return false; 
	}
	public static void main(String[] args) {
//		int [] str={1,3,5,2,6,4,0,7,9,0,2,3};
//		//Arrays.sort(str);
//		long a=System.nanoTime();
//		Selection.sort(str);
//		show(str);
//		System.out.println(System.nanoTime()-a);
//		
//		int [] str1={1,3,5,2,6,4,0,7,9,0,2,3};
//		long b=System.nanoTime();
//		Insertion.sort(str1);
//		show(str1);
//		System.out.println(System.nanoTime()-b);
//		int [] str2={1,3,5,2,6,4,0,7,9,0,2,3};
//		Shell.sort(str2, str2.length);
//		show(str2);
//		int [] str3={1,3,5,2,6,4,0,7,9,0,2,3};
//		int [] temp={1,3,5,2,6,4,0,7,9,0,2,3,0};
//		MergeSort.mergesort(str3, 0,str3.length);
//		show(str3);
//		long c=System.nanoTime();
		int [] str4={1,3,5,2,6,4,0,7,9,0,2,3};
		QuickSort.sort(str4, 0, str4.length-1);
		show(str4);
//		System.out.println(System.nanoTime()-c);
	}

}
