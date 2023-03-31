package bfsOrDfs.populatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 */
public class Solution {
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

    /**
     * 广度优先搜索
     * 层序遍历进行更新
     * 时间 1 ms 击败 67.54%
     * 内存 40.8 MB 击败 96%
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelCount = queue.size();
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                Node node = queue.poll();
                if (pre != null){
                    pre.next = node;
                }
                pre = node;

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 层序遍历更新
     * 时间 0 ms 击败 100%
     * 内存 41.2 MB 击败 45.38%
     * 想比 #connect 方法，减少队列的操作，直接把每一层看作一个链表
     * 访问第二行实际就是把第三行节点左右串联起来
     * @param root
     * @return
     */
    public Node betterConnect(Node root){
        if (root == null){
            return null;
        }
        Node cur = root;
        while (cur != null){
            //遍历当前层的时候，为了方便操作在下一层前面添加一个哑结点（注意这里是访问当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node();
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            while (cur != null){
                if (cur.left != null){
                    //如果当前节点的左子节点不为空，就让pre节点的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }// 处理完一行

            //把下一层串联成一个链表之后，让他赋值给cur(指向下一层第一个)，后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }
}
