package org.example;


/**
 * Класс дверь, с двумя состояниеми.
 * Либо за дверью есть приз, либо нет.
 */
public class Door {

    private PresencePrize presencePrize;

    public Door(PresencePrize presencePrize) {
        this.presencePrize = presencePrize;
    }

    public PresencePrize getPresencePrize() {
        return presencePrize;
    }
}

enum PresencePrize {
    YES, NO;
}