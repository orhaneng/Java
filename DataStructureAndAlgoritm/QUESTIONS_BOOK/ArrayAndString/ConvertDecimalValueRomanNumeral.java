package ArrayAndString;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConvertDecimalValueRomanNumeral {
	static HashMap<Integer, String> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map = new HashMap<Integer, String>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		System.out.println(intToRoman(1997));
	}

	 public static String intToRoman(int num) {
		    if (num == 0) {
		        return "";
		    }
		    int decimalFact = 0;
		    StringBuilder result = new StringBuilder();
		    for (int i = (int)Math.log10(num); i >= 0; i--) {
		        int divisor = (int) Math.pow(10, i);
		        decimalFact = num - num % divisor;
		        result.append(convertDecimalFact(decimalFact));
		        num = num % divisor;
		    }
		    return result.toString();
		}

		private static String convertDecimalFact(int decimalFact){
		  if(decimalFact == 0){return "";}
		  int[] keyArray = map.keySet().stream().mapToInt(key -> key) 
		       .sorted().toArray(); 

		  for(int i =0 ; i+1<keyArray.length ; i++){
		      if( keyArray[i] <= decimalFact && decimalFact<= keyArray[i+1]  ){
		         int bigger1stDgt = getLeftMostNum(keyArray[i+1]);
		         int decimalFact1stDgt = getLeftMostNum(decimalFact);
		         return decimalFact1stDgt >= bigger1stDgt-1 ? 
		                intToRoman(keyArray[i+1]-decimalFact)+map.get(keyArray[i+1]): 
		                map.get(keyArray[i])+intToRoman(decimalFact - keyArray[i]);
		      }
		  }      
		  return "";
		}

		private static int getLeftMostNum(int number) {
		    int oneDgt = Integer.valueOf(Integer.valueOf(number).toString()
		                 .substring(0, 0 +1));
		    if(number<10){
		        return oneDgt;
		    }       
		    int twoDgts = Integer.valueOf(Integer.valueOf(number).toString()
		                  .substring(0, 0 +2));
		    return twoDgts==10 ? twoDgts : oneDgt;
		}

}
