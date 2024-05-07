package org.example.stateOfVendingMachine;

import org.example.*;

class DispensingState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Currently dispensing another snack.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Already have enough money. Dispensing snack.");
    }

    @Override
    public void dispenseSnack() {
        Snack snack = vendingMachine.getSelectedSnack();
        if (vendingMachine.getInsertedMoney() >= snack.getPrice()) {
            snack.dispense();
            System.out.println("Dispensed: " + snack.getName());
            vendingMachine.setInsertedMoney(vendingMachine.getInsertedMoney() - snack.getPrice());
            vendingMachine.setState(new IdleState(vendingMachine));
        } else {
            System.out.println("Not enough money inserted.");
            vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
        }
    }
}