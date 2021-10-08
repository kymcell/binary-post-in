// Kyle McElligott
import java.util.*;
import java.io.*;

public class CompleteBinaryTree {
    //implements a complete binary tree stored in an array

	int values[]; //stores the tree
		          //values are stored in positions
		          //1 through currentSize;

	int currentSize; //The current number of values in the tree

	public CompleteBinaryTree(int s[]) {
        values = new int[s.length+1];
        for (int i = 0; i < s.length; i++) {
            values[i+1] = s[i];
        }
        currentSize = s.length;
	}

	public String toPostorder() {
    //Returns a string of the ints in the tree in post order
        return toPostorder(1);
	}

    private String toPostorder(int r) {
    //Returns a string of the ints in the subtree rooted at r in post order
				if(r > currentSize) return "";
				return toPostorder(2*r) + toPostorder((2*r)+1) + Integer.toString(values[r]) + " ";
    }

    public String toInorder() {
    //Returns a string of the ints in the tree in inorder
        return toInorder(1);
    }

    private String toInorder(int r) {
    //Returns a string of the ints in the subtree rooted at r in inorder
				if(r > currentSize) return "";
				return toInorder(2*r) + Integer.toString(values[r]) + " " + toInorder((2*r)+1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader(args[0]));
        Scanner s = new Scanner(b.readLine());
        int nums[] = new int[s.nextInt()];
        int i = 0;
        while (s.hasNextInt()) {
            nums[i] = s.nextInt();
            i++;
        }
        CompleteBinaryTree t = new CompleteBinaryTree(nums);
        System.out.println("Post Order: "+t.toPostorder());
        System.out.println("In Order: "+t.toInorder());
    }
}
