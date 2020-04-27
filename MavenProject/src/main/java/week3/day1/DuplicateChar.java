package week3.day1;

import java.util.LinkedList;
import java.util.List;

public class DuplicateChar {
	public static void main(String[] args)
	{
		List<Character> c = new LinkedList();
		String str = "PayPal India";
		char[] ch = str.toCharArray();
		for(Character dup : ch)
		{
		if(!c.contains(dup))
		{
			c.add(dup);
		}
		else
		{
			c.remove(dup);
		}
		}
		for(int i=0;i<c.size();i++)
		{
		System.out.println(c.get(i));
	}
}
}

