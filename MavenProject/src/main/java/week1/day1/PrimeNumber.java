package week1.day1;

public class PrimeNumber {
	public static void main(String[] args)
	{
		int n=15;
		boolean flag=false;
		for(int i=2;i<=n/2;i++)
		{
		int r = n%i;
		if(r==0)
		{
			flag=true;
			break;
		}
		}
		if(flag==false)
		{
			System.out.println("PrimeNumber");
		}
		else
		{
			System.out.println("Not a primenumber");
		}
	}

}
