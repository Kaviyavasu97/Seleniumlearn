package week1.day1;

public class Armstrong {
	public static void main(String[] args)
	{
		int n=153,r,s=0;
		int org=153;
		while(n!=0)
		{
			r=n%10;
			s=s+(r*r*r);
			n=n/10;
		}
		if(s==org)
		{
			System.out.println("Armstrong num");
		}
	}

}
