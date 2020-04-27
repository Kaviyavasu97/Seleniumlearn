package week1.day1;

public class ReverseString {
public static void main(String[] args)
{
	String test = "feeling good";
	char[] array = test.toCharArray();
	for(int i= array.length-1;i>=0;i--)
	{
		System.out.print(array[i]);
	}
	
	
	
}
}
