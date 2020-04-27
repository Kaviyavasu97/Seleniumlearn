package week3.day1;

import java.util.LinkedList;
import java.util.List;

public class DuplicatesPrint {
	public static void main(String[] args)
	{
		List<Character> c = new LinkedList();
		String str = "Infosys Limited";
		char[] ch = str.toCharArray();
		for(Character dup : ch)
		{
		if(!c.contains(dup))
		{
			c.add(dup);
		}
		else
		{
			System.out.println(dup);
		}
	}
		

}
}
