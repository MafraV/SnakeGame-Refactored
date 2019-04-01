package snake.Command;

import snake.Snake;

public class DownCommand implements Command {

    public void execute(Snake snake){
        snake.setDxDy(0, snake.getHeadSize());
    }
}
