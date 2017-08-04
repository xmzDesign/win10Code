package suanfa;

public class printf {
	public static void main(String[] args) {
		double d = 345.678;
		String s = "你好！";
		int i = 1234;
		//"%"表示进行格式化输出，"%"之后的内容为格式的定义。
		System.out.printf("%f",d);//"f"表示格式化输出浮点数。
		System.out.println();
		System.out.printf("%9.2f",d);//"9.2"中的9表示输出的长度，2表示小数点后的位数。
		System.out.println();
		System.out.printf("%+9.2f",d);//"+"表示输出的数带正负号。
		System.out.println();
		System.out.printf("%-9.4f",d);//"-"表示输出的数左对齐（默认为右对齐）。
		System.out.println();
		System.out.printf("%+-9.3f",d);//"+-"表示输出的数带正负号且左对齐。
		System.out.println();
		System.out.printf("%d",i);//"d"表示输出十进制整数。
		System.out.println();
		System.out.printf("%o",i);//"o"表示输出八进制整数。
		System.out.println();
		System.out.printf("%x",i);//"x"表示输出十六进制整数。
		System.out.println();
		System.out.printf("%#x",i);//"#"表示输出带有十六进制标志的整数。
		System.out.println();
		System.out.printf("%s",s);//"d"表示输出字符串。
	}

}
