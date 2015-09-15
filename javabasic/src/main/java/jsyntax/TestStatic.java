package jsyntax;

public class TestStatic extends TestStaticBase {

	static {
		System.out.println("test static");
	}
	
	public TestStatic() {
		System.out.println("test constructor");
	}
	
	public static void main(String[] args) {
		new TestStatic();
	}
}

class TestStaticBase {
	static {
		System.out.println("base static");
	}
	
	public TestStaticBase() {
		System.out.println("base constructor");
	}
}