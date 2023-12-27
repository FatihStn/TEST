package test.java;

import main.java.SubscriptionManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionManagerTest {

   SubscriptionManager subscriptionManager = new SubscriptionManager();
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
    public void testFreeTierEmailNotificationEnabledAutoRenewal() {
        String result = subscriptionManager.configureSubscription(SubscriptionManager.SubscriptionTier.FREE,
                SubscriptionManager.NotificationPreference.EMAIL,
                SubscriptionManager.AutoRenewal.ENABLED);

        assertEquals("Subscription Configured: Tier=FREE, Notification=EMAIL, " +
                "AutoRenewal=ENABLED", result);
    }

    @ParameterizedTest
    @CsvSource({"STANDARD, SMS, DISABLED",
            "PREMIUM, NONE, ENABLED",
            "FREE, SMS, DISABLED",
            "STANDARD, EMAIL, ENABLED",
            "PREMIUM, NONE, DISABLED"})
    void Test(SubscriptionManager.SubscriptionTier tier,
              SubscriptionManager.NotificationPreference notification,
              SubscriptionManager.AutoRenewal autoRenewal) {
        String result = "Subscription Configured: Tier=" + tier + ", Notification=" +
                notification + ", AutoRenewal=" + autoRenewal;

        assertEquals(result, subscriptionManager.configureSubscription(tier, notification, autoRenewal));
    }



}
