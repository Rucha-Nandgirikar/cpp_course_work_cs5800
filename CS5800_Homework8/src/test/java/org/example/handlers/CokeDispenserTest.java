package org.example.handlers;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Snack;
import org.example.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.*;

public class CokeDispenserTest {

    @Mock
    private VendingMachine vendingMachine;

    @Mock
    private SnackDispenseHandler nextHandler;

    @InjectMocks
    private CokeDispenser cokeDispenser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cokeDispenser.setNextHandler(nextHandler);
    }

    @Test
    public void testHandleRequest_CorrectSnack() {
        Snack coke = new Snack("Coke", 1.50, 10);
        when(vendingMachine.getSnacks()).thenReturn(Map.of("Coke", coke));

        cokeDispenser.handleRequest(vendingMachine, coke, 2.00);

        verify(vendingMachine, times(1)).returnChange(0.50);
        verify(nextHandler, never()).handleRequest(any(VendingMachine.class), any(Snack.class), anyDouble());
    }

    @Test
    public void testHandleRequest_WrongSnack_PassToNextHandler() {
        Snack pepsi = new Snack("Pepsi", 1.50, 10);
        when(vendingMachine.getSnacks()).thenReturn(Map.of("Pepsi", pepsi));

        cokeDispenser.handleRequest(vendingMachine, pepsi, 2.00);

        verify(nextHandler, times(1)).handleRequest(vendingMachine, pepsi, 2.00);
    }

    @Test
    public void testHandleRequest_NotEnoughMoney() {
        Snack coke = new Snack("Coke", 2.00, 10);
        when(vendingMachine.getSnacks()).thenReturn(Map.of("Coke", coke));

        cokeDispenser.handleRequest(vendingMachine, coke, 1.50);

        verify(vendingMachine, never()).returnChange(anyDouble());
        verify(nextHandler, never()).handleRequest(any(VendingMachine.class), any(Snack.class), anyDouble());
    }
}
