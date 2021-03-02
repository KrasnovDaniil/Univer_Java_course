package main;

class GameController {

    private static final int W = 20;
    private static final int H = 20;
    private static boolean isEnd = false;
    private static int[][] curField = new int[H][W];
    private static int[][] nextGen = new int[H][W];

    private static final CellController cellController = new CellController(curField);


    static void getInitCells(int[][] initCells){
        curField = initCells;
//        for(int[] cell: initCells){
//            curField[cell[1]][cell[0]] = 1;
//        }
    }


    static void generateNextG(){
        int cnt_nbrs;
        isEnd = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                cnt_nbrs = countNeighbors(i, j);
                if(curField[i][j] == 1) {
                    nextGen[i][j] = cellController.validateLife(cnt_nbrs);
                    isEnd = false;
                }
                else
                    nextGen[i][j] = cellController.generateCell(cnt_nbrs);
            }
        }
        // Swap
        int[][] t = nextGen;
        nextGen = curField;
        curField = t;
        nextGen = new int[H][W];
    }


    private static int countNeighbors(int i1, int j1){
        int cnt = 0;
        if (curField[i1][j1] == 1) cnt =-1;
        int i_top = Math.max(0, i1-1);
        int j_left = Math.max(0, j1-1);
        for(int i = i_top; i < H && i < i1+2; ++i){
            for(int j = j_left; j < W && j < j1+2; ++j){
                if(curField[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }


    static void PrintField(){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(curField[i][j] == 1)
                    System.out.print("#");
                else
                    System.out.print("-");
            }
            System.out.println();
        }
    }


    static boolean isEnd(){
        return isEnd;
    }

}
