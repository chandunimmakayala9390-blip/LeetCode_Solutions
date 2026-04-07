class Robot {
    int w=0;
    int h=0;
    int x=0,y=0;
    String head="East";
    public Robot(int width, int height) {
        w=width;
        h=height;
    }
    
    public void step(int num) {
        int perimeter = 2 * (w + h - 2);
        num = num % perimeter;

        // special case
        if (num == 0 && x == 0 && y == 0) {
            head = "South";
            return;
        }
         for (int i = 0; i < num; i++) {

        while (true) {

            if (head.equals("East")) {
                if (x < w - 1) {
                    x++;
                    break;
                } else head = "North";
            }

            else if (head.equals("North")) {
                if (y < h - 1) {
                    y++;
                    break;
                } else head = "West";
            }

            else if (head.equals("West")) {
                if (x > 0) {
                    x--;
                    break;
                } else head = "South";
            }

            else if (head.equals("South")) {
                if (y > 0) {
                    y--;
                    break;
                } else head = "East";
            }
        }
    }
}
    
    public int[] getPos() {
        int res[]=new int[2];
        res[0]=x;
        res[1]=y;
        return res;
    }
    
    public String getDir() {
        return head;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */