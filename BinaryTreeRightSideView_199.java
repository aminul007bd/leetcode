import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
*/
public class BinaryTreeRightSideView_199 {
    //Algo Used: Pre - order traversal. we can used any traversal over here, we are not using BFS bcz in that the SC can be halkf of N at times,
    // here the SC is O(Height) , TC: O N
    // In pre-order we do Ro-L-R but for printing right view we are doing Ro-R-L,
    // for printing left view we can use Ro-L-R

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, 0, ans); // Start the DFS traversal, passing the root, current level (0), and the result list.
        return ans;
    }

    public void rightView(TreeNode root, int level, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (level == ans.size()) {    //level == ans.size(), this will ensure that we are adding the first element only of that level  from the right side in the list.
            ans.add(root.val);  // Ro
        }
        rightView(root.right, level + 1, ans);  //R
        rightView(root.left, level + 1, ans);    //L
    }
}
