package org.jetbrains.kotlinx.tictactoe;

public enum Mark {

    X,O,EMPTY;


    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        }else return this.name();
    }

}
