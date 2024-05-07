package org.example.handlers;

import org.example.Snack;
import org.example.VendingMachine;

public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(VendingMachine machine, Snack selectedSnack, double insertedMoney);
}