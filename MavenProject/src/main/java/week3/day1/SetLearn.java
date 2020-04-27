package week3.day1;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SetLearn {
	public static void main(String[] args)
	{
		List<Character> ch = new LinkedList();
		String str = "PayPal India";
		char[] c = str.toCharArray();
		for(Character let : c)
		{
			ch.add(let);
		}
		Set<Character> rem = new LinkedHashSet<>();
		for(Character lettr : ch)
		{
			rem.add(lettr);
		}
		System.out.println(rem);
		
		
	}

}
