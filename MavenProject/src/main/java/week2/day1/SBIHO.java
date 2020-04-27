package week2.day1;

public abstract class SBIHO implements RBI,Cibil{

	@Override
	public void getCreditScore() {
		System.out.println("1000");
		
	}

	@Override
	public void minBalance() {
		System.out.println("2000");
		
	}

	@Override
	public void maxTransaction() {
		System.out.println("20k");
		
	}

	@Override
	public abstract void docRequiredForHomeLoan();
	public abstract void aaadharCardMandatory(); 
		
	

}
