package week1.day1;

import java.util.Arrays;

public class MissingElement {
	public static void main(String[] args)
	{
		int[] data = {3,2,4,6,7,8};
		Arrays.sort(data);
		for(int i=0;i<=data.length-1;i++)
		{
			if(data[i+1]!=data[i]+1)
			{

				System.out.println(data[i]+1);
				break;
			}

		}

	}
}
