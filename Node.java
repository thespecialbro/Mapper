package mapper;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Made by Sam Spence on 2017/03/7
 * A connection point which exists on the grid
 */
public class Node
{
    // Constants for the type value
    private static final int UNSET = -1;
    private static final int START = 0;
    private static final int MID = 1;
    private static final int END = 2;

    // Connections is what nodes come off of this one.
    // Nodes that are connecting into this one are not included.
    private ArrayList<Node> connections;
    private int type;

    Node()
    {
        connections = new ArrayList<>();
        type = UNSET;
    }

    public String toString()
    {
        String temp = String.format("%s type node", sayType());
        if(connections.size() > 0)
        {
            temp += String.format("\n\tconnected to %s", connections);
        }
        return temp;
    }


    // Getters

    int getType() {return type;}

    public ArrayList<Node> getConnections() {return connections;}


    // Setters

    /**
     * @param type What type of node this is
     */
    void setType(int type)
    {
        this.type = type;
    }

    /**
     * @param other The node which this one is connecting to
     */
    void addConnection(Node other)
    {
        connections.add(other);
    }


    // Misc

    /**
     * @return A letter for which type of node this is
     */
    String sayType()
    {
        String temp = "X";
        if(type == UNSET) {
             temp = "-";
        } else if(type == START) {
            temp = "S";
        } else if(type == MID) {
            temp = "M";
        } else if(type == END) {
            temp = "E";
        }
        return temp;
    }
}