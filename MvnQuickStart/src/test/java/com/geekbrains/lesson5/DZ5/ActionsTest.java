package com.geekbrains.lesson5.DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ActionsTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String BASE_URL = "https://crossbrowsertesting.github.io/drag-and-drop.html";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");

        driver = new ChromeDriver(opt);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(BASE_URL);
    }


    // https://crossbrowsertesting.github.io/drag-and-drop.html
    @Test
    void dragAndDropTest() {
        actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable")))
                .build()
                .perform();
        Assertions.assertEquals(driver.findElement(By.id("droppable")).getText(), "Dropped!");
    }

    @Test
    void newTabTest() throws InterruptedException {
        driver.get("https://google.com");

        ((JavascriptExecutor)driver).executeScript("alert('text')");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://ya.ru");
        Thread.sleep(2000);

        driver.close();
        Thread.sleep(2000);
    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
