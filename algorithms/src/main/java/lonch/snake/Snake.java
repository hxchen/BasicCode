package lonch.snake;

public class Snake {
    Node head, tail;

    public Snake(int length) {
        for (int i = 0; i < length; i++) {
            Node node = new Node("body" + i);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        Node current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void eat(int position) {
        Node current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = null;
            } else {
                head = null;
            }
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
