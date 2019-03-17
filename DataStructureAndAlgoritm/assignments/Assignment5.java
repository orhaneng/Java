/*
NAME: OMER ORHAN GID:16
ASSIGNMENT5
TEST CASE:
N=4
RESULT=Sorry not much fortune today!
TIME COMPLEXITY:O(N) (N iS NEWLINE NUMBER)
SPACE COMPLEXITY:O(1)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		filereader(5);
	}

	public static String filereader(int n) {
		File file = new File("/Users/omerorhan/git/Java/DataStructureAndAlgoritm" + "/assignments/Assignment5text.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				if (count == n && !"%".equals(line)) {
					System.out.println(line);
				}
				if ("%".equals(line)) {
					count++;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
