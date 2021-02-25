package zigzagLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haixiangchen
 */
public class Solution {
    /**
     * 锯齿形遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        // tmp表示当前层的节点val
        List<Integer> tmp = new ArrayList<>();
        // num表示下一层的节点个数; count表示当前层还有几个节点没有遍历
        int num = 0, count = 1;
        // flag==false表示当前层是奇数层; flag==true表示当前层是偶数层; 约定: root是奇数层
        boolean flag = false;
        //创建双端队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        //加入root
        queue.add(root);
        TreeNode cur;
        while(!queue.isEmpty()){
            if(!flag){
                //奇数层:弹出队首元素; 左孩子先加入队尾,右孩子后加入队尾
                cur = queue.pollFirst();
                tmp.add(cur.val);
                if(cur.left != null){
                    queue.addLast(cur.left);
                    num++;
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                    num++;
                }
            } else {
                //偶数层:弹出队尾元素; 右孩子先加入队首,左孩子后加入队首
                cur = queue.pollLast();
                tmp.add(cur.val);
                if(cur.right != null){
                    queue.addFirst(cur.right);
                    num++;
                }
                if(cur.left != null){
                    queue.addFirst(cur.left);
                    num++;
                }
            }
            count--;
            if(count == 0){
                count = num;
                num = 0;
                flag = !flag;
                res.add(new ArrayList<Integer>(tmp));
                tmp.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);
        Solution solution = new Solution();
        List<List<Integer>> listList = solution.zigzagLevelOrder(root);
        System.out.println(listList);

    }
}
