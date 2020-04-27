package week1.day1;

import java.util.Arrays;

public class DupilcateElement {
	public static void main(String[] args)
	{
		int[] data = {1,3,8,3,11,5,6,4,7,6,7};
		Arrays.sort(data);
		for(int i=0;i<data.length-1;i++)
		{
			if(data[i]==data[i+1])
			{
				System.out.println("Duplicate value"+data[i]);
			}
		}
	}

}
