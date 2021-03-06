package io.javapractice.ipldashboard;

import java.util.*;

public class ListToArray {
	
	public static void main(String args[]){  
	  ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();	
	  ArrayList<String> list=new ArrayList<String>(); 
      list.add("Mango");   
      list.add("Apple");    
      list.add("Banana"); 
      
      ArrayList<String> list2=new ArrayList<String>(); 
      list2.add("Orange");   
      list2.add("PineApple");    
      list2.add("Kiwi");
      
      ArrayList<String> list3=new ArrayList<String>(); 
      list3.add("Papaya");   
      list3.add("WaterMelon");    
      list3.add("Mosambi");
      
     res.add(list) ;
     res.add(list2) ;
     res.add(list3) ;
     
     String[][] array = res.stream().map(l -> l.stream().toArray(String[]::new)).toArray(String[][]::new);
     
     for(int i=0;i<array.length;i++) {
    	 for(int j=0;j<array[i].length;j++) {
    		 System.out.print(array[i][j]+ " ");
    	 }
    	 System.out.println(" ");
     }
    
	}

}
