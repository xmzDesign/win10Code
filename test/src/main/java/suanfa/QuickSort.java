package suanfa;

public class QuickSort {
	public static void sort(int[] a,int first,int last){
		if(first>=last){
			return;
		}
		int index=Partition(a, first, last);
		sort(a,first,index-1);//递归，缩小范围，最后会变成有序
		sort(a,index+1,last);
		
	}
	public static int Partition(int [] a,int first,int last){
		int key=a[0];
		while(first<last){//从后半部分向前扫描
			while(a[last]>=key&&last>first){
				last--;
			}
			a[first]=a[last];
			while(a[first]<=key&&first<last){//从前半部分向后扫描
				first++;
			}
			a[last]=a[first];
		}
		a[first]=key;
		return last;
		
	}
}
