package dynamicprogramming;

import org.junit.Test;

public class Q2RobotInAGrid {

    public void move(Position position, int r, int c) {

        System.out.println(position.toString());

        if (position.getX() == c - 1 && position.getY() == r - 1) {
            System.out.println("END");
            return;
        } else if (position.getX() == c - 1) {
            // move r
            position.setY(position.getY() + 1);
        } else if (position.getY() == r - 1) {
            // move c
            position.setX(position.getX() + 1);
        } else {
            // move randomly
            int rand = (int)Math.floor(Math.random() * 100);
            if (rand % 2 == 0)
                position.setX(position.getX() + 1);
            else
                position.setY(position.getY() + 1);
        }
        move(position, r, c);
    }

    class Position {
        private int x;
        private int y;

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return String.format("Position{x=%d, y=%d}", x, y);
        }
    }

    @Test
    public void testMove() {
        move(new Position(), 10, 20);
    }


}
