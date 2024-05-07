package org.example.handlers;

import org.example.Snack;
import org.example.VendingMachine;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CheetosDispenserTest {

    private VendingMachine machine;
    private Snack cheetos;
    private CheetosDispenser dispenser;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
        cheetos = new Snack("Cheetos", 1.50, 5);
        machine.getSnacks().put("Cheetos", cheetos); // Assuming VendingMachine has a method to get Snacks map
        dispenser = new CheetosDispenser();
        dispenser.setNextHandler(null); // No next handler for simplification in tests
    }

    @Test
    public void testDispenseCheetosSufficientFundsAndStock() {
        dispenser.handleRequest(machine, cheetos, 2.00);
        assertEquals(4, cheetos.getQuantity(), "Cheetos quantity should decrement by 1");
        assertEquals(0.50, machine.getInsertedMoney(), "Change should be returned correctly");
    }

    @Test
    public void testDispenseCheetosInsufficientFunds() {
        dispenser.handleRequest(machine, cheetos, 1.00);
        assertEquals(5, cheetos.getQuantity(), "Cheetos quantity should remain the same");
        assertEquals(1.00, machine.getInsertedMoney(), "Inserted money should not change");
    }

    @Test
    public void testDispenseCheetosOutOfStock() {
        cheetos = new Snack("Cheetos", 1.50, 0); // Set quantity to 0
        machine.getSnacks().put("Cheetos", cheetos);
        dispenser.handleRequest(machine, cheetos, 2.00);
        assertEquals(0, cheetos.getQuantity(), "Cheetos quantity should still be 0");
        assertEquals(2.00, machine.getInsertedMoney(), "Inserted money should be returned if out of stock");
    }

}