package week1.day1;

public class ChangeOddIndexToUpper {
	public static void main(String[] args)
	{
		String test  = "changeme";
		char[] array = test.toCharArray();
		for(int i=0;i<=array.length-1;i++)
		{
			if(i%2!=0)
			{
              char a = Character.toUpperCase(array[i]);
			
			System.out.print(a);
			}
			else
			{
						System.out.print(array[i]);
				
			}
		}
		
	}
}



