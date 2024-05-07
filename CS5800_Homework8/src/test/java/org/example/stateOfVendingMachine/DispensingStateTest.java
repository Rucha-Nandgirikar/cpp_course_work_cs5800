package org.example.stateOfVendingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Snack;
import org.example.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class DispensingStateTest {

    @Mock
    private VendingMachine vendingMachine;

    @Mock
    private Snack selectedSnack;

    @InjectMocks
    private DispensingState dispensingState;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        dispensingState = new DispensingState(vendingMachine);

        // Default behavior of the vending machine mock
        when(vendingMachine.getSelectedSnack()).thenReturn(selectedSnack);
    }

    @Test
    public void testDispenseSnack_Success() {
        // Mock the selected snack price and quantity
        when(selectedSnack.getName()).thenReturn("Coke");
        when(selectedSnack.getPrice()).thenReturn(1.25);
        when(vendingMachine.getInsertedMoney()).thenReturn(2.00);

        // Act
        dispensingState.dispenseSnack();

        // Verify the dispense call and state transition
        verify(selectedSnack, times(1)).dispense();
        verify(vendingMachine, times(1)).setInsertedMoney(0.75);
        verify(vendingMachine, times(1)).setState(any(IdleState.class));
    }

    @Test
    public void testDispenseSnack_NotEnoughMoney() {
        // Set up not enough money
        when(selectedSnack.getPrice()).thenReturn(1.50);
        when(vendingMachine.getInsertedMoney()).thenReturn(1.00);

        // Act
        dispensingState.dispenseSnack();

        // Ensure the state transitions to waiting for money
        verify(vendingMachine, times(1)).setState(any(WaitingForMoneyState.class));
        verify(selectedSnack, never()).dispense();
    }

    @Test
    public void testSelectSnack() {
        dispensingState.selectSnack("Cheetos");
        verify(vendingMachine, never()).setSelectedSnack(any());
    }

    @Test
    public void testInsertMoney() {
        dispensingState.insertMoney(1.0);
        verify(vendingMachine, never()).setInsertedMoney(anyDouble());
    }
}
