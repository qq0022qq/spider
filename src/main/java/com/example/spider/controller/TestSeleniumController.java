package com.example.spider.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/testSelenium")
public class TestSeleniumController {

    @RequestMapping ("/test")
    public void testSelenium(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        //创建驱动
        WebDriver driver=new ChromeDriver();
        //与将要爬取的网站建立连接
        driver.get("https://www.baidu.com/");
        driver.close();
    }
}
