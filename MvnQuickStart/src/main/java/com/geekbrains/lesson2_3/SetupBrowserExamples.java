package com.geekbrains.lesson2_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //пишем настройки на браузер
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        chromeOptions.addArguments("--headless");

        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://www.google.com/");





        Thread.sleep(5000);
        chromeDriver.quit();

    }
}
