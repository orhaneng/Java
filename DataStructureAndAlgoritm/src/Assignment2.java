import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of columns:");
		Integer col = Integer.parseInt(input.next());
		System.out.println("Enter threshold:");
		Integer threshold = Integer.parseInt(input.next());
		System.out.println("Enter consecutive times:");
		Integer consecutive = Integer.parseInt(input.next());

		while (true) {
			System.out.println("Entering lines:");
			String line = input.next();
			if (line == "q") {
				break;
			}
			try {
				Integer.parseInt(line);
			} catch (NumberFormatException ex) {
				continue;
			}
			
			int occurrencecount = 0;
			String[]  linesplit= line.split(" ");
			for (String item : linesplit) {
				if(Integer.parseInt(item)>threshold) {
					occurrencecount ++;
				}
			}
			
			if (occurrencecount>consecutive) {
				System.out.println("Threshold exceeded");
				break;
			}
			
			
			

		}

	}

}
