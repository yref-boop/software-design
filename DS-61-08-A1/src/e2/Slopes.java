package e2;

class Slopes {

    //Define public variables for:
    public char[][] Map; //The current map
    public static int[] size = {1, 1}; //The size of the map
    public static int[] pos = {0, 0}; //The current position of the map
    public static int trees; //The trees the skier has collided with

    public static void PrepareSlope(char[][] slopeMap, int right, int down) {
        //It resets every public map variable for a function and checks for exceptions if any
        size[0] = slopeMap[1].length - 1;
        size[1] = slopeMap[0].length - 1;

        if ((size[0] != size[1]) || (size[0] <= 1))
            throw new IllegalArgumentException("The map dimensions are not valid");

        if ((right > size[0]) || (down > size[1]) || (right <= 0) || (down <= 0))
            throw new IllegalArgumentException("The movement of the skier is not valid");

        pos[0] = pos[1] = trees = 0;


    }

    public static void CollisionDetected(char[][] slopeMap) {
        //Checks if there is a tree in the current position and finds exceptions
        if (slopeMap[pos[1]][pos[0]] != '#') {
            if (slopeMap[pos[1]][pos[0]] != '.') //If the character is not permitted
                throw new IllegalArgumentException(slopeMap[pos[1]][pos[0]] + "is not a valid character in the map");
        } else
            trees ++;
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way.
     * @param slopeMap A square matrix representing the slope with spaces
     * represented as "." and trees represented as "#".
     * @param right Movement to the right
     * @param down Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because:
     * - It is not square.
     * - It has characters other than "." and "#"
     * - right >= number of columns or right < 1
     * - down >= number of rows of the matrix or down < 1
     */

    public static int downTheSlope(char[][] slopeMap, int right, int down) {

        PrepareSlope(slopeMap, right, down);
        boolean finish = false; //To finish the while loop when necessary

        while (!finish) {

            for (int i = 0; i != right; i++) {

                CollisionDetected(slopeMap); //Detect collisions when going to the right

                if (pos[0] == size[0])
                    pos[0] -= size[0]; //Check if out of bounds and restart the x position
                else
                    pos[0] ++; //Go to the right
            }

            for (int i = 0; (i != down) && (!finish); i++) {

                CollisionDetected(slopeMap); //Detect collisions when going down

                if (pos[1] == size[1]) //If skier ended, finish function
                    finish = true;
                else
                    pos[1] ++; //Go down
            }
        }
        return trees;
    }
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way.
     * Since it "jumps" from the initial position to the final position ,
     * only takes into account the trees on those initial/final positions.
     *
     * Params , return value and thrown expections as in downTheSlope ...
     */
    public static int jumpTheSlope(char[][] slopeMap, int right, int down) {

        PrepareSlope(slopeMap, right, down);

        boolean finish = false; //To finish the while loop when necessary

        while (!finish) {

            for (int i = 0; i != right; i ++) {
                if (pos[0] == size[0])
                    pos[0] -= size[0]; //Check if out of bounds and restart the x position
                else
                    pos[0] ++; //Go to the right
            }

            for (int i = 0; (i != down) && (!finish); i ++) {
                if (pos[1] == size[1]) //If skier ended, finish function
                    finish = true;
                else
                    pos[1]++; //Go down
            }
            if (!finish) CollisionDetected(slopeMap); //Detect collision in current position
        }
        return trees;
    }
    public Slopes(char[][] Map) { this.Map = Map; } //Constructor for a map
}