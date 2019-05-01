package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class DicePrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		diceHelper(3, list);
		System.out.println(list);
	}

	public static void diceHelper(int dice, List<Integer> list) {
		if (dice == 0) {
			System.out.println(list);
		} else {
			for (int i = 1; i <= 6; i++) {
				list.add(i);
        				diceHelper(dice - 1, list);
				list.remove(list.size() - 1);
			}
		}

	}

}
