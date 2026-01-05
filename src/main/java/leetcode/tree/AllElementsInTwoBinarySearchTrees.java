package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> root1Sort = preOrderTraverse(root1, new ArrayList<>());
        List<Integer> root2Sort = preOrderTraverse(root2, new ArrayList<>());

        List<Integer> finalList = new ArrayList<>();

        int list1Length = root1Sort == null ? 0 : root1Sort.size();
        int list2Length = root2Sort == null ? 0 : root2Sort.size();
        int i=0;
        int j=0;

        while(i<list1Length && j<list2Length)  {
            if(root1Sort.get(i) < root2Sort.get(j)) {
                finalList.add(root1Sort.get(i));
                i++;
            } else {
                finalList.add(root2Sort.get(j));
                j++;
            }
        }

        while(i<list1Length)  {
            finalList.add(root1Sort.get(i));
            i++;
        }
        while(j<list2Length)  {
            finalList.add(root2Sort.get(j));
            j++;
        }
        return finalList;
    }

    List<Integer> preOrderTraverse(TreeNode root,List<Integer> output) {

        if(root == null)
            return null;

        preOrderTraverse(root.left,output);
        output.add(root.val);
        preOrderTraverse(root.right,output);

        return  output;
    }
    //Check for iterative solution for this
}
