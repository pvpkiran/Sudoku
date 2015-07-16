package com.app.pojo;

public enum MoveValidator {
    INVALID(-1),
    VALID(1),
    COMPLETE(0);

    MoveValidator(int move) {
        validateMove = move;
    }

    int validateMove;
}
