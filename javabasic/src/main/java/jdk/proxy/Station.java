package jdk.proxy;

public class Station implements TicketService {

	@Override
	public void sellTicket() {
		
		System.out.println("sell ticket...");
	}

	@Override
	public void inquire() {
		System.out.println("inquire ticket...");
	}

	@Override
	public void withdraw() {
		System.out.println("withdraw ticket...");
	}

	
}
