package week2.day1;

public class MyMobile {
	public static void main(String[] args)
	{
		Samsung obj = new Samsung();
		obj.TakePic();
		obj.TxtMsg();
		Iphone obj1 = new Iphone();
		System.out.println(obj1.TxtMsg("Hi"));
	}

}
