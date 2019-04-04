package HashTable;

public class interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(1);
	}

    public static void solution(int N) {
    	//TIME COMPLEXITY O(N)
    	//SPACE COMPLEXITY O(1)
    	if(N==0) return;
    	//else if(N==1) {System.out.println("L"); return;}
    	
    	for(int i=0;i<N*2-1;i++) {
    		if(i<N-1) {
    			System.out.println("L");
    		}else {
    			System.out.print("L");
    		}
    	}
    }
}
