package main;

/**
 Задачи:
    * Проверка будет ли клетка жить
    * Должна ли клетка умереть
    * Должна ли клетка родиться
 * */

class CellController {

    private int[][] curGen;
    private int[][] nextGen;

    CellController(int[][] curGen){
        this.curGen = curGen;
//        this.nextGen = nextGen;
    }

    int validateLife(int n_cnt){
        if (n_cnt < 2 || n_cnt > 3)
            return 0;
        return 1;
    }

    int generateCell(int n_cnt){
        if (n_cnt == 3)
            return 1;
        return 0;
    }


}
