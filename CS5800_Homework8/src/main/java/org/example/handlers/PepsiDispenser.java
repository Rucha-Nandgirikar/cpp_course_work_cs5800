package org.example.handlers;

import org.example.Snack;
import org.example.VendingMachine;

public class PepsiDispenser extends SnackDispenseHandler {
    @Override
    public void handleRequest(VendingMachine machine, Snack selectedSnack, double insertedMoney) {
        if (selectedSnack.getName().equalsIgnoreCase("Pepsi")) {
            if (selectedSnack.getQuantity() > 0 && insertedMoney >= selectedSnack.getPrice()) {
                selectedSnack.dispense();
                System.out.println("Dispensed: Pepsi");
                machine.returnChange(insertedMoney - selectedSnack.getPrice());
            } else {
                System.out.println("Cannot dispense Pepsi. Check if enough money is inserted or if it's out of stock.");
            }
        } else if (nextHandler != null) {
            nextHandler.handleRequest(machine, selectedSnack, insertedMoney);
        }
    }
}
