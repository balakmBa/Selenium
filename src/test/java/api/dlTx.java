package api;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static io.restassured.RestAssured.given;

public class dlTx {

    WebDriver driver;
@Test
    public void getdlTx(){
        RestAssured.baseURI="https://publicapi.txdpsscheduler.com/";
        Response res=given().
                headers(getHeaders()).and().
                body("{TypeId: 71, ZipCode: \"75081\", CityName: \"\", PreferredDay: 0}").
                when().post("api/AvailableLocation").
                then().assertThat().statusCode(200).and().extract().response();
        //System.out.println(res.toString());
    //System.out.println(res.body().toString());
    //System.out.println(res.jsonPath().prettify());
    System.out.println((String) res.jsonPath().get("[0].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[0].Name"));
    System.out.println((String) res.jsonPath().get("[1].NextAvailableDate ") + ":"+ (String) res.jsonPath().get("[1].Name"));
    System.out.println((String) res.jsonPath().get("[2].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[2].Name"));
    System.out.println((String) res.jsonPath().get("[3].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[3].Name"));
    System.out.println((String) res.jsonPath().get("[4].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[4].Name"));
    System.out.println(res.jsonPath().getInt("size()"));




}
@Test
public void reqres(){
    RestAssured.baseURI="https://reqres.in/";
          Response res=  given().
                    queryParam("page",2).
                    when().
                    get("api/users").
                    then().assertThat().statusCode(200).and().extract().response();
    //System.out.println(res.jsonPath().prettify());
    Integer size=(Integer) res.jsonPath().get("size()");
    for(int i=0;i<size;i++){
    System.out.println((String) res.jsonPath().get("data[" +i+ "].email"));
    }
}
    public Map<String,String> getHeaders(){

        Map<String,String> mp=new HashMap<>();
        mp.put("Accept","application/json, text/plain, */*");
        mp.put("Accept-Encoding","gzip, deflate, br");
        mp.put("Accept-Language","en-US,en;q=0.9");
        mp.put("Connection","keep-alive");
        //mp.put("Content-Length","62");
       mp.put("Content-Type","application/json;charset=UTF-8");
        mp.put("Host","publicapi.txdpsscheduler.com");
        mp.put("Origin","https://public.txdpsscheduler.com");
        mp.put("Referer","https://public.txdpsscheduler.com");
        mp.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36");
        mp.put("sec-ch-ua","\"Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99\"");
        mp.put("sec-ch-ua-mobile","?0");
        mp.put("sec-ch-ua-platform","\"Windows\"");
        mp.put("Sec-Fetch-Dest","empty");
        mp.put("Sec-Fetch-Mode","cors");
        mp.put("Sec-Fetch-Site","same-site");

        return mp;

    }

    @Test
    public void listmap(){

        //Map<String,String> mp1=new HashMap<>();

        List<Map<String,String>> ar=new ArrayList<>();

       for(int i=0;i<6;i++){
           Map<String,String> mp=new HashMap<>();
           mp.put("username","bala" + i + "");
ar.add(mp);

       }
        // List<Map<String,String>> ar=new ArrayList<>();

        System.out.println(ar);
       for(int i=0;i< ar.size();i++) {
           System.out.println(ar.get(i).get("username"));
       }

    }
    @Test(enabled = false)
    public void demoTestQa() throws InterruptedException {

     WebDriverManager.chromedriver().setup();
     driver =new ChromeDriver();

    driver.get("https://demoqa.com/alerts");
    Wait wait= new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
   WebElement alertfive= (WebElement) wait.until(new Function<WebDriver, WebElement>() {
        @Override
        public WebElement apply(WebDriver driver) {
            return driver.findElement(By.id("timerAlertButton"));
        }
    });

        WebDriverWait exwait= new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.manage().window().maximize();
        alertfive.click();
   exwait.until(ExpectedConditions.alertIsPresent()).accept();
   Thread.sleep(5000);
   //driver.manage().window().minimize();
   driver.quit();

    }
    @Test
    public void petstore(){
    RestAssured.baseURI="https://petstore.swagger.io";
        File pngfile= new File("C:\\Users\\balak\\Downloads\\dog.jpg");
    Response res=given()
        .multiPart(pngfile)
            .when()
            .post("/v2/pet/45/uploadImage")
            .then().assertThat().statusCode(200)
            .and().extract().response();

        System.out.println(res.asPrettyString());

    }

    @Test(priority = 1)
    public void getpetstore(){
    RestAssured.baseURI="https://petstore.swagger.io";
    Response res=given()
            .when()
            .get("/pet/46")
            .then().assertThat().statusCode(200)
            .and().extract().response();
        System.out.println(res.asPrettyString());
    }


    @Test(enabled = false)
    public void fileupload() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
        Wait wait= new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement fileupload= (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("file-upload"));
            }
        });
        //fileupload.click();
        JavascriptExecutor exec=(JavascriptExecutor) driver;
        exec.executeScript("arguments[0].click();",fileupload);
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void getRenewLic(){
        RestAssured.baseURI="https://publicapi.txdpsscheduler.com/";
        Response res=given().
                headers(getHeaders()).and().
                body("{TypeId: 81, ZipCode: \"75081\", CityName: \"\", PreferredDay: 0}").
                when().post("api/AvailableLocation").
                then().assertThat().statusCode(200).and().extract().response();
        //System.out.println(res.toString());
        //System.out.println(res.body().toString());
        //System.out.println(res.jsonPath().prettify());
        System.out.println((String) res.jsonPath().get("[0].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[0].Name"));
        System.out.println((String) res.jsonPath().get("[1].NextAvailableDate ") + ":"+ (String) res.jsonPath().get("[1].Name"));
        System.out.println((String) res.jsonPath().get("[2].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[2].Name"));
        System.out.println((String) res.jsonPath().get("[3].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[3].Name"));
        System.out.println((String) res.jsonPath().get("[4].NextAvailableDate") + ":"+ (String) res.jsonPath().get("[4].Name"));
        System.out.println(res.jsonPath().getInt("size()"));




    }
}

