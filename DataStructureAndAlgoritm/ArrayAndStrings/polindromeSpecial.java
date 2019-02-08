
public class polindromeSpecial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(palindrome("bMa......a.m!"));
	}

	public static boolean palindrome(String text) {
		if (text == null || text.isEmpty()) {
			return false;
		}
		int beginindex = 0;
		int endindex = text.length() - 1;
		text = text.toLowerCase();
		
		for (int i = 0; i < text.length(); i++) {
			if (((text.charAt(beginindex) >= 'a' && text.charAt(beginindex) <= 'z'))
					&& ((text.charAt(endindex) >= 'a' && text.charAt(endindex) <= 'z'))
					&& text.charAt(beginindex) != text.charAt(endindex)) {
				System.out.println(text.charAt(beginindex) + "-" + text.charAt(endindex));
				return false;
			}
			if (((text.charAt(beginindex) >= 'a' && text.charAt(beginindex) <= 'z'))
					&& ((text.charAt(endindex) >= 'a' && text.charAt(endindex) <= 'z'))
					&& text.charAt(beginindex) == text.charAt(endindex)) {
				System.out.println(text.charAt(beginindex) + "-" + text.charAt(endindex));
				beginindex++;
				endindex--;
				continue;

			}
			if (!(text.charAt(beginindex) >= 'a' && text.charAt(beginindex) <= 'z')
					&& beginindex < (text.length() / 2 )) {
				beginindex++;
			}
			if (!(text.charAt(endindex) >= 'a' && text.charAt(endindex) <= 'z' )
					&& endindex >( text.length() / 2 )) {
				System.out.println("ss");
				endindex--;
			}

			//if (beginindex == text.length() / 2 || endindex==text.length() / 2) {
			//	System.out.println("dddd"+beginindex+endindex);
			//if (text.charAt(beginindex) != text.charAt(endindex)&& 
			//		(!(text.charAt(endindex) >= 'a' && text.charAt(endindex) <= 'z')||
			//				!(text.charAt(beginindex) >= 'a' && text.charAt(beginindex) <= 'z')))
			//	return false;
			//}
		}
		return true;
	}

}
