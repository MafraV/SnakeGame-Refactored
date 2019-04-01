package snake.Command;

import snake.Snake;

public class RightCommand implements Command{

    public void execute(Snake snake){
        snake.setDxDy(snake.getHeadSize(), 0);
    }
}
