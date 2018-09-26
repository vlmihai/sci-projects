
class TreeNode <T>{

    T data;
    TreeNode left;
    TreeNode right;

    TreeNode (T data) { this.data = data; }

    public TreeNode(T data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
