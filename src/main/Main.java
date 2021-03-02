package main;

/*
    Сделать рефакторинг:
    разбить приложение на Вид Модель Контроллер
    точка входа приложения - это Вид, так как будем делать оконное приложение
    Контроллер можно сделать не статическим, Вид должен быть изолирован от Модели,
    М-ца не должна храниться в Виде.

    Для себя:
    навести порядок в контроллере - сделать красивее код, убрать ненужный код, упростить некоторые функции
    Вытащить оттуда неподходящие функции.

    Приложение работает, но нужно навести порядок в архитектуре.

* */



public class Main {
    public static void main(String[] args) {
        final int W = 20;
        final int H = 20;
        int[][] initCells = new int[H][W];

        // cycle
        initCells[5][2] = 1;
        initCells[5][3] = 1;
        initCells[5][4] = 1;
        initCells[1][0] = 1;
        initCells[2][0] = 1;
        initCells[3][0] = 1;

        //glider
        initCells[9][3] = 1;
        initCells[10][3] = 1;
        initCells[11][3] = 1;
        initCells[11][2] = 1;
        initCells[10][1] = 1;


        GameController.getInitCells(initCells);

        for(int i=0; i<20 && !GameController.isEnd(); ++i){
            System.out.println(i+1 + ")");
            GameController.PrintField();
            GameController.generateNextG();
            System.out.println();
        }

    }
}
