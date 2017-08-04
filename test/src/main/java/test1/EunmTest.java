package test1;

public class EunmTest {
	public static void main(String [] args){
		String input="MEDIUM";
		System.out.println(Size.MEDIUM.ordinal());
		Size size=Enum.valueOf(Size.class, input);
		System.out.println(size.getAbbreviation());
	}

}
	enum Size{
		SMALL("s"),MEDIUM("m"),LARGE("l"),EXTRA_LARGE("xl");
		private Size(String abbreviation){
			this.abbreviation=abbreviation;
		}
		
		public String getAbbreviation(){
			return abbreviation;
		}
		private String abbreviation;
	}
