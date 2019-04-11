import java.util.ArrayList;

public class classPassByValue {

	public static void main(String[] args) {
		/*
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
		*/
		
		Balloon red = new Balloon("Red"); //memory reference 50
		Balloon blue = new Balloon("Blue"); //memory reference 100
		
		swap(red, blue);
		System.out.println("red color="+red.getColor());
		System.out.println("blue color="+blue.getColor());
		
		foo(blue);
		System.out.println("blue color="+blue.getColor());
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
	
	public static class Balloon {

		private String color;

		public Balloon(){}
		
		public Balloon(String c){
			this.color=c;
		}
		
		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}
	private static void foo(Balloon balloon) { //baloon=100
		balloon.setColor("Red"); //baloon=100
		balloon = new Balloon("Green"); //baloon=200
		balloon.setColor("Blue"); //baloon = 200
	}

	//Generic swap method
	public static void swap(Object o1, Object o2){
		Object temp = o1;
		o1=o2;
		o2=temp;
	}
}
