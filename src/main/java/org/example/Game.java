package org.example;

import java.util.HashMap;
import java.util.Random;

public class Game {

    private Door[] doors;
    private int countDoors, countGames;
    private HashMap<Integer, GameResult> resultMonti, resultSingleChoice;
    private Random random;


    public Game() {
        random = new Random();
        countDoors = 3;
        countGames = 1000;
        doors = new Door[countDoors];
        resultMonti = new HashMap<>();
        resultSingleChoice = new HashMap<>();
    }


    /**
     * Рграем 1000 раз, фиксируем результат и выводим его
     */
    public void start(){
        for (int i = 1; i <= countGames; i++) {
            createDoors();
            play(i);
        }
        showResult();
    }

    private void showResult(){
        System.out.println("Количество побед согласно парадокусу Монти: " +
                calcWin(resultMonti));
        System.out.println("Количество побед при одиночном выборе: " +
                calcWin(resultSingleChoice));
    }

    private int calcWin(HashMap<Integer, GameResult> map){

        int sum = 0;
        for (Integer i:map.keySet()) {
            if(map.get(i) == GameResult.WIN)
                sum++;
        }
        return sum;
    }

    private void play(int i){

        int choice = random.nextInt(countDoors);

        // если мы выбрали приз, то выиграли(один выбор)
        // или проиграли(по Монти)
        if(checkDoor(choice)){
            resultMonti.put(i, GameResult.LOS);
            resultSingleChoice.put(i, GameResult.WIN);
        } else {
            resultMonti.put(i, GameResult.WIN);
            resultSingleChoice.put(i, GameResult.LOS);
        }
    }

    private boolean checkDoor(int choice){
        return doors[choice].getPresencePrize() == PresencePrize.YES;
    }

    private void createDoors(){

        boolean f = true;

        for (int i = 0; i < countDoors; i++) {

            if(f && random.nextInt(countDoors) == 2){
                doors[i] = new Door(i+1, PresencePrize.YES);
                f = false;
            } else{
                doors[i] = new Door(i+1, PresencePrize.NO);
            }

            if(i == 2 && f){
                doors[i] = new Door(i+1, PresencePrize.YES);
            }
        }
    }
}

enum GameResult{
    WIN, LOS;
}
