package com.collecton.org;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      TreeMap<Integer,String>tm = new TreeMap<Integer,String>();
      tm.put(101,"Amit");
      tm.put(105, "Sumanth");
      tm.put(98,"uma");
      tm.put(123,"Nisha");
      Set<Entry<Integer, String>> names = tm.entrySet();
      for(Map.Entry me:names)
      {
    	 System.out.print(me.getKey()); 
    	 System.out.print(me.getValue());
    	 System.out.println();
      }
      tm.remove(101);
      System.out.println("After rfemoval the data in the map is");
      for(Map.Entry me:names)
      {
    	 System.out.print(me.getKey()); 
    	 System.out.print(me.getValue());
    	 System.out.println();
      }
	}
}
