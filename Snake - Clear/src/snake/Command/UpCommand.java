package snake.Command;

import snake.Snake;

public class UpCommand implements Command{

    public void execute(Snake snake){
        snake.setDxDy(0, snake.getDy() - snake.getHeadSize());
    }
}
