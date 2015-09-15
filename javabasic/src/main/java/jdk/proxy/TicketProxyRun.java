package jdk.proxy;

import java.lang.reflect.Constructor;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;

public class TicketProxyRun {

	public static void main(String[] args) throws Exception {
		createProxy();
	}
	
	private static void createProxy() throws Exception {
		
		ClassPool pool = ClassPool.getDefault();
		
		CtClass cc = pool.makeClass("com.petertian.jdk.proxy.StationProxy");
		
		CtClass interface1 = pool.get("com.petertian.jdk.proxy.TicketService");
		cc.setInterfaces(new CtClass[]{interface1});
		
		CtField field = CtField.make("private com.petertian.jdk.proxy.Station station;", cc);
		cc.addField(field);
		
		CtClass stationClass = pool.get("com.petertian.jdk.proxy.Station");
		CtClass[] arrays = new CtClass[] {stationClass};
		CtConstructor ctc = CtNewConstructor.make(arrays, null, CtNewConstructor.PASS_NONE, null, null, cc);
		ctc.setBody("{this.station=$1;}");
		cc.addConstructor(ctc);
		
		CtMethod takeHandlingFee = CtMethod.make("private void takeHandlingFee() {}", cc);
		takeHandlingFee.setBody("System.out.println(\"收取手续费，打印发票...\");");
		cc.addMethod(takeHandlingFee);
		
		CtMethod showAlertInfo = CtMethod.make("private void showAlertInfo(String info) {}", cc);
		showAlertInfo.setBody("System.out.println($1);");
		cc.addMethod(showAlertInfo);
		
		CtMethod sellTicket = CtMethod.make("public void sellTicket() {}", cc);
		sellTicket.setBody("{this.showAlertInfo(\"××××您正在使用车票代售点进行购票，每张票将会收取5元手续费！××××\");"
				+ "station.sellTicket();"
				+ "this.takeHandlingFee();"
				+ "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}");
		cc.addMethod(sellTicket);
		
		CtMethod inquire = CtMethod.make("public void inquire(){}", cc);
		inquire.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，问询服务不会收取任何费用，本问询信息仅供参考，具体信息以车站真实数据为准！××××\");"
				+ "station.inquire();"
				+ "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}");
		cc.addMethod(inquire);
		
		CtMethod withdraw = CtMethod.make("public void withdraw(){}", cc);
		withdraw.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，退票除了扣除票额的20%外，本代理处额外加收2元手续费！××××\");"
				+ "station.withdraw();"
				+ "this.takeHandlingFee();}");
		cc.addMethod(withdraw);
		
		Class<?> c = cc.toClass();

		//构造被代理的Station
		Constructor<?> constructor = c.getConstructor(Station.class);
		TicketService obj = (TicketService) constructor.newInstance(new Station());
		obj.inquire();
		
		cc.writeFile("f://tmp");
	}
}
