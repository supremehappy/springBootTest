package test;

public class testReplace {

	public static void main(String[] args) {
		String ab = "This is A String";

		String temp="";
		
		for(int i=ab.substring(0,3).length(); i < ab.length(); i++) {
			temp += '*';
		}
		
		String a = ab.substring(0,3)+temp;
		
		System.out.println(ab.length());
		System.out.println(temp.length());
		System.out.println(a);
		System.out.println(a.length());


	}
}
