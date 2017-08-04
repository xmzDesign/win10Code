package ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledSignal {
	private ScheduledSignal(){}
	private static class ScheduledSignalHolder{
		private static ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
	}
	public static ScheduledExecutorService getInstance(){
		return ScheduledSignalHolder.newScheduledThreadPool;
		
	}

}
