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

//adjacency list:


//A -> B -> D
//B -> E
//C -> A -> F
//D -> E
//E ->
//F -> E -> J
//G -> H -> F
//H -> J
//J ->


class TreeNode
{
    public string Data { get; private set; }
    public TreeNode FirstChild { get; private set; }
    public TreeNode NextSibling { get; private set; }
    public TreeNode (string data, TreeNode firstChild, TreeNode nextSibling)
    {
        this.Data = data;
        this.FirstChild = firstChild;
        this.NextSibling = nextSibling;
    }
}