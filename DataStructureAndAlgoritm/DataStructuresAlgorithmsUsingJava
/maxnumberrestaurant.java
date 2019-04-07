import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class maxnumberrestaurant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have a record of the arrival and departure time of all customers 
		//visiting a restaurant
		//e.g. A: (11:00, 12:00), B: (11:01, 11:20), C: (11:30, 12:00), D: (11:45, 1:00),
		//E: (1:00: 2:00)
		//write a code to find the max number of customers were at the restaurant 
		//at the same time.
		

		Integer[] time = {1100, 1200};
		Integer[] time2 = {1101, 1120};
		Integer[] time3 = {1130,1200};
		Integer[] time4 = {1145,0100};

		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		list.add(time);
		list.add(time2);
		list.add(time3);
		list.add(time4);
				
		System.out.println(maxnumber(list));
	}
	
	public static int maxnumber(ArrayList<Integer[]> list) {
		
		ArrayList<Integer> exittime= new ArrayList<Integer>();
		int count=0;
		int maxcount= 0;
		
		for (Integer[] time : list) {
			
			exittime.add(time[1]);
			++count;
			
	        Iterator itr = exittime.iterator(); 
	        while (itr.hasNext()) 
	        { 
	            int x = (Integer)itr.next(); 
	            if (x < 10) 
	                itr.remove(); 
	        } 

			for (Iterator<Integer> iterator = exittime.iterator(); iterator.hasNext(); ) {
			    Integer value = iterator.next();
			    if(time[0]>value) {
			    	iterator.remove();
					--count;
				}
			}
			
			if(maxcount<count) {
				maxcount=count;
			}
		}

		
		return maxcount;
		
	}

}

