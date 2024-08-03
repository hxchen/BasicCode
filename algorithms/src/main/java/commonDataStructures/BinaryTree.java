package commonDataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>>{
    class TreeNode<T> {
        T data;          // 节点存储的数据
        TreeNode<T> prev;   // 左子节点的引用（也可以是前一个节点）
        TreeNode<T> next;   // 右子节点的引用（也可以是后一个节点）
        TreeNode<T> parent; // 父节点的引用

        // 构造函数
        public TreeNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
            this.parent = null;
        }
    }
    private TreeNode<T> root; // 树的根节点

    // 构造函数
    public BinaryTree() {
        root = null;
    }

    // 插入新节点（假设按照二叉搜索树的规则插入）
    public void insert(T data) {
        root = insertRec(root, null, data);
    }

    // 递归插入节点的方法
    private TreeNode<T> insertRec(TreeNode<T> node, TreeNode<T> parent, T data) {
        if (node == null) {
            TreeNode<T> newNode = new TreeNode<>(data);
            newNode.parent = parent;
            return newNode;
        }

        if (data.compareTo(node.data) < 0) {
            node.prev = insertRec(node.prev, node, data);
        } else {
            node.next = insertRec(node.next, node, data);
        }
        return node;
    }

    // 打印树的中序遍历
    public void inorder() {
        inorderRec(root);
    }
    private void inorderRec(TreeNode<T> node) {
        if (node != null) {
            inorderRec(node.prev);
            System.out.print(node.data + " ");
            inorderRec(node.next);
        }
    }

    // 层序遍历
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.print(node.data + " ");
            if (node.prev != null) {
                queue.offer(node.prev);
            }
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
    }

    // 满二叉树的插入
    public void insertFullBinaryTree(T[] data) {
        root = insertFullBinaryTreeRec(data, 0);
    }

    /**
     * 递归插入满二叉树
     * @param data  数据
     * @param index 当前节点的索引
     * @return
     */
    private TreeNode<T> insertFullBinaryTreeRec(T[] data, int index) {
        if (index >= data.length) {
            return null;
        }
        TreeNode<T> node = new TreeNode<>(data[index]);
        node.prev = insertFullBinaryTreeRec(data, 2 * index + 1);
        node.next = insertFullBinaryTreeRec(data, 2 * index + 2);
        return node;
    }

    // 满二叉树的查找
    public TreeNode<T> search(T data) {
        return searchRec(root, data);
    }

    private TreeNode<T> searchRec(TreeNode<T> root, T data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (root.data.compareTo(data) > 0) {
            return searchRec(root.prev, data);
        }
        return searchRec(root.next, data);
    }

    // 给你两个节点，输出两个节点的路径
    public void printPath(T data1, T data2) {
        TreeNode<T> node1 = search(data1);
        TreeNode<T> node2 = search(data2);
        if (node1 == null || node2 == null) {
            System.out.println("节点不存在");
            return;
        }
        TreeNode<T> lca = findLCA(root, node1, node2);
        if (lca == null) {
            System.out.println("没有公共祖先");
            return;
        }
        printPathRec(lca, node1);
        System.out.print(lca.data + " ");
        printPathRec(lca, node2);
    }

    private void printPathRec(TreeNode<T> lca, TreeNode<T> node1) {
        if (lca == null) {
            return;
        }
        if (lca.data == node1.data) {
            return;
        }
        if (lca.data.compareTo(node1.data) > 0) {
            printPathRec(lca.prev, node1);
        } else {
            printPathRec(lca.next, node1);
        }
        System.out.print(lca.data + " ");
    }

    private TreeNode<T> findLCA(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        TreeNode<T> left = findLCA(root.prev, node1, node2);
        TreeNode<T> right = findLCA(root.next, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    public static void main(String[] args) {
//        BinaryTree<Integer> tree = new BinaryTree<>();
//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);
//        tree.insert(90);
//        tree.insert(100);
//        tree.insert(110);
//        tree.insert(120);
//
//        tree.levelOrder();
        // 满二叉树
        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] data = {7,6,5,4,3,2,1};
        tree.insertFullBinaryTree(data);
        tree.levelOrder();
    }
}
