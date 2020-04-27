package week3.day1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListReverse {
         public static void main(String[] args)
         {
        	 List<String> listComp = new LinkedList();
        	 listComp.add("HCL");
        	 listComp.add("Aspiresystems");
        	 listComp.add("Cts");
        	 int size = listComp.size();
        	 Collections.sort(listComp);
        	 for(int i=size-1;i>=0;i--)
        	 {
        		 System.out.println(listComp.get(i));
        	 }
        	 
         }
}
