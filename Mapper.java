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

    public String toString() { return map.toString(); }


    // Getters

    /**
     * @return The queue of nodes to path through
     */
    public Node[] getQueue() { return queue; }

    public Grid get() { return map; }


    // Setters


    // Misc

    public Node[] makePath()
    {
        //updateQueue();
        Node[] newQueue = new Node[queue.length];

        // Put the start at the start of the queue
        Node start = queue[0];
        Node end = queue[0];
        for(Node i: queue)
        {
            if(i.getType() == 0)
                start = i;
            if(i.getType() == 2)
                end = i;
        }
        newQueue[0] = start;



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
