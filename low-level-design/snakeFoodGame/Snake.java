package snakeFoodGame;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class Snake {

    private Deque<Position> body;
    private Set<Position> bodySet;

    public Snake(Position start){

        body = new LinkedList<>();
        bodySet = new HashSet<>();

        body.addFirst(start);
        bodySet.add(start);
    }

    public Position getHeadPosition(){ 
        return body.peekFirst();
    }

    public boolean contains(Position pos){
        return bodySet.contains(pos);
    }

    public void move(Position newPosition, boolean grow){

        body.add(newPosition);
        bodySet.add(newPosition);

        if(!grow){
            Position tail = body.poll();
            bodySet.remove(tail);
        }
    }

}
