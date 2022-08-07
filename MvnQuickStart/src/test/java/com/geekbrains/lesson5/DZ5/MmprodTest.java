package com.geekbrains.lesson5.DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MmprodTest {
    /*
    Перенесите сценарии из 3 дз (можно писать новые тесты, в том числе сменив сайт) в тесты
    (методы с аннотацией @Test), используйте webDriverWait для ожиданий, в конце тестов добавьте Assertion-ы.
     */
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String MMPROD_BASE_URL = "https://mmprod.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        opt.addArguments("--start-fullscreen");

        driver = new ChromeDriver(opt);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(MMPROD_BASE_URL);
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Test
    void loginTest() throws InterruptedException {

        WebElement authBtn = driver.findElement(By.xpath("//div[@class='header-content']//ul[@class='login-nav']//li[@class='user-item']/a[text()='Вход']"));
        authBtn.click();

        WebElement login = driver.findElement(By.id("loginform-email"));
        login.sendKeys("mmprod.ru@yandex.ru");

        WebElement pass = driver.findElement(By.id("loginform-password"));
        pass.sendKeys("43214321");

        WebElement logBtn = driver.findElement(By.xpath("//button[@name='login-button']"));
        logBtn.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='login-nav']//a[@href='/user/cabinet/view']")));
        WebElement cabinetBtn = driver.findElement(By.xpath("//ul[@class='login-nav']//a[@href='/user/cabinet/view']"));
        cabinetBtn.click();

        Assertions.assertEquals(driver.findElement(By.xpath("//h1[.='Личный кабинет']")).isDisplayed(), true);

        Thread.sleep(3000); //оставил чтобы увидеть результат
    }

    @Test
    void hoverMenuButton() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='/category/po-populyarnosti']")))
                .build()    //говорим что действия выше завершены, тоесть завершили стройку
                .perform();

        driver.findElement(By.xpath("//a[.='Вегетарианские блюда']")).click();

        Assertions.assertEquals(driver.getCurrentUrl(), "https://mmprod.ru/category/vegetarianskie");

        ((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (\n" +
                "    \"//div[@class='categories']\",\n" +
                "    document.documentElement,\n" +
                "    null,\n" +
                "    XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                "    null\n" +
                ");\n" +
                "\n" +
                "if (badTableEval  &&  badTableEval.singleNodeValue) {\n" +
                "    var badTable  = badTableEval.singleNodeValue;\n" +
                "    badTable.parentNode.removeChild (badTable);\n" +
                "}");

        WebElement element = driver.findElement(By.xpath("//a[@href='https://vk.com/mmprodru']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(3000); //оставил чтобы увидеть результат
    }



}
