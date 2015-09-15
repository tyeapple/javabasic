package jsyntax;

import java.io.PrintWriter;

public class StaticTest {
	
	public static void main(String[] args) {
		
		DriverManager.setLogWriter(new PrintWriter(System.out));
		DriverManager.getConnection();
	}
	
}

class DriverManager {
	
	private static volatile java.io.PrintWriter logWriter = null;
	static {
		System.out.println("class inner static");
	}
	
	public static Object getConnection() {
		println("get connection");
		return null;
	}
	public static void println(String str) {
		logWriter.println(str);
		logWriter.flush();
	}

	public static void foo() {
		println("foo");
	}

	public static java.io.PrintWriter getLogWriter() {
		return logWriter;
	}

	public static void setLogWriter(java.io.PrintWriter logWriter) {
		DriverManager.logWriter = logWriter;
	}
}