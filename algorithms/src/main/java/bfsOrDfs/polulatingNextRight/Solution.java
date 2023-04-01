package bfsOrDfs.polulatingNextRight;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @see <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node">LeetCode</a>
 */
public class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            Node last = null;
            for(int i = 0; i < length; i++){
                Node current = queue.poll();
                if (last != null){
                    last.next = current;
                }
                last = current;
                if (current != null && current.left != null) queue.offer(current.left);
                if (current != null && current.right != null) queue.offer(current.right);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
