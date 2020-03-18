import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CreateAccountPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    @BeforeEach
    void openLoginPage() {
        loginPage.open();
    }

    @Test
    @DisplayName("Page Info")
    void checkPageInfo() {
        String expectedInfo = "LOGIN OR CREATE AN ACCOUNT";
        String actualInfo = loginPage.getPageInfo();
        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    @DisplayName("Page Title")
    void checkTitle() {
        String expectedTitle = "Customer Login";
        String actualTitle = loginPage.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @DisplayName("Go to create account page")
    void goToCreateAccount() {
        CreateAccountPage accountPage = loginPage.clickOnCreateAccountButton();
        assertEquals("Create New Customer Account", accountPage.getTitle());
    }

    @ParameterizedTest(name = "#{index} - Login with invalid creds")
    @ValueSource(strings = {
            "tlekeux1@plala.or.jp, NCmcrMcgWm3",
            "atiffin2@prlog.org, voPtaf-qezjih-hephy9",
            "lyonka1@mail.ru, LKBN5zCnY"
    })
    void loginWithInvalidCreds(String email, String password) {
        loginPage.fillOutEmailInput(email);
        loginPage.fillOutPasswordInput(password);
        loginPage.clickLogin();
        assertEquals("Invalid login or password.", loginPage.getInvalidMessage());
    }

    @ParameterizedTest(name = "#{index} - Login with empty data")
    @ValueSource(strings = {
            " , NCmcrMcgWm3",
            "atiffin2@prlog.org, ",
            " ,  "
    })
    void loginWithEmptyCreds(String email, String password) {
        loginPage.fillOutEmailInput(email);
        loginPage.fillOutPasswordInput(password);
        loginPage.clickLogin();
        assertEquals("This is a required field.", loginPage.getValidateMessage());
    }

}
