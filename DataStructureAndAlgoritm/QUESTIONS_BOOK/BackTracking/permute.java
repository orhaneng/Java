package BackTracking;

public class permute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permuteHelper("MARTY","");
		
		//char[] a="book".toCharArray();
		//System.out.println(a[3] ^= (1 << 5));
	}

	public static void permuteHelper(String s, String chosen) {
		//System.out.println("s="+s+"/ chosen="+chosen);
		if (s.isEmpty()) {
			System.out.println(chosen);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			chosen += c;
			s = erase(s,c);
			permuteHelper(s, chosen);
			s= add(s,c,i);
			chosen = erase(chosen, chosen.charAt(chosen.length()-1));
		}
	}

	public static String erase(String text, char c) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == c)
				continue;

			result = result + String.valueOf(text.charAt(i));
		}
		return result;
	}

	public static String add(String text, char c, int k) {
		if(text.isEmpty()) {
			return String.valueOf(c);
		}
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			if (k == i) {
				result += String.valueOf(c);
			}
			result = result + String.valueOf(text.charAt(i));
		}
		return result;
	}

}
