package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectAndInsertMoney("Coke", 2.0);
        vendingMachine.selectAndInsertMoney("Pepsi", 1.0);
        vendingMachine.selectAndInsertMoney("Cheetos", 2.5);
        vendingMachine.selectAndInsertMoney("Doritos", 2.0);
        vendingMachine.selectAndInsertMoney("KitKat", 1.2);
        vendingMachine.selectAndInsertMoney("Snickers", 1.3);
        vendingMachine.selectAndInsertMoney("Snickers", 1.3);
    }
}