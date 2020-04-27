package week3.day1;

import java.util.LinkedList;
import java.util.List;

public class DistinctChar {
	public static void main(String[] args)
	{
		List<Character> c = new LinkedList();
		String str = "Amazon India Private Limited";
		char[] ch = str.toCharArray();
		for(Character dup : ch)
		{
			if(!c.contains(dup))
			{
				c.add(dup);
			}
		}
		System.out.println(c);

	}

}
