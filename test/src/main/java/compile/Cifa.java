package compile;

import com.sun.tools.javac.main.Main;

public class Cifa {
	int a;
	public static void main(String[] args) {
		System.out.println(Cifa.class.getClass().getName());
		String [] str={"Cifa"};
		conplile(str);
	}
	public static int conplile(String[] args){
		Main compiler=new Main("javac");
		return compiler.compile(args);
	}

}
