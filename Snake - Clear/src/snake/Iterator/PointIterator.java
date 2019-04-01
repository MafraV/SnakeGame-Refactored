package snake.Iterator;

import java.awt.*;
import java.util.ArrayList;

public class PointIterator implements Iterator {

    ArrayList<Point> points;
    int position = 0;

    public PointIterator (ArrayList<Point> points){
        this.points = points;
    }

    public Point next(){
        Point point = points.get(position);
        position++;
        return point;
    }

    public boolean hasNext(){
        if(position >= points.size() || points.get(position) == null){
            return false;
        } else {
            return true;
        }
    }

    public void resetPosition(){
        position = 0;
    }

    public int getSize(){
        return points.size();
    }

    public void remove(int index){
        points.remove(index);
    }
}
