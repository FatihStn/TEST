package test.java;

import main.java.LoginValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginValidatorTest {
    LoginValidator loginValidator = new LoginValidator();

    @Test
    void testUserNameWithMailAddress(){
        boolean result=loginValidator.validateUsername("fatihsatan@gmail.com");
        assertTrue(result);
    }
    @Test
    void testUsernameWithoutSymbol(){
        boolean result = loginValidator.validateUsername("fatihsatangmail.com");
        assertFalse(result);
    }
    @Test
    void testUsernameWithoutDomain () {
        boolean result = loginValidator.validateUsername("fatihsatan");
        assertFalse(result);
    }
    @Test
    void testUsernameWithInvalidChars (){
        boolean result=loginValidator.validateUsername("fatih.satan.@gmail.com");
        assertFalse(result);
    }
    @Test
    void testUsernameWithEmpty (){
        boolean result=loginValidator.validateUsername("@gmail.com");
        assertFalse(result);
    }
    @Test
    void testUsernameWithEmptyEmail(){
        boolean result=loginValidator.validateUsername("");
        assertFalse(result);
    }
    @Test
    void testPasswordWithValidPassword(){
        boolean result=loginValidator.validatePassword("Fatihsatan07*");
        assertTrue(result);
    }
    @Test
    void testPasswordWithoutSpecialChar(){
        boolean result=loginValidator.validatePassword("Fatihsatan07");
        assertFalse(result);
    }
    @Test
    void testPasswordWithoutNumber(){
        boolean result=loginValidator.validatePassword("Fatihsatan*");
        assertFalse(result);
    }
    @Test
    void testPasswordWithShortPassword(){
        boolean result=loginValidator.validatePassword("Fan07*");
        assertFalse(result);
    }
    @Test
    void testPasswordWithLongPassword(){
        boolean result=loginValidator.validatePassword("Fatihsatanfatihsatanfatih07*");
        assertFalse(result);
    }
    @Test
    void testPasswordWithEmptyString(){
        boolean result=loginValidator.validatePassword("   ");
        assertFalse(result);
    }
    @Test
    void testPasswordWithNull(){
        boolean result=loginValidator.validatePassword("");
        assertFalse(result);
    }
}
