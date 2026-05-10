package snakeFoodGame;

import java.util.Random;

public class SnakeGame {
    
    private Board board;
    private Snake snake;
    private Food food;
    boolean gameOver;

    public SnakeGame(int width, int height){

        board = new Board(width, height);

        Position start = new Position(height / 2, width / 2);

        this.snake = new Snake(start);

        generateFood();
    }

    public boolean move(Direction direction) {

        if(gameOver) {
            throw new IllegalStateException("Game already finished");
        }

        Position head = snake.getHeadPosition();
        Position next = nextPosition(head, direction);

        if(!board.isValid(next) || snake.contains(next)) {
            gameOver = true;
            return false;
        }

        boolean grow = next.equals(food.getPosition());

        snake.move(next, grow);

        if(grow) {
            generateFood();
        }

        return true;
    }

      private Position nextPosition(Position head, Direction direction) {

        int row = head.getRow();
        int col = head.getCol();

        switch(direction) {
            case UP: row--; break;
            case DOWN: row++; break;
            case LEFT: col--; break;
            case RIGHT: col++; break;
        }

        return new Position(row, col);
    }

    private void generateFood() {

        Random random = new Random();

        int row = random.nextInt(boardHeight());
        int col = random.nextInt(boardWidth());

        food = new Food(new Position(row, col));
    }

    private int boardWidth() {
        return 10;
    }

    private int boardHeight() {
        return 10;
    }
    
}
