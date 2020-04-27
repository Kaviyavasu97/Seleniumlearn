package week1.day1;

public class SumOfDigits {
public static void main(String[] args)
{
	int sum = 345,n=0;
	while(sum!=0)
	{
		n=n+(sum%10);
		System.out.println(n);
		sum=(sum/10);
		System.out.println(sum);
	}
	System.out.println(n);
}
}
