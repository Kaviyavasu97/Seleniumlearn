package week2.day1;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class NumList {
	public static void main(String[] args)
	{ 
		Set<Integer> setNum = new LinkedHashSet();
		if(setNum.add(5))
		{
			System.out.println("added");
		}
		if(setNum.add(5))
		{
			System.out.println("added");
		}
		else
		{
			System.out.println(setNum.get(1));
		}

	}

}
