package suanfa;

public class Selection {
	public static void sort(int a[]){
//		int n=a.length;
//		for(int i=0;i<n;i++){
//			
//			for(int j=0;j<n-1-i;j++){
//				int m=0;
//				if(Example.less(a[j+1], a[j])){
//					m=a[j];
//					a[j]=a[j+1];
//					a[j+1]=m;
//				}
//			}
//		}
		
		
		for(int i=0;i<a.length;i++){
			int min=a[i];
			int index=i;
			int temp;
			for(int j=i+1;j<a.length;j++){
				
				if(min>a[j]){
					min=a[j];
					index=j;
				}
			}
			temp=a[i];
			a[i]=a[index];
			a[index]=temp;
		}
	}

}
