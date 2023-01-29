package webdemo.seleniumDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Selenium_Tests_7_2 {

        private static WebDriver driver;

        @BeforeAll
        public static void setUpDriver(){
            System.setProperty("webdriver.msedge.driver", "resources/msedgedriver");
            EdgeOptions options = new EdgeOptions();
            options.setHeadless(true);

            driver = new EdgeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @BeforeEach
        public void setUp() throws Exception {
            driver.get("https://duckduckgo.com/");
        }

        @AfterAll
        public static void tearDown() throws Exception {
            driver.quit();
        }

        @org.junit.jupiter.api.Test
        public void testFirstQuestion(){
            driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");

            driver.findElement(By.id("search_button_homepage")).submit();


            WebElement results = driver.findElement(By.cssSelector(".results.js-results"));

            List<WebElement> resultList = results.findElements(By.tagName("div"));

            assertNotNull(resultList.get(0));
            assertNotNull(resultList.get(2));
        }


    @Test
        public void testSecondQuestion() {
            WebElement searchField = driver.findElement(By.id("search_form_input_homepage"));

            searchField.sendKeys("Selenium");

            searchField.submit();

        }

        @org.junit.jupiter.api.Test
        public void testThirdQuestion() {
            try {
                driver.findElement(By.id("non-existent-element"));
            } catch (NoSuchElementException e) {
                System.out.println("Nie znaleziono szukanego elementu");
            }
        }


}
