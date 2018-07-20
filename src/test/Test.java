package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class Test {

	public int add(int a,int b){   
        try {
            return a+b;      
        } 
       catch (Exception e) {  
           System.out.println("catch语句块");
        }
        finally{ 
            System.out.println("finally语句块");
        }
        return 0;
   } 
    public static void main(String argv[]){ 
    	HashMap<String, String> map = new HashMap<String, String>();
    	Hashtable<String, String> table = new Hashtable<String, String>();
    	TreeMap<String, String> tree = new TreeMap<String, String>();
    	
        Test test =new Test(); 
        System.out.println("和是："+test.add(9, 34)); 
    }

}
