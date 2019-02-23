/*
 * Create a function to test if a binary tree is symmetric.
 *  A tree is symmetric if its left subtree is a mirror image of the right subtree.
 * 
 */
public class homework5 {

	public static void main(String[] args) {

		MirrorNode root = new MirrorNode(1);
		root.left = new MirrorNode(2);
		root.right = new MirrorNode(2);
		root.left.left = new MirrorNode(3);
		root.left.right = new MirrorNode(4);
		root.right.left = new MirrorNode(4);
		root.right.right = new MirrorNode(3);
		System.out.println(isSymmetric(root));
		
	}
	
	static boolean isMirror(MirrorNode node1,MirrorNode node2) {
		if(node1 == null&& node2==null) {
			return true;
		}
		if(node1!= null&&node2!=null&&node1.data == node2.data) {
			return (isMirror(node1.left, node2.right)&&isMirror(node1.right, node2.left));
		}
		return false;
	}
	
	static boolean isSymmetric(MirrorNode root) {
		return isMirror(root,root);
	}

}

class MirrorNode{
	int data;
	MirrorNode left, right;
	public MirrorNode(int data){
		this.data = data;
	}
}


