public class TreeNode<T> {

    private T value = null;
    private TreeNode[] childrens = new TreeNode[100];
    private int childCount = 0;

    TreeNode(T value) {
        this.value = value;
    }

    public TreeNode addChild(T value) {
        TreeNode newChild = new TreeNode(value, this);
        childrens[childCount++] = newChild;
        return newChild;
    }

    static void traverse(TreeNode obj) {
        if (obj != null) {
            for (int i = 0; i < obj.childCount; i++) {
                System.out.println(obj.childrens[i].value);
                traverse(obj.childrens[i]);
            }
        }
        return;
    }

    void printTree(TreeNode obj) {
        System.out.println(obj.value);
        traverse(obj);
    }
}