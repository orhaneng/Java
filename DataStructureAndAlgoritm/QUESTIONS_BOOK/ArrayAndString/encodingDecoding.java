package ArrayAndString;

public class encodingDecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printRLE("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW"));
	}

	public static String encoding(String text) {
		StringBuilder encode = new StringBuilder();
		if(text!=null) {
			int count=1;
			char ch;
			ch=text.charAt(0);
			char chnext;
			for (int i = 1; i < text.length(); i++) {
				count++;
				if(i+1==text.length()) {
					chnext= ' ';
				}else {
					chnext =text.charAt(i+1);
				}
				if(ch!=chnext) {
					encode.append(count+String.valueOf(ch));
					ch=chnext;
					count=0;
				}
			}
		}
		return encode.toString();
	}
	
	public static String decofing(String text) {
		StringBuilder encode = new StringBuilder();
		
		return encode.toString();
	}
	
    public static String printRLE(String str) 
    { 
        int n = str.length(); 
        String text="";
        for (int i = 0; i < n; i++) { 
  
            // Count occurrences of current character 
            int count = 1; 
            while (i < n - 1 &&  
                   str.charAt(i) == str.charAt(i + 1)) { 
                count++; 
                i++; 
            } 
  
            // Print character and its count 
            text = text +count+ str.charAt(i); 
        } 
        return text;
    } 

}
