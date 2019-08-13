package exercise_demo.tree;

/**
 * @author yudong
 * @create 2019-08-13 17:51
 */
public class preTraverseBTree {
    public static void preTraverseBTree(TreeNode rootTreeNode){
        if(rootTreeNode != null){
            System.out.println(rootTreeNode.getValue());
            preTraverseBTree(rootTreeNode.getLefTreeNode());
            preTraverseBTree(rootTreeNode.getRightNode());
        }
    }
}
