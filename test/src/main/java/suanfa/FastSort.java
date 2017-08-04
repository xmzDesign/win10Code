package suanfa;
/**
 * 快速排序
 * @author Minzhe Xu	2017年4月7日下午3:43:29
 *
 */
public class FastSort {
	public static void main(String[] args) {
		int a[]={4,5,6,2,4,6,7,8,3,2,5,6,10,6};
		int start=0;
		int end=a.length-1;
		sort(a,start,end);
		for(int i = 0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
	}

	private static void sort(int[] a, int low, int high) {
		int start=low;
		int end=high;
		int key=a[low];
		while(end>start){
			while(end>start&&a[end]>=key){//从后往前比较，如果该值不小于关键值，下标值减1,直到遇到一个比关键值小的,进行交换
				end--;
			}
			if(a[end]<=key){
				int temp=a[end];
				a[end]=a[start];
				a[start]=temp;
			}
			while(end>start&&a[start]<=key){//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			}
			if(a[start]>=key){
				int temp=a[end];
				a[end]=a[start];
				a[start]=temp;
			}	
		}
		 //递归
		if(start>low){
			sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
		}
		if(high>end){
			sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
		}
		
		
	}

}
