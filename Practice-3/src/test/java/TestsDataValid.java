


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestsDataValid {
    private WebDriver driver;
    private String baseUrl="https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d";



    @Before
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Miiha\\Git QA\\ShishQA-Peresypkin\\Practice-3\\src\\chromedriver.exe");
        driver = new ChromeDriver();
      //  baseUrl = "https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test
    public void test0002ConfirmedStatus()  {
        driver.get(baseUrl);
                driver.findElement(By.id("input-card-number")).click();
                driver.findElement(By.id("input-card-number")).clear();
                driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
                driver.findElement(By.id("input-card-holder")).click();
                driver.findElement(By.id("input-card-holder")).clear();
                driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
                driver.findElement(By.id("payment-form")).submit();
                driver.findElement(By.id("card-expires-month")).click();
                new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
                driver.findElement(By.id("card-expires-month")).click();
                driver.findElement(By.id("card-expires-year")).click();
                new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
                driver.findElement(By.id("card-expires-year")).click();
                driver.findElement(By.id("input-card-cvc")).click();
                driver.findElement(By.id("input-card-cvc")).clear();
                driver.findElement(By.id("input-card-cvc")).sendKeys("123");
                driver.findElement(By.id("action-submit")).click();
                driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
               driver.findElement(By.id("payment-status")).click();
                 assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

                }
    @Test
    public void test4444DeclinedStatus()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555555555554444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        driver.findElement(By.id("payment-status")).click();

        assertEquals("Declined by issuing bank", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }
    @Test
    public void test0044AuthorisedStatus()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000044");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        driver.findElement(By.id("payment-status")).click();

        assertEquals("CONFIRMED", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }


    @Test
    public void test0036ConfirmedStatusAttempt()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0036");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        //driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        driver.findElement(By.id("payment-status")).click();

        assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void test0093ConfirmedStatus3D2vflow()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0093");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        //driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        driver.findElement(By.id("payment-status")).click();

        assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }
    @Test
    public void test0069ConfirmedStatus3D2vflowAttempt()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0069");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        //driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        driver.findElement(By.id("payment-status")).click();

        assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void test0085ConfirmedStatus3D2vfullAut()  {

            driver.get(baseUrl);
            driver.findElement(By.id("input-card-number")).clear();
            driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0085");
            driver.findElement(By.id("input-card-holder")).click();
            driver.findElement(By.id("input-card-holder")).clear();
            driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
            driver.findElement(By.id("payment-form")).submit();
            driver.findElement(By.id("card-expires-month")).click();
            new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("02");
            driver.findElement(By.id("card-expires-month")).click();
            driver.findElement(By.id("card-expires-year")).click();
            new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2025");
            driver.findElement(By.id("card-expires-year")).click();
            driver.findElement(By.id("input-card-cvc")).click();
            driver.findElement(By.id("input-card-cvc")).clear();
            driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
       // driver.switchTo().defaultContent();


       WebElement frame = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/iframe")));

        driver.switchTo().frame(frame);
        System.out.println("good2");
        (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"successButton\"]"))).submit();

         //WebElement eventElement = (new WebDriverWait(driver, 10))
              //  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/table/tbody/tr[58]/td[2]/span")));
      //  WebElement frame = (new WebDriverWait(driver, 10))
               // .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/iframe")));
       // eventElement.submit();
      // WebElement element =
              //  driver.findElement(By.xpath("/html/body/iframe"));
       // driver.switchTo().frame(element);
        //driver.switchTo().defaultContent();
       //driver.findElement (By.xpath("//*[@id=\"successButton\"]")).submit();
        System.out.println("good3");


                assertEquals("Confirmed", driver.findElement(By.xpath("//[@id=\"payment-item-status\"]/div[2]")).getText());

        }

    @Test
    public void test0077No3DConfStatus()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000077");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        //driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        //driver.findElement(By.id("payment-status")).click();

        assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void test4477DeclinedStatus()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555555555554477");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
       // driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
       // driver.findElement(By.id("payment-status")).click();

        assertEquals("Declined by issuing bank", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void test0051AuthorizedStatus()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000051");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("TEST");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("123");
        driver.findElement(By.id("action-submit")).click();
        // driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        // driver.findElement(By.id("payment-status")).click();

        assertEquals("CONFIRMED", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }
    @After
    public void tearDown()  {
        driver.quit();

    }


}
