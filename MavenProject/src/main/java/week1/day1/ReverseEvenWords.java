package week1.day1;

public class ReverseEvenWords {
	public static void main(String[] args)
	{
		String test = "Iam a software tester";
		String[] test2 = test.split(" ");
		for( int i=0;i<=test2.length-1;i++)
		{
			if(i%2!=0)
			{
				System.out.print(test2[i]+" ");
			}
			if(i%2==0)
			{
				char[] name = test2[i].toCharArray();
				for(int j=name.length-1;j>=0;j--)
				{
					System.out.print(name[j]+" ");
				}
			}
		}
		
	}

}
