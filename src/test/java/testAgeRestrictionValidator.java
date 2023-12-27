package test.java;

import main.java.AgeRestrictionValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testAgeRestrictionValidator {
    AgeRestrictionValidator ageRestrictionValidator = new AgeRestrictionValidator();

    @Test
    void testAgeWithJustBelowMinimum(){
        boolean result = ageRestrictionValidator.isEligible(17);
        assertFalse(result);
    }
    @Test
    void testAtMinimumBoundary(){
        boolean result = ageRestrictionValidator.isEligible(18);
        assertTrue(result);
    }
    @Test
    void testAgeWithJustAboveMinimum(){
        boolean result = ageRestrictionValidator.isEligible(19);
        assertTrue(result);
    }
    @Test
    void testAgeWithJustBelowMaximum(){
        boolean result = ageRestrictionValidator.isEligible(64);
        assertTrue(result);
    }
    @Test
    void testAgeAtMaximumBoundary(){
        boolean result = ageRestrictionValidator.isEligible(65);
        assertTrue(result);
    }
    @Test
    void testAgeWithJustAboveMaximum(){
        boolean result = ageRestrictionValidator.isEligible(66);
        assertFalse(result);
    }
    @Test
    void testAgeWithExtremeLow(){
        boolean result = ageRestrictionValidator.isEligible(0);
        assertFalse(result);
    }
    @Test
    void testAgeWithExtremeHigh(){
        boolean result = ageRestrictionValidator.isEligible(100);
        assertFalse(result);
    }
}
