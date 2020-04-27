package week1.day1;

public class Fibonacci {
	public static void main(String[]args)
	{
	int a=0,b=1,temp;
	for(int i=0;i<=100;i++)
	{
		temp=a+b;
		if(temp>100)
			break;
		a=b;
		b=temp;
		System.out.println(temp);
	}
	}

}
