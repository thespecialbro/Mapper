package mapper;
/**
 * Made by Sam Spence on 2017/03/7
 * Finds the shortest path to the end of a grid of nodes
 */
public class Mapper
{
    private Node[] queue;
    private Grid map;

    public Mapper()
    {
        map = new Grid();
        queue = new Node[map.getSize()];
    }

    /**
     * @param grid The grid to be used for the map (instead of creating a new one)
     */
    public Mapper(Grid grid)
    {
        map = grid;
        queue = new Node[map.getSize()];
    }

    public String toString()
    {
        return map.toString();
    }

    // Getters

    /**
     * @return The queue of nodes to path through
     */
    public Node[] getQueue()
    {
        //updateQueue();
        return queue;
    }

    /**
     * @param x x-coordinate of a node
     * @param y y-coordinate of a node
     * @return The node at (x, y) on the grid
     */
    public Node get(int x, int y)
    {
        return map.getNode(x, y);
    }


    // Setters

    /**
     * @param x x-coordinate of a node
     * @param y y-coordinate of a node
     * @param other The node which to connect to the selected node
     */
    public void addConnection(int x, int y, Node other)
    {
        map.addConnection(x, y, other);
    }

    /**
     * @param x x-coordinate of a node
     * @param y y-coordinate of a node
     * @param type The type to set the node to
     */
    public void setType(int x, int y, int type)
    {
        map.setType(x, y, type);
    }


    // Misc

    public Node[] makePath()
    {
        //updateQueue();
        /*for(Node i: queue)
        {

        }*/
        return queue;
    }

    /**
     * @param x1 x-coordinate of a node
     * @param y1 y-coordinate of a node
     * @param x2 x-coordinate of another node
     * @param y2 y-coordinate of another node
     * @return The distance between the two nodes
     */
    // Find the distance between two nodes on the grid
    public double distance(int x1, int y1, int x2, int y2)
    {
        double a = (double) x2 - x1;
        double b = (double) y2 - y1;
        return Math.abs(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
    }

    // Update the queue
    private void updateQueue()
    {
        int j = 0;
        for(Node i: map.getNodes())
        {
            if(i.getType() > -1)
            {
                queue[j] = i;
                j++;
            }
        }
    }
}