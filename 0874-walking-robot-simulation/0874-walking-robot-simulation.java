class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int head = -1; // -1=N, 1=E, 2=S, -2=W
        int maxDist = 0;

        for (int cmd : commands) {

            // turn right
            if (cmd == -1) {
                if (head == -1) head = 1;
                else if (head == 1) head = 2;
                else if (head == 2) head = -2;
                else if (head == -2) head = -1;
            }

            // turn left
            else if (cmd == -2) {
                if (head == -1) head = -2;
                else if (head == -2) head = 2;
                else if (head == 2) head = 1;
                else if (head == 1) head = -1;
            }

            // move forward
            else {
                for (int step = 0; step < cmd; step++) {

                    int nx = x, ny = y;

                    if (head == -1) ny++;      // North
                    else if (head == 1) nx++;  // East
                    else if (head == 2) ny--;  // South
                    else if (head == -2) nx--; // West

                    boolean blocked = false;

                    // check all obstacles
                    for (int[] obs : obstacles) {
                        if (obs[0] == nx && obs[1] == ny) {
                            blocked = true;
                            break;
                        }
                    }

                    if (blocked) break;

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}