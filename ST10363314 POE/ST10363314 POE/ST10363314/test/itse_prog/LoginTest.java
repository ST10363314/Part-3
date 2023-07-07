/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

/*
package itse_prog;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest { 

    @Test
    public void testCheckUserNameValid() {
        Login login = new Login("ky_1", "Ch&&sec@ke99", "Kyle", "Smith");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserNameInvalid() {
        Login login = new Login("kyle", "Ch&&sec@ke99", "Kyle", "Smith");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        Login login = new Login("ky_1", "Ch&&sec@ke99", "Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        Login login = new Login("ky_1", "password", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUserValid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "Kyle", "Smith");
        assertEquals("User registered successfully!", login.registerUser());
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        Login login = new Login("kyle", "Ch&&sec@ke99", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted, please ensure that your,"
                    + " username contains an underscore and is no more than 5 characters in length.", login.registerUser());
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        Login login = new Login("kyl_1", "password", "Kyle", "Smith");
        assertEquals("Password is not correctly formatted, please ensure that the,"
                    + " password contains at least 8 characters, a capital letter, a number and a special character.", login.registerUser());
    }

    @Test
    public void testLoginUserValid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99"));
    }

    @Test
    public void testLoginUserInvalid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "Kyle", "Smith");
        assertFalse(login.loginUser("ky1e", "password"));
    }

    @Test
    public void testReturnLoginStatusValid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "Kyle", "Smith");
        assertEquals("Welcome Kyle Smith, it is great to see you again.", login.returnLoginStatus("kyl_1", "Ch&&sec@ke99"));
    }

    @Test
    public void testReturnLoginStatusInvalid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke9", "Kyle", "Smith");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus("kyle", "password"));
    }
}


*/