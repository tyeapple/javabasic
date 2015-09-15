package jdk.classloader;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//类型本来有：简单类型和复杂类型，引入泛型后把复杂类型分的更细了
public class GenericTest {

	//简化代码
	public void write(Integer i, Integer[] ia) {}
	public void write(Double d, Double[] da) {}
	
	public <T> void write(T t, T[] ta) {}
	
	// 定义泛型
	// 1. 定义在类后面
	public class TestClassDefine<T, S extends T> {}
	// 2. 定义在方法后面
	public <T, S extends T> T testGenericMethodDefine(T t, S s) {
		return s;
	}
	
	// 实例化泛型
	// 1. 类变量或者实例化时
	static {
		List<String> list;
		list = new ArrayList<String>();
	}
	// 2. 继承类或者实现接口时
	public class MyList<E> extends ArrayList<E> implements List<E> {} 
	//当调用范型方法时，编译器自动对类型参数(泛型)进行赋值，当不能成功赋值时报编译错误
	
	// 通配符？
	// 当赋值的类型不能确定时，用通配符？代替
	// Java集合框架中，对于参数值是未知类型的容器类，只能读取其中元素，不能向其中添加元素，因为，其类型是未知
	// 所以编译器无法识别添加元素的类型和容器的类型是否兼容，唯一的例外是NULL
	List<?> unknownList;
	List<? extends Number> unknownNumberList;
	List<? super Integer> unknownBaseLineIntegerList;
	
	@Test
	public void test1() {
		TestClassDefine<A, B> tcd = new TestClassDefine<A, B>();
		System.out.println(tcd.getClass());
		
		A a = testGenericMethodDefine(new A(), new B());
		System.out.println(a.getClass());
	}
	
	@Test
	public void test2() {
		
		List<String> slist = new ArrayList<String>();
		slist.add("a");
		//表示类型的上界
		List<? extends String> list1 = slist;
		//list1.add("b");  //compile error
		//表示类型的下界, 表示参数化类型是此类型的超类型（父类型）直至Object
		List<? super String> list2 = slist;
		list2.add("b");
	}
}

class A {}
class B extends A {}

