/*
 * Minimum Index Sum of Two Lists
  Go to Discuss
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 TIME O(N)
 SPACE O(N)
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        String[] result=null;
        ArrayList<String> result1=new ArrayList<String>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int sum=list1.length+list2.length;
        int index=0;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                 if((map.get(list2[i])+i)<sum){
                     result1=new ArrayList<String>();
                     index=0;
                     result1.add(list2[i]);
                     index++;
                     sum = map.get(list2[i])+i;
                 }else if(map.get(list2[i])+i==sum){
                     result1.add(list2[i]);
                 }
            }
        }
        result = new String[result1.size()];
        for(int i=0;i<result1.size();i++){
            result[i]=result1.get(i);
        }
        return result;
    }
}
