package lonch.snake;

public class Node {
    String name;
    Node prev, next;

    public Node(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}
