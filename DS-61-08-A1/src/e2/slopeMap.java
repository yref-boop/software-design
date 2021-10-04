package e2;

public class slopeMap {

    public char[][] Map;

    public static int downTheSlope(char[][] slopeMap, int right, int down) {

        int[] pos = {0, 0};
        int trees = 0;
        boolean finish = false;

        while (!finish) {

            for (int i = 0; i != right; i++) {

                if (slopeMap[pos[1]][pos[0]] == '#')
                    trees ++;

                if (pos[0] == 10)
                    pos[0] -= 10;
                else
                    pos[0] ++;
            }

            for (int i = 0; (i != down) && (!finish); i++) {
                if (slopeMap[pos[1]][pos[0]] == '#')
                    trees ++;

                if (pos[1] == 10)
                    finish = true;
                else
                    pos[1] ++;
            }
        }

        return trees;
    }

    public static int jumpTheSlope(char[][] slopeMap, int right, int down) {

            int[] pos = {0, 0};
            int trees = 0;
            boolean finish = false;

            while (!finish) {

                for (int i = 0; i != right; i ++) {
                    if (pos[0] == 10)
                            pos[0] -= 10;
                    else
                        pos[0] ++;
                }

                for (int i = 0; (i != down) && (!finish); i ++) {
                    if (pos[1] == 10)
                        finish = true;
                    else
                        pos[1]++;
                }

                if (slopeMap[pos[1]][pos[0]] == '#')
                    trees ++;
            }

            return trees;
    }


    public slopeMap (char[][] Map) { this.Map = Map; }

    public static void main(String[] args) {

        char[][] Map = {
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}
        };

        slopeMap slope = new slopeMap(Map);
        System.out.println(downTheSlope(Map, 3, 1) + "\n" + jumpTheSlope(Map, 3, 1));
    }
}
