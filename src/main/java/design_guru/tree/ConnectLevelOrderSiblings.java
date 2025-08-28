package tree;

import java.util.LinkedList;
import java.util.Queue;
class TreeNodeList {
    int val;
    TreeNodeList left;
    TreeNodeList right;
    TreeNodeList next;

    TreeNodeList(int x) {
        val = x;
        left = right = next = null;
    }
};
public class ConnectLevelOrderSiblings {
    public TreeNodeList connect(TreeNodeList root) {

        if(root == null)
            return root;

        Queue<TreeNodeList> treeNodeQueue = new LinkedList<>();

        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()) {

            int size = treeNodeQueue.size();

            for(int i=1;i<=size;i++) {
                TreeNodeList node = treeNodeQueue.poll();

                if(i==size)
                    node.next = null;
                else
                    node.next = treeNodeQueue.peek();

                if(node.left !=null)
                    treeNodeQueue.add(node.left);
                if(node.right !=null)
                    treeNodeQueue.add(node.right);
            }

        }

        return root;
    }
    public static void main(String[] args) {
        ConnectLevelOrderSiblings sol = new ConnectLevelOrderSiblings();
        TreeNodeList root = new TreeNodeList(12);
        root.left = new TreeNodeList(7);
        root.right = new TreeNodeList(1);
        root.left.left = new TreeNodeList(9);
        root.right.left = new TreeNodeList(10);
        root.right.right = new TreeNodeList(5);
        root = sol.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        printLevelOrder(root);
    }
    public static void printLevelOrder(TreeNodeList root) {
        TreeNodeList nextLevelRoot = root;
        while (nextLevelRoot != null) {
            TreeNodeList current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
