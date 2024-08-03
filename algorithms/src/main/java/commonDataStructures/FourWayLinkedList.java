package commonDataStructures;

public class FourWayLinkedList<T> {
    class FourWayNode<T> {
        T data;
        FourWayNode<T> up;
        FourWayNode<T> down;
        FourWayNode<T> left;
        FourWayNode<T> right;

        public FourWayNode(T data) {
            this.data = data;
            this.up = null;
            this.down = null;
            this.left = null;
            this.right = null;
        }
    }
    private FourWayNode<T> head;

    public FourWayNode<T> generateFourWayLinkedList(int n, T initialValue) {
        if (n <= 0) return null;

        FourWayNode<T>[][] grid = new FourWayNode[n][n];

        // 创建节点并连接
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new FourWayNode<>(initialValue);
                // 上下
                if (i > 0) {
                    grid[i][j].up = grid[i - 1][j];
                    grid[i - 1][j].down = grid[i][j];
                }
                // 左右
                if (j > 0) {
                    grid[i][j].left = grid[i][j - 1];
                    grid[i][j - 1].right = grid[i][j];
                }
            }
        }
        head = grid[0][0];
        return head;
    }

    // 其他可能的操作，如打印链表等，可以在这里添加
    public void printGrid() {
        if (head == null) return;

        FourWayNode<T> row = head;
        while (row != null) {
            FourWayNode<T> col = row;
            while (col != null) {
                System.out.print(col.data + " ");
                col = col.right;
            }
            System.out.println();
            row = row.down;
        }
    }

    public static void main(String[] args) {
        FourWayLinkedList<Integer> fourWayLinkedList = new FourWayLinkedList<>();
        fourWayLinkedList.generateFourWayLinkedList(3, 0);
        fourWayLinkedList.printGrid();
    }

}
