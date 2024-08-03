package commonDataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class FullBinaryTree<T> {
    private TriPointerNode<T> root;
    private int currentData;

    public FullBinaryTree() {
        this.root = null;
        this.currentData = 1; // 从1开始编号
    }

    // 生成一个N层的满二叉树
    public TriPointerNode<T> generateFullBinaryTree(int levels) {
        if (levels <= 0) {
            return null; // 如果层数小于或等于0，返回空树
        }

        // 初始化树的根节点
        root = new TriPointerNode<>(generateData());
        buildTree(root, levels - 1);
        return root;
    }

    // 递归地构建树
    private void buildTree(TriPointerNode<T> node, int remainingLevels) {
        if (remainingLevels == 0) {
            return; // 如果没有剩余层数，停止递归
        }

        // 构建左子节点
        TriPointerNode<T> leftChild = new TriPointerNode<>(generateData());
        node.setLeft(leftChild);
        leftChild.setParent(node);
        buildTree(leftChild, remainingLevels - 1);

        // 构建右子节点
        TriPointerNode<T> rightChild = new TriPointerNode<>(generateData());
        node.setRight(rightChild);
        rightChild.setParent(node);
        buildTree(rightChild, remainingLevels - 1);
    }

    // 生成节点数据（可以根据需要自定义）
    @SuppressWarnings("unchecked")
    private T generateData() {
        return (T) Integer.valueOf(currentData++);
    }

    // 内部类TriPointerNode
    private static class TriPointerNode<T> {
        private T data;
        private TriPointerNode<T> parent;
        private TriPointerNode<T> left;
        private TriPointerNode<T> right;

        public TriPointerNode() {
            this.data = null;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public TriPointerNode(T data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        // 获取数据
        public T getData() {
            return data;
        }

        // 设置数据
        public void setData(T data) {
            this.data = data;
        }

        // 获取父节点
        public TriPointerNode<T> getParent() {
            return parent;
        }

        // 设置父节点
        public void setParent(TriPointerNode<T> parent) {
            this.parent = parent;
        }

        // 获取前驱节点
        public TriPointerNode<T> getLeft() {
            return left;
        }

        // 设置前驱节点
        public void setLeft(TriPointerNode<T> left) {
            this.left = left;
        }

        // 获取后继节点
        public TriPointerNode<T> getRight() {
            return right;
        }

        // 设置后继节点
        public void setRight(TriPointerNode<T> right) {
            this.right = right;
        }

        /**
         * 层序遍历打印
         */
        public void levelOrder() {
            if (this == null) {
                return;
            }
            Queue<TriPointerNode<T>> queue = new LinkedList<>();
            queue.offer(this);
            while (!queue.isEmpty()) {
                TriPointerNode<T> node = queue.poll();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }
    }

    public static void main(String[] args) {
        FullBinaryTree<Integer> tree = new FullBinaryTree<>();
        TriPointerNode<Integer> root = tree.generateFullBinaryTree(3);

        root.levelOrder();
    }
}

