package jdk.proxy;

/**
 * 售票服务接口
 * @author petertian
 *
 */
public interface TicketService {

	//售票
	public void sellTicket();
	
	//问询
	public void inquire();
	
	//退票
	public void withdraw();
}
