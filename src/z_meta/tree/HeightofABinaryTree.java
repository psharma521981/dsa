package src.z_meta.tree;

import java.util.ArrayList;
import java.util.List;

public class HeightofABinaryTree {
    public static int height(Node root) {
        List<Integer> levels= new ArrayList<>();
        calculateHeight(root,0,levels);
        return levels.size()-1;
    }

    private static void calculateHeight(Node root, int i, List<Integer> levels) {

        if(root==null)
            return;

        if(i==levels.size()) {
            levels.add(root.data);
        }
            calculateHeight(root.left,i+1,levels);
            calculateHeight(root.right,i+1,levels);
    }
    /*
    static int height(Node root) {
      if (root == null || root.right == null && root.left == null) return 0;
      return Math.max(height(root.right), height(root.left)) + 1;
}
     */
}
