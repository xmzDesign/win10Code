package test1;

public class Ricky implements Student {

	public void resolveQuestion(Callback callback) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}

		// 回调，告诉老师作业写了多久
		callback.tellAnswer(3);

	}

}
