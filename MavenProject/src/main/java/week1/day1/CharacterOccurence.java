package week1.day1;

public interface CharacterOccurence {
	public static void main(String[] args)
	{
		String text = "Iam getting better with java";
		char ch='t';
		int count=0;
		char[] array  = text.toCharArray();
		for(int i=0;i<=array.length-1;i++)
		{
			if(array[i]==ch)
			{
				count++;
			}
				
		}
		System.out.println("Total count of that character("+ch+"):" + count);
		
	}

}
