package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import org.example.stateOfVendingMachine.StateOfVendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VendingMachineTest {

    @Mock
    private StateOfVendingMachine idleState;

    @InjectMocks
    private VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        vendingMachine = new VendingMachine();
    }

    @Test
    public void testSelectAndInsertMoney_SnackNotAvailable() {
        // Setup
        double moneyInserted = 1.00;

        // Action
        vendingMachine.selectAndInsertMoney("Unknown Snack", moneyInserted);

        // Assertion
        assertEquals(0, vendingMachine.getInsertedMoney(), "No money should be recorded if snack is not found");
    }

    @Test
    public void testSelectAndInsertMoney_SnackAvailableButNotEnoughMoney() {
        // Setup
        double moneyInserted = 1.00; // Not enough for any snack priced above 1.00
        Snack snack = new Snack("Doritos", 1.50, 5);
        vendingMachine.getSnacks().put("Doritos", snack);

        // Action
        vendingMachine.selectAndInsertMoney("Doritos", moneyInserted);

        // Assertion
        assertEquals(moneyInserted, vendingMachine.getInsertedMoney(), "Money should still be recorded in the machine");
        verify(idleState, never()).dispenseSnack();
    }

    @Test
    public void testReturnChange() {
        // Setup
        double moneyInserted = 2.00; // Enough to trigger change return
        Snack snack = new Snack("Snickers", 1.00, 1);  // Setting stock to 1 to simulate stock running out
        vendingMachine.getSnacks().put("Snickers", snack);

        // Action
        vendingMachine.selectAndInsertMoney("Snickers", moneyInserted);
        vendingMachine.returnChange(moneyInserted - snack.getPrice());
    }
}

