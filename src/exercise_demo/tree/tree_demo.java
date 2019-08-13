package exercise_demo.tree;

/**
 * @author yudong
 * @create 2019-08-13 17:35
 */
public class tree_demo {

    public static  void createTree(TreeRoot treeRoot,int value){

        if(treeRoot.getTreeRoot() == null){
            TreeNode treeNode = new TreeNode(value);
            treeRoot.setTreeRoot(treeNode);
        }else {
            TreeNode tempRoot = treeRoot.getTreeRoot();

            while (tempRoot != null){
                if(value > tempRoot.getValue()){
                    if(tempRoot.getRightNode() == null){
                        tempRoot.setRightNode(new TreeNode(value));
                        return;
                    }else {
                        tempRoot = tempRoot.getRightNode();
                    }
                } else {
                    if(tempRoot.getLefTreeNode() == null){
                        tempRoot.setLefTreeNode(new TreeNode(value));
                        return;
                    }else {
                        tempRoot = tempRoot.getLefTreeNode();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int arrays[] = {2,3,1,4,5};
        TreeRoot treeRoot = new TreeRoot();
        for(int value:arrays){
            createTree(treeRoot,value);
        }
        preTraverseBTree.preTraverseBTree(treeRoot.getTreeRoot());
    }
}
