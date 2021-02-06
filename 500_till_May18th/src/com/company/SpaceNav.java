package com.company;

public class SpaceNav {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- >0){
            int x_final = in.readInt();
            int y_final = in.readInt();
            //double final_dist = distance(x_start, y_start, x_final, y_final);
            //double current_dist = 0;
            String orderStr = in.readLine();
            int x_start = 0, y_start = 0;
            if(x_final == 0 && y_final == 0){
                System.out.println("YES");
                continue;
            }
            for (int i = 0; i < orderStr.length(); i++) {
                char value = orderStr.charAt(i);

                //Brute force
                if(x_final> 0 && y_final > 0){
                    //in the first quadrant
                    if(value == 'U'){
                        y_start++;
                    }
                    if(value == 'R'){
                        x_start++;
                    }
                    continue;
                }

                if(x_final <0 && y_final >0){
                    //second
                    if(value == 'U') y_start++;
                    if(value == 'L') x_start--;
                    continue;
                }

                if(x_final<0 && y_final<0){
                    //third
                    if (value == 'D') y_start--;
                    if(value == 'L') x_start--;
                    continue;
                }

                if (x_final> 0 && y_final < 0){
                    //fourth quadrant
                    if(value == 'D')y_start--;
                    if(value == 'R') x_start++;
                }
            }
            if(x_final == x_start && y_final == y_start){
                System.out.println("YES");
            }else System.out.println("NO");
        }
//    private static double distance(int x1, int y1, int x2, int y2){
//        return Math.sqrt( ( (x1-x2)^2 ) + ( (y1 - y2)^2 ) );
    }
}
