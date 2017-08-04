package suanfa;

public class Date implements Comparable<Date> {
	private final int day;
	private final int month;
	private final int year;
	public Date(int d,int m,int y){
		day=d;
		month=m;
		year=y;
	}

	@Override
	public int compareTo(Date o) {
		if(this.year>o.year) return 1;
		
		return 0;
		
	}
	

}
