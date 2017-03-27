package mapper;
/**
 * Made by Sam Spence on 2017/03/7
 * A grid of nodes
 */
public class Grid
{
    private static final int SIZE = 10;

    private Node[][] grid;

    public Grid()
    {
        grid = new Node[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++)
        {
            for(int j = 0; j < SIZE; j++)
            {
                grid[i][j] = new Node();
            }
        }
    }

    public String toString() {
        String temp = "";
        for(int i = 0; i < SIZE; i++)
        {
            for(int j = 0; j < SIZE; j++)
            {
                temp += grid[i][j].sayType() + " ";
            }
            temp += "\n";
        }
        return temp;
    }


    // Getters

    public int getSize()
    {
        return SIZE;
    }

    public String sayType(int x, int y)
    {
        return grid[x][y].sayType();
    }

    public int getType(int x, int y)
    {
        return grid[x][y].getType();
    }

    public Node getNode(int x, int y)
    {
        return grid[x][y];
    }

    public Node[] getNodes()
    {
        Node[] temp = new Node[SIZE * SIZE];
        System.arraycopy(grid, 0, temp, 0, SIZE * SIZE);

        return temp;
    }


    // Setters

    /**
     * @param x Row of the node
     * @param y Column of the node
     * @param type The type of node it will be set to (-1 to 2)
     */
    public void setType(int x, int y, int type)
    {
        grid[x][y].setType(type);
    }

    /**
     * @param x Row of the node to select
     * @param y Column of the node to select
     * @param other The node which to connect to the selected node
     */
    public void addConnection(int x, int y, Node other)
    {
        grid[x][y].addConnection(other);
    }


    // Misc

    /**
     * @param str An array of strings where each string is a row
     * @return A grid that matches the array of strings
     */
    public static Grid makeFromText(String[] str)
    {
        Grid a = new Grid();
        String s;
        char c;
        int l;
        for(int i = 0; i < str.length; i++)
        {
            s = str[i];
            for(int j = 0; j < s.length(); j++)
            {
                l = j;
                c = Character.toUpperCase(s.charAt(j));
                if(c == ' ') {
                    l--;
                } else if(c == 'S') {
                    a.setType(i, l, 0);
                } else if(c == 'M') {
                    a.setType(i, l, 1);
                } else if(c == 'E') {
                    a.setType(i, l, 2);
                }
            }
        }
        return a;
    }
}
