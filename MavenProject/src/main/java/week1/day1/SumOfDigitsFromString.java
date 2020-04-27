package week1.day1;

public class SumOfDigitsFromString {
	public static void main(String[] args)
	{
		String text = "Test123y456";
		int sum = 0;
		char[] array = text.toCharArray();
		for(int i=0;i<=array.length-1;i++)
		{
			if(Character.isDigit(array[i]))
			{
			int check = Character.getNumericValue(array[i]);
			sum=sum+check;
			}
	}
		System.out.println(sum);
	
	}
}
