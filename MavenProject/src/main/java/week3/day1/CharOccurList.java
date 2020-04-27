package week3.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class CharOccurList {
	public static void main(String[] args)
	{
		Map<Character,Integer>map = new HashMap<>();
		String str = "PayPal India";
		char[] ch = str.toCharArray();
		for(char c : ch)
		{
			if(!map.containsKey(c))
			{
				map.put(c,1);
			}
			else
			{
				map.put(c,map.get(c)+1);
							
		}
		}


		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		Set<Integer>count = new TreeSet<Integer>();
		for(Entry<Character,Integer>entry : entrySet)
		{
						

			count.add(entry.getValue());
		}
		List<Integer>listcount = new ArrayList<Integer>(count);
		int size = listcount.size();
		for(Entry<Character,Integer>entry:entrySet)
		{
			if(entry.getValue()==listcount.get(size-2))
			{
				System.out.println(entry.getKey());
			}
		}
	


}
}
