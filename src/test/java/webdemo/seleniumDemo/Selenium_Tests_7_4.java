package webdemo.seleniumDemo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Selenium_Tests_7_4 {
    private static WebDriver driver;
    private String username = "testuser";
    private String password = "testpassword";

    @BeforeAll
    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://www.browserstack.com/users/sign_in");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testSuccessfulLogin() {
        driver.findElement(By.id("user_email_login")).sendKeys(username);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("user_submit")).click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.browserstack.com/users/sign_in";
        Assertions.assertEquals(actualUrl, expectedUrl);
    }
}
