package week2.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapLearn {
	public static void main(String[] args)
	{
		String str = "Pleasefocus";
		char[] ch = str.toCharArray();
		for(int i=0;i<=ch.length-1;i++)
		{
			int count=1;
			for(int j=i+1;j<=ch.length-1;j++)
			{
			if(ch[i]==ch[j])
			{
				count++;
				
			}
			}
			Map<Character,Integer> map = new HashMap<>();
			map.put(ch[i],count);
		
		for(Entry<Character,Integer> eachMap : map.entrySet())
		{
			System.out.println(eachMap);
		}
			
		}	
			
		
	}

}
