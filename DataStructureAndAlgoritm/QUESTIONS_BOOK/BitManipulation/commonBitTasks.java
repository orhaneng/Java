package BitManipulation;

public class commonBitTasks {

	static boolean getBit(int num, int i) {
		return ((num & 1 << i)) != 0;
	}

	static int setBit(int num, int i) {
		return ((num | 1 << i));
	}

	int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}

	int clearBitsMSBThroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}

	int clearBitsMSBThrough0(int num, int i) {
		int mask = (-1 << (i + 1));
		return num & mask;
	}

	int updateBit(int num, int i, boolean bitIs1) {
		int value = bitIs1 ? 1 : 0;
		int mask = ~(1 << i);
		return (num & mask) | (value << i);
	}
	
	public static void main(String[] args) {
		int N = 3;
		
		System.out.println(setBit(N,2));
	}
}
