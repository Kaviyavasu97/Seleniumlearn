package week1.day1;

public class FindTypes {
public static void main(String[] args)
{
	String test = "$$ Welcome to second automation class 567 $$";
	int letter=0,num=0;int space = 0,specialChar=0;
	char[] array  = test.toCharArray();
	for(int i=0;i<=array.length-1;i++)
	{
		if(Character.isLetter(array[i]))
		{
			letter++;
		}
		else if(Character.isDigit(array[i]))
		{
			num++;
		}
		else if(Character.isSpaceChar(array[i]))
		{
			space++;
		}
		else
		{
			specialChar++;
		}
	}
	System.out.println("Letter:" + letter);
	System.out.println("Space:" + space);
	System.out.println("Number:" + num);
	System.out.println("Specialcharacter:" + specialChar);
	
}
}
