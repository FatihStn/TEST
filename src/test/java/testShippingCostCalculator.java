package test.java;

import main.java.ShippingCostCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testShippingCostCalculator {
    ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();

    @Test
    void testLocalDestinationWithStandardDelivery(){
        double weight=5;
        double result= shippingCostCalculator.calculateCost(weight,"local","standart");

        assertEquals((weight*1)*1,result,"Wrong");
    }
    @Test
    void testLocalDestinationWithExpressDelivery(){
        double weight=5;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }
    @Test
    void testInternationalDestinationWithStandardDelivery(){
        double weight=5;
        double result= shippingCostCalculator.calculateCost(weight,"international","standard");

        assertEquals((weight*5)*(1),result,"Wrong");
    }
    @Test
    void testInternationalDestinationWithExpressDelivery(){
        double weight=5;
        double result= shippingCostCalculator.calculateCost(weight,"international","express");

        assertEquals((weight*5)*(2.5),result,"Wrong");
    }
    @Test
    void testZeroWeightLocalStandardDelivery(){
        double weight=0;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals(weight,result,"Wrong");
    }
    @Test
    void testZeroWeightLocalExpressDelivery(){
        double weight=0;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }
    @Test
    void testZeroWeightInternationalStandardDelivery(){
        double weight=0;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }
    @Test
    void testZeroWeightInternationalExpressDelivery(){
        double weight=0;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }
    @Test
    void testNegativeWeightLocalStandardDelivery(){
        double weight=-5;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }
    @Test
    void testNegativeWeightLocalExpressDelivery(){
        double weight=-5;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }
    @Test
    void testNegativeWeightInternationalStandardDelivery(){
        double weight=-5;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }

    @Test
    void testNegativeWeightInternationalExpressDelivery(){
        double weight=-5;
        double result= shippingCostCalculator.calculateCost(weight,"local","express");

        assertEquals((weight*1)*(2.5),result,"Wrong");
    }
}

