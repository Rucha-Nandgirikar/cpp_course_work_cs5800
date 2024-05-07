package org.example;

import org.example.handlers.*;
import org.example.stateOfVendingMachine.IdleState;
import org.example.stateOfVendingMachine.StateOfVendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine currentState;
    private Map<String, Snack> snacks = new HashMap<>();
    private Snack selectedSnack;
    private double insertedMoney = 0;

    private SnackDispenseHandler handler;

    public VendingMachine() {
        currentState = new IdleState(this);
        snacks = new HashMap<>();
        initializeSnacks();
        setupHandlers();

    }

    private void initializeSnacks() {
        snacks.put("Coke", new Snack("Coke", 1.25, 10));
        snacks.put("Pepsi", new Snack("Pepsi", 1.25, 10));
        snacks.put("Cheetos", new Snack("Cheetos", 1.50, 10));
        snacks.put("Doritos", new Snack("Doritos", 1.50, 10));
        snacks.put("KitKat", new Snack("KitKat", 1.00, 10));
        snacks.put("Snickers", new Snack("Snickers", 1.00, 0));  // No stock for Snickers
    }

    private void setupHandlers() {
        // Setting up the chain of responsibility
        SnackDispenseHandler cokeHandler = new CokeDispenser();
        SnackDispenseHandler pepsiHandler = new PepsiDispenser();
        SnackDispenseHandler cheetosHandler = new CheetosDispenser();
        SnackDispenseHandler doritosHandler = new DoritosDispenser();
        SnackDispenseHandler kitKatHandler = new KitKatDispenser();
        SnackDispenseHandler snickersHandler = new SnickersDispenser();

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitKatHandler);
        kitKatHandler.setNextHandler(snickersHandler);

        this.handler = cokeHandler;
    }

    public void returnChange(double change) {
        if (change > 0) {
            System.out.println("Returning change: $" + change);
        }
        insertedMoney = 0; // Reset after dispensing
        currentState = new IdleState(this); // Go back to idle state
    }

    public void selectAndInsertMoney(String snackName, double money) {
        Snack selectedSnack = snacks.getOrDefault(snackName, null);
        if (selectedSnack != null) {
            insertedMoney = money;
            handler.handleRequest(this, selectedSnack, insertedMoney);
        } else {
            System.out.println("Selected snack " + snackName + " not found.");
        }
    }
    public void dispenseSnack() {
        currentState.dispenseSnack();
    }

    public void setState(StateOfVendingMachine state) {
        this.currentState = state;
    }

    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public void setSelectedSnack(Snack selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public void setInsertedMoney(double insertedMoney) {
        this.insertedMoney = insertedMoney;
    }

    public Map<String, Snack> getSnacks() {
        return snacks;
    }
}

