package jdk.collection;

public class DumpApp {

	public static void main(String[] args) throws Exception {
		
		for(String line : FileUtils.readlines(args[0])) {
			System.out.println(line);
		}
	}

}
