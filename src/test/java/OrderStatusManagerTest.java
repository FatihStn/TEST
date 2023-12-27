package test.java;

import main.java.OrderStatusManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderStatusManagerTest {
    OrderStatusManager orderStatusManagerTest = new OrderStatusManager();

   static int testCaseNumber = 0;

    @BeforeAll
    static void start(){
        System.out.println("--------Test started--------");
    }
    @BeforeEach
    void caseStart(){
        testCaseNumber++;
        System.out.println("Test case " + testCaseNumber + " started.");
    }
    @AfterEach
    void caseFinish(){
        System.out.println("Test case " + testCaseNumber + " finished.");

    }
    @AfterAll
    static void finish(){
        System.out.println("--------Test finished--------");

    }
    @Test
    void nextStepTestForNewToPending(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.nextState(OrderStatusManager.OrderState.NEW);
        assertEquals(OrderStatusManager.OrderState.PENDING,result);
    }
    @Test
    void nextStepTestForPendingToShipped(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.nextState(OrderStatusManager.OrderState.PENDING);
        assertEquals(OrderStatusManager.OrderState.SHIPPED,result);
    }
    @Test
    void nextStepTestForShippedToDelivered(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.nextState(OrderStatusManager.OrderState.SHIPPED);
        assertEquals(OrderStatusManager.OrderState.DELIVERED,result);
    }
    @Test
    void noTransitionFromDeliveredState(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.nextState(OrderStatusManager.OrderState.DELIVERED);
        assertEquals(OrderStatusManager.OrderState.DELIVERED,result);
    }
    @Test
    void noTransitionFromCanceledState(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.nextState(OrderStatusManager.OrderState.CANCELLED);
        assertEquals(OrderStatusManager.OrderState.CANCELLED,result);
    }
    @Test
    void cancelOrderForNewState(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.cancelOrder(OrderStatusManager.OrderState.NEW);
        assertEquals(OrderStatusManager.OrderState.CANCELLED,result);
    }
    @Test
    void cancelOrderForPendingState(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.cancelOrder(OrderStatusManager.OrderState.PENDING);
        assertEquals(OrderStatusManager.OrderState.CANCELLED,result);
    }
    @Test
    void cancelOrderForShippedState(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.cancelOrder(OrderStatusManager.OrderState.SHIPPED);
        assertEquals(OrderStatusManager.OrderState.SHIPPED,result);
    }
    @Test
    void cancelOrderForDeliveredState(){
        OrderStatusManager.OrderState result=orderStatusManagerTest.cancelOrder(OrderStatusManager.OrderState.CANCELLED);
        assertEquals(OrderStatusManager.OrderState.CANCELLED,result);
    }









}
