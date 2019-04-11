import java.util.ArrayList;

public class classPassByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example ex = new Example(23);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[3];
		for (int integer : arr) {
			System.out.println(integer);
		}
		//System.out.println(list.size());
		func(arr);
		//System.out.println(list.size());
		for (int integer : arr) {
			System.out.println(integer);
		}
		
	}
	
	
	public static void func(Example ex) {
		ex.value = 45;
	}
	
	public static void func(ArrayList<Integer> ex) {
		ex.add(2);
	}
	
	public static void func(int[] ex) {
		ex[0]=1;
		ex[1]=3;
	}

	public static class Example{
		int value;
		public Example(int value) {
			this.value = value;
		}
	}
}
