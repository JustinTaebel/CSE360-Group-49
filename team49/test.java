package team49;


import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException{
		
		Database test = new Database("test");
		String[] data = new String[2];
		data[0] = "hello";
		data[1] = "world";
		test.dataWrite(data);
		String[] current = test.getCurrentData();
		for(int i = 0; i < current.length; i++) {
			System.out.println(current[i]);
		}
		
		
		
		
		
		
		
		
		
		
//		Database database = new Database();
//		database.removeLine(database.search("Doctor","Jane"));
//		String[] lines = database.read();
//		for(int ii = 0; ii < lines.length; ii++) {
//			System.out.println(lines[ii]);
//		}
//		System.out.println("--------------------");
//		database.writeString("Test,Value");
//		String[] lines2 = database.read();
//		for(int ii = 0; ii < lines2.length; ii++) {
//			System.out.println(lines2[ii]);
//		}
//		
//		System.out.println("--------------------");
//		String[] lines3 = database.read();
//		database.removeLine(database.search("Nurse", "Matt"));
//		for(int ii = 0; ii < lines3.length; ii++) {
//			System.out.println(lines3[ii]);
//		}
//		System.out.println("--------------------");

	}

}
