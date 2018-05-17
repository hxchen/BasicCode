package printListInReversedOrder;

import java.util.Stack;

/**
 * Created by hxchen on 2018/5/17.
 */
public class ListNode<T> {
    public Node head;
    /**
     * 尾部插入
     * @param element
     */
    public void insert(T element){
        Node node = new Node(element);
        if(head == null){
            head = node;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    /**
     * 打印链表
     */
    public void print(Node head){
        System.out.print("PrintList:");
       if(head != null){
           Node current = head;
           while (current != null){
               System.out.print(current.value+"\t");
               current = current.next;
           }
           System.out.println("\n");
       }
    }

    /**
     * 遍历式反向输出
     */
    public void PrintListReversingly_Iteratively(Node head){
        Stack<Node> nodesStack = new Stack<Node>();
        Node current = head;
        while (current != null){
            nodesStack.push(current);
            current = current.next;
        }
        while (!nodesStack.isEmpty()){
            current = nodesStack.pop();
            System.out.print(current.value+"\t");
        }
        System.out.println("\n");
    }
    /**
     * 迭代式反向输出
     */
    public void PrintListReversingly_Recursively(Node head){
        Node current = head;
        if(current != null){
            if(current.next != null){
                PrintListReversingly_Recursively(current.next);
            }
            System.out.print(current.value+"\t");
        }
    }
}
