import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CreateAccountPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPageTest extends TestBase {
    LoginPage loginPage = demoSite.openLoginPage();

    @BeforeEach
    void openLoginPage() {
        demoSite.openLoginPage();
    }

    @Test
    @Order(1)
    @DisplayName("Page Info")
    void checkPageInfo() {
        String expectedInfo = "LOGIN OR CREATE AN ACCOUNT";
        String actualInfo = loginPage.getPageInfo();
        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    @Order(2)
    @DisplayName("page Title")
    void checkTitle() {
        String expectedTitle = "Customer Login";
        String actualTitle = loginPage.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @Order(3)
    @DisplayName("go to create account page")
    void goToCreateAccount() {
        CreateAccountPage accountPage = loginPage.clickOnCreateAccountButton();
        assertEquals("Create New Customer Account", accountPage.getTitle());
    }

    @ParameterizedTest(name = "#{index} - Login with invalid creds")
    @Order(4)
    @CsvSource({
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

    @Test
    @Order(5)
    @DisplayName("Login with empty data")
    void loginWithEmptyCreds() {
        loginPage.fillOutEmailInput(" ");
        loginPage.fillOutPasswordInput(" ");
        loginPage.clickLogin();
        assertEquals("This is a required field.", loginPage.getValidateMessage());
    }

    @ParameterizedTest(name = "#{index} - Success login")
    @Order(6)
    @CsvSource({
            "lyonka1@mail.ru, voPtaf-qezjih-hephy9"
    })
    void successLogin(String email, String password) {
        loginPage.fillOutEmailInput(email);
        loginPage.fillOutPasswordInput(password);
        loginPage.clickLogin();
        assertEquals("MY DASHBOARD", loginPage.getPageInfo());
    }
}
