package org.example.stateOfVendingMachine;

import org.example.VendingMachine;
import org.example.stateOfVendingMachine.DispensingState;
import org.example.stateOfVendingMachine.StateOfVendingMachine;

public class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Snack already selected, please insert money.");
    }

    @Override
    public void insertMoney(double amount) {
        double total = vendingMachine.getInsertedMoney() + amount;
        vendingMachine.setInsertedMoney(total);
        System.out.println("Inserted money: $" + total);
        if (total >= vendingMachine.getSelectedSnack().getPrice()) {
            vendingMachine.setState(new DispensingState(vendingMachine));
        }
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please insert enough money.");
    }
}