package org.example;


/**
 * Класс дверь, с двумя состояниеми.
 * Либо за дверью есть приз, либо нет.
 */
public class Door {

    private PresencePrize presencePrize;
    private int number;

    public Door(int number, PresencePrize presencePrize) {
        this.number = number;
        this.presencePrize = presencePrize;
    }

    public int getNumber() {
        return number;
    }

    public PresencePrize getPresencePrize() {
        return presencePrize;
    }
}

enum PresencePrize {
    YES, NO;
}