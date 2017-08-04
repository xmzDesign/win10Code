package suanfa;
/**
 * 二分排序 其实并不是一种新的算法
 * 刚开始会先构建一个有序区，随后把后面无序区的数值一个个 通过二分查找找到 比这个值大的的坐标（例如是3），那么这个值的下标就是2
 * 把有序区从2开始的数组都往后挪
 * 把无序区的这个值插进去
 * @author Minzhe Xu	2017年4月25日上午9:41:42
 *
 */
public class ErFen {
	 public static void main(String[] args) {
	        int []a={4,2,1,6,3,6,0,-5,1,1};
	        int i,j;
	        int low,high,mid;
	        int temp;
	        for(i=1;i<10;i++){
	            temp=a[i];
	            low=0;
	            high=i-1;
	            while(low<=high){
	                mid=(low+high)/2;
	                if(a[mid]>temp)//拿临时的值与中间值进行比较，比他小，说明 下标应该比中间值的下标小
	                    high=mid-1;
	                else
	                    low=mid+1;  
	            }
 	            for(j=i-1;j>high;j--)
	                a[j+1]=a[j];//a[i]=a[i-1]  //数组向后扩容  直到遇到high下标为止
	            				
	            a[high+1]=temp;//a[i-1]=temp     空出来的这个  节点插入
	        }
	        for(i=0;i<10;i++){
	            System.out.printf("%d ",a[i]);
	        }
	    }

}
