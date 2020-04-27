package week1.day1;

public class RemoveDuplicateWords {
	public static void main(String[] args)
	{
		String text  = "we learnt java basics as part of java sessions in week1";
		int count = 0;
		String[] array = text.split(" ");
		for(int i=0;i<=array.length-1;i++)
		{
			for(int j=i+1;j<=array.length-1;j++)
			{
				if(array[i].equals(array[j]))
				{
					count++;
				}
			}
			if(count>1)
			{
				String[] a = array.replaceAll("array[i]"," ");
			}
			else
			{
				System.out.println(array[i]);
			}
		}
			
				
	}			
				

}
