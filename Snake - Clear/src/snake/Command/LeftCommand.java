package snake.Command;

import snake.Snake;

public class LeftCommand implements Command {

    public void execute(Snake snake){
        snake.setDxDy(snake.getDx() - snake.getHeadSize(), 0);
    }
}
