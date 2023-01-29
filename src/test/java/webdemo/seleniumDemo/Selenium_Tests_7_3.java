package webdemo.seleniumDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Selenium_Tests_7_3 {


    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
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

    @Test
    public void testNumberOfLinks() {
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        assertTrue(links.size() > 0);
        System.out.println("Liczba linków na stronie: " + links.size());

    }

    @Test
    public void testNumberOfImages() {
        List<WebElement> images = driver.findElements(By.xpath("//img"));

        assertTrue(images.size() > 0);
        System.out.println("Liczba obrazów na stronie: " + images.size());

    }

    @Test
    public void testNavigatingLinks() {
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        int size = links.size();

        for (int i = 0; i <= size; i++) {
            if (!(links.get(i).getText().isEmpty())) {
                links.get(i).click();
                driver.navigate().back();
                links = driver.findElements(By.tagName("a"));
                size = links.size();
            }
        }
    }

    @Test
    public void testFormFields() {
        WebElement form = driver.findElement(By.xpath("(//form)[1]"));

        List<WebElement> formFields = form.findElements(By.xpath(".//input"));

        int numberOfFields = formFields.size();
        assertEquals(4, numberOfFields);
    }


}
