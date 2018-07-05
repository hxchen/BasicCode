package copyComplexList;

import org.junit.Test;

/**
 * 复杂链表的复制
 * 题目：请实现函数ComplexListNode* Clone(ComplexListNode head)，复
 * 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 * Created by hxchen on 2018/7/5.
 */
public class CopyComplexList {
    static class ComplexListNode{

        int value;
        ComplexListNode next;
        ComplexListNode sibiling;

        public ComplexListNode(){
        }

        public ComplexListNode(int value){
            this.value = value;
        }

        public static void BuildNodes(ComplexListNode node, ComplexListNode next, ComplexListNode sibiling){
            if (node != null){
                node.next = next;
                node.sibiling = sibiling;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("value = " + value);
            sb.append(", next = " + (next == null ? "null" : next.value));
            sb.append(", sibiling = " + (sibiling == null ? "null" : sibiling.value));
            return sb.toString();
        }

    }

    /**
     * 复制原始链表的任意节点N并创见新节点N',再把N'链接到N的后面
     * @param head
     */
    public static void copyList(ComplexListNode head){

        ComplexListNode node = head;
        while(node != null){

            ComplexListNode copyNode = new ComplexListNode();
            copyNode.value = node.value;
            copyNode.next = node.next;
            copyNode.sibiling = null;

            node.next = copyNode;
            node = copyNode.next;
        }


    }

    /**
     * 设置复制出来的节点的sibiling
     * @param head
     */
    public static void setSibiling(ComplexListNode head){
        ComplexListNode node = head;
        while(node != null){
            ComplexListNode copyNode = node.next;
            if(node.sibiling != null){
                copyNode.sibiling = node.sibiling.next;
            }
            node = copyNode.next;
        }
    }

    /**
     * 长链表拆分成两个链表
     * @param head
     * @return
     */
    public static ComplexListNode disConnectList(ComplexListNode head){
        ComplexListNode node = head;
        ComplexListNode copyHead = null;
        ComplexListNode copyNode = null;

        if(node != null){
            copyHead = node.next;
            copyNode = node.next;
            node.next = copyNode.next;
            node = node.next;
        }

        while(node != null){

            copyNode.next = node.next;
            copyNode = copyNode.next;

            node.next = copyNode.next;
            node = node.next;
        }

        return copyHead;
    }

    /**
     * 打印复杂链表
     * @param head
     */
    public static void PrintList(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            System.out.format("The value of this node is: %d.\n", node.value);

            if (node.sibiling != null)
                System.out.format("The value of its sibling is: %d.\n", node.sibiling.value);
            else
                System.out.print("This node does not have a sibling.\n");

            System.out.println("\n");

            node = node.next;
        }
    }
    /**
     * 复制复制链表
     * @param head
     * @return
     */
    public static ComplexListNode Clone(ComplexListNode head){
        copyList(head);
        setSibiling(head);
        return disConnectList(head);
    }


    // ====================测试代码====================

    public void Test(String testName, ComplexListNode head) {
        if(testName != null)
            System.out.format("%s begins:\n", testName);

        System.out.print("The original list is:\n");
        PrintList(head);

        ComplexListNode clonedHead = Clone(head);

        System.out.print("The cloned list is:\n");
        PrintList(clonedHead);
    }

    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //  |       |      /|\             /|\
    //  --------+--------               |
    //          -------------------------
    @Test
    public void Test1() {
        ComplexListNode pNode1 = new ComplexListNode(1);
        ComplexListNode pNode2 = new ComplexListNode(2);
        ComplexListNode pNode3 = new ComplexListNode(3);
        ComplexListNode pNode4 = new ComplexListNode(4);
        ComplexListNode pNode5 = new ComplexListNode(5);

        ComplexListNode.BuildNodes(pNode1, pNode2, pNode3);
        ComplexListNode.BuildNodes(pNode2, pNode3, pNode5);
        ComplexListNode.BuildNodes(pNode3, pNode4, null);
        ComplexListNode.BuildNodes(pNode4, pNode5, pNode2);

        Test("Test1", pNode1);
    }

    // m_pSibling指向结点自身
    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //         |       | /|\           /|\
    //         |       | --             |
    //         |------------------------|
    @Test
    public void Test2() {
        ComplexListNode pNode1 = new ComplexListNode(1);
        ComplexListNode pNode2 = new ComplexListNode(2);
        ComplexListNode pNode3 = new ComplexListNode(3);
        ComplexListNode pNode4 = new ComplexListNode(4);
        ComplexListNode pNode5 = new ComplexListNode(5);

        ComplexListNode.BuildNodes(pNode1, pNode2, null);
        ComplexListNode.BuildNodes(pNode2, pNode3, pNode5);
        ComplexListNode.BuildNodes(pNode3, pNode4, pNode3);
        ComplexListNode.BuildNodes(pNode4, pNode5, pNode2);

        Test("Test2", pNode1);
    }

    // m_pSibling形成环
    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //          |              /|\
    //          |               |
    //          |---------------|
    @Test
    public void Test3()
    {
        ComplexListNode pNode1 = new ComplexListNode(1);
        ComplexListNode pNode2 = new ComplexListNode(2);
        ComplexListNode pNode3 = new ComplexListNode(3);
        ComplexListNode pNode4 = new ComplexListNode(4);
        ComplexListNode pNode5 = new ComplexListNode(5);

        ComplexListNode.BuildNodes(pNode1, pNode2, null);
        ComplexListNode.BuildNodes(pNode2, pNode3, pNode4);
        ComplexListNode.BuildNodes(pNode3, pNode4, null);
        ComplexListNode.BuildNodes(pNode4, pNode5, pNode2);

        Test("Test3", pNode1);
    }

    // 只有一个结点
    @Test
    public void Test4() {
        ComplexListNode pNode1 = new ComplexListNode(1);
        ComplexListNode.BuildNodes(pNode1, null, pNode1);

        Test("Test4", pNode1);
    }

    // 鲁棒性测试
    @Test
    public void Test5() {
        Test("Test5", null);
    }
}
