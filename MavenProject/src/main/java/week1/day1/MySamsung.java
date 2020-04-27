package week1.day1;

public class MySamsung {
public static void main(String[]args)
{
	Samsung obj = new Samsung();
	obj.takeSnap();
	obj.addnum(9840816684L);
	long searchnum = obj.searchnum("kaviya");
	System.out.println(searchnum);
}
}
