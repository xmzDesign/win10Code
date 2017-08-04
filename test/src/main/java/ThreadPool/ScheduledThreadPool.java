package ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	static int i=0;
	public static void main(String[] args) {
//		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
//		newScheduledThreadPool.schedule(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//			}
//			
//		}, 3, TimeUnit.SECONDS);//3秒后执行
		
		
		ScheduledSignal.getInstance().schedule(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
			}
			
		}, 3, TimeUnit.SECONDS);
		System.out.println("不管你");
		
		while(true){
			ScheduledSignal.getInstance().schedule(new Runnable(){
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName());
					System.out.println(++i);
				}
				
			}, 1, TimeUnit.SECONDS);
		}
		
		//System.out.println("不管你");
		
//		newScheduledThreadPool.scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//			}
//			
//		},1, 3, TimeUnit.SECONDS);//一秒后  每隔三秒执行
		
	}

}
