package week2.day1;

public class CharCount {

	public static void main(String[] args)
	{
		int count = 0;
		String str = "Testleaf";
		char[] ch = str.toCharArray();
		for(char c : ch)
		{
			if((c=='T')||(c=='t'))
					{
				count++;
					}
		}
		System.out.println(count);

}
}
