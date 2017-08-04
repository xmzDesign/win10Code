package test1;

public class Teacher implements Callback {
	
	private Student student;
	      
	      public Teacher(Student student) {
	          this.student = student;
	     }
	     
	     public void askQuestion() {
	    	 System.out.println(this);
	         student.resolveQuestion(this);
	     }

	public void tellAnswer(int answer) {
		  System.out.println("知道了，你的答案是" + answer);

	}

}
