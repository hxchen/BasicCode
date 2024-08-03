package lonch.linkedlist;

import java.util.*;

/**
 * 1. 手写一个四向链表结构带泛型
 * 2. 然后写一个函数实现以下功能：
 * 2.1 输入参数int n，生成一个多维四向链表
 * 2.2 每个节点都有四个方向，如果有值就指向他，如果没有，就指向null
 * 2.3 任意节点出发，遍历整个链表
 * */
public class FourWayLinkedList <T>{

    class FourWayLinkedNode<T> {
        T data;
        FourWayLinkedNode<T> up;
        FourWayLinkedNode<T> down;
        FourWayLinkedNode<T> left;
        FourWayLinkedNode<T> right;

        FourWayLinkedNode(T data) {
            this.data = data;
            this.up = null;
            this.down = null;
            this.left = null;
            this.right = null;
        }
    }

    private FourWayLinkedNode<T> head;

    public FourWayLinkedNode<T> getHead() {
        return head;
    }

    /**
     * 生成一个多维四向链表
     * @param n
     * @return
     */
    public FourWayLinkedNode<T> generateFourWayLinkedList(int n, T initialValue) {
        if (n <= 0) return null;
        FourWayLinkedNode<T>[][] grid = new FourWayLinkedNode[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = new FourWayLinkedNode<>(initialValue);
                if(i > 0) {
                    grid[i][j].up = grid[i-1][j];
                    grid[i-1][j].down = grid[i][j];
                }
                if(j > 0){
                    grid[i][j].left = grid[i][j-1];
                    grid[i][j-1].right = grid[i][j];
                }
            }
        }
        head = grid[0][0];
        return head;
    }

    public List<List<FourWayLinkedNode<T>>> findAllShortestPaths(FourWayLinkedNode<T> start, FourWayLinkedNode<T> end) {
        List<List<FourWayLinkedNode<T>>> paths = new ArrayList<>();
        if (start == null || end == null) return paths;

        Queue<List<FourWayLinkedNode<T>>> queue = new LinkedList<>();
        Set<FourWayLinkedNode<T>> visited = new HashSet<>();

        queue.add(new ArrayList<>(Arrays.asList(start)));
        visited.add(start);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<FourWayLinkedNode<T>> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<FourWayLinkedNode<T>> path = queue.poll();
                FourWayLinkedNode<T> node = path.get(path.size() - 1);

                if (node == end) {
                    paths.add(path);
                    found = true;
                } else {
                    for (FourWayLinkedNode<T> neighbor : Arrays.asList(node.up, node.down, node.left, node.right)) {
                        if (neighbor != null && !visited.contains(neighbor)) {
                            List<FourWayLinkedNode<T>> newPath = new ArrayList<>(path);
                            newPath.add(neighbor);
                            queue.add(newPath);
                            levelVisited.add(neighbor);
                        }
                    }
                }
            }
            visited.addAll(levelVisited);
        }
        return paths;
    }

    private void printFourWayLinkedList(FourWayLinkedNode<T> node) {
        FourWayLinkedNode<T> row = node;
        printRow(row);
        FourWayLinkedNode<T> up = row.up, down = row.down;
        while(up != null) {
            printRow(up);
            up = up.up;
        }
        while (down != null) {
            printRow(down);
            down = down.down;
        }
    }

    /**
     * 打印本行
     * @param row
     */
    private void printRow(FourWayLinkedNode<T> row) {
        FourWayLinkedNode<T> col = row;
        System.out.print(col.data + " ");
        FourWayLinkedNode<T> left = col.left, right = col.right;
        while(left != null) {
            System.out.print(left.data + " ");
            left = left.left;
        }
        while(right != null) {
            System.out.print(right.data + " ");
            right = right.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FourWayLinkedList<Integer> fourWayLinkedList = new FourWayLinkedList<>();
        fourWayLinkedList.generateFourWayLinkedList(5, 0);
        fourWayLinkedList.printFourWayLinkedList(fourWayLinkedList.head.down);
    }
}
