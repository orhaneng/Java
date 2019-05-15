package homework6;

/**
 * File Name: knapsack01.java Dynamic programming
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */
class knapsack01 extends knapsack01Base {
	// given
	private int s; // Bag size Given
	private int[] wa; // weight array: Given
	private int[] ca; // cost array: Given
	private int[] maxans; // Final value of items stolen. You need to compute and fill this.

	// You can use as many private data structure you want

	knapsack01() {
		// Nothing can be added here
		testBench();
	}

	@Override
	protected void knapsack(int bagSize, int[] weightArray, int[] costArray, int[] maxans) {
		int[][] vmatrix = new int[weightArray.length + 1][bagSize + 1];
		int[][] kmatrix = new int[weightArray.length + 1][bagSize + 1];

		for (int i = 0; i <= weightArray.length; i++) {
			for (int j = 0; j <= bagSize; j++) {
				if (i == 0 || j == 0) {
					vmatrix[i][j] = 0;
					kmatrix[i][j] = 0;
				} else if (weightArray[i - 1] <= j) {
					vmatrix[i][j] = Math.max(costArray[i - 1] + vmatrix[i - 1][j - weightArray[i - 1]],
							vmatrix[i - 1][j]);
					if (vmatrix[i - 1][j] <= costArray[i - 1] + vmatrix[i - 1][j - weightArray[i - 1]])
						kmatrix[i][j] = 1;
					if (maxans[0] < vmatrix[i][j]) {
						maxans[0] = vmatrix[i][j];
					}
				} else {
					vmatrix[i][j] = vmatrix[i - 1][j];
					kmatrix[i][j] = 0;
				}
			}
		}

		System.out.println("---------vmatrix---------");
		for (int i = 0; i < vmatrix.length; i++) {
			for (int j = 0; j < vmatrix[0].length; j++) {
				System.out.print(vmatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------kmatrix----------");
		for (int i = 0; i < kmatrix.length; i++) {
			for (int j = 0; j < kmatrix[0].length; j++) {
				System.out.print(kmatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.print("i = ");
		for (int i = 0; i < weightArray.length; i++) {
			System.out.print(i + 1 + " ");
		}
		System.out.println();
		System.out.print("w = ");
		for (int i = 0; i < weightArray.length; i++) {
			System.out.print(weightArray[i] + " ");
		}
		System.out.println();
		System.out.print("v = ");
		for (int i = 0; i < costArray.length; i++) {
			System.out.print(costArray[i] + " ");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		System.out.println("knapsack01.java starts");
		knapsack01 m = new knapsack01();
		System.out.println("You are amazing. Bring me a bar of Chocolate");
		System.out.println("knapsack01.java ends");
	}
}