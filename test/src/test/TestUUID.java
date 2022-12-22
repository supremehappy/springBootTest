package test;

import java.util.ArrayList;
import java.util.UUID;

public class TestUUID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String id = UUID.randomUUID().toString();
		
		System.out.println("UUID : "+id);
		
		ArrayList<String> temp = new ArrayList<String>();
				
		for(int i=0; i<10; i++) {
			
			temp.add(UUID.randomUUID().toString());
			
			//System.out.println("Array UUID"+i+" : "+temp.get(i));
		}
		
		for(String x : temp) {
			//Integer.parseInt(x);
			System.out.println(x);
		}
		
		
		
	}

}
