package week1.day1;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args)
	{
		String text1 = "stop";
		String text2 = "joke";
		int a = text1.length();
		int b = text2.length();
		int c = 0;
		if(a==b)
		{
			char[] array1 = text1.toCharArray();
			char[] array2 = text2.toCharArray();
			Arrays.sort(array1);
		    Arrays.sort(array2);
		    for(int i=0;i<a;i++)
		    {
		    	if(array1[i]==array2[i])
		    	{
		    		c++;
		    	}
		    }
		    if(c==a)
		    {
		    	System.out.println("Anagram");
		    }
		    else
		    {
		    	System.out.println("Not Anagram");
		    }
	}

}
}
