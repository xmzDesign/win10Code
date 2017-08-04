package suanfa;
/**
 * 归并排序
 * @author Minzhe Xu	2017年3月27日下午2:41:17
 *
 */
public class MergeSort {
	/**
	 * 传入两个有序数组从小到大合并
	 * @param a
	 * @param first
	 * @param mid
	 * @param last
	 * @param temp
	 */
	public static void mergearray(int a[],int first,int mid,int last){
		 int length=last-first+1;
		 int temp[]=new int[length];
		int i=first,j=mid+1;
		int m=mid,n=last;
		int k=0;
		while(i<=m&&j<=n){
			if(a[i]<=a[j]){
				temp[k++]=a[i++];
			}else{
				temp[k++]=a[j++];
			}
		}
		while(i<=m){
			temp[k++]=a[i++];
		}
		while(j<=n){
			temp[k++]=a[j++];
		}
		for(i=0;i<k;i++){
			a[first + i] = temp[i];
		}
	}
	public static void mergesort(int a[],int first,int last){
		if(first<last){
			int mid=(first+last)/2;
			mergesort(a,first,mid);//左边有序
			mergesort(a,mid+1,last);//右边有序
			mergearray(a, first, mid, last);//合并
		}
	}
	 
}
