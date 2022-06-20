package ibu.edu;

public class Node<Key extends Comparable<Key>, Value> {
    public int size = 1;
    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;
    public boolean color;

    public Node(Key key, Value value, boolean color){
        this.key = key;
        this.value = value;
        this.color = color;
    }
}
