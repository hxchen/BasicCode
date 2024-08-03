package lonch.snake;

import java.util.Random;

public class SnakeGame {
    public static void main(String[] args) {
        // 定义两条蛇
        Snake snake1 = new Snake(5);
        Snake snake2 = new Snake(5);

        Random random = new Random();

        // 游戏循环
        while (!snake1.isEmpty() && !snake2.isEmpty()) {
            // Snake 1 吃 Snake 2
            int position = random.nextInt(snake2.length());
            System.out.println("Snake 1 eats Snake 2 at position " + position);
            snake2.eat(position);
            snake2.display();

            if (snake2.isEmpty()) {
                System.out.println("Snake 1 wins!");
                break;
            }

            // Snake 2 吃 Snake 1
            position = random.nextInt(snake1.length());
            System.out.println("Snake 2 eats Snake 1 at position " + position);
            snake1.eat(position);
            snake1.display();

            if (snake1.isEmpty()) {
                System.out.println("Snake 2 wins!");
                break;
            }
        }
    }
}
