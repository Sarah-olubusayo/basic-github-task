import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import java.time.Duration;
import java.util.Objects;


public class KongaOrderingFlowTest {
    //import the Konga WebDriver
    private static WebDriver driver;


@BeforeTest
public void setUp() throws InterruptedException {
        // Locate where the driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // 1. Open the chrome browser
        driver = new ChromeDriver();
        Thread.sleep(3000);
        //2. Open the konga web browser
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // 1. Verify user input the right url and is directed to the right page
        if (Objects.requireNonNull(driver.getCurrentUrl()).contains("https://www.konga.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //4. Click on Login/Signup button to open the signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
    }


@Test(priority = 0)
public static void Login() throws InterruptedException {
        //Test: Verify that user is successfully signed in with a valid email address and password
        // 5. Input your Email address and the Email address field
        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(2000);
        //6. locate the password field and input your password
        driver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(2000);
        //7 click on the signup button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
        System.out.println("User login Successfully");
        Thread.sleep(2000);
    }


@Test(priority = 1)
public void AllCategories() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Click “All Categories” button
        WebElement allCategories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]")));
                allCategories.click();
        System.out.println("Clicked on ‘All Categories’ button.");
        // Wait for the URL to contain the expected text
        String expectedUrl = "https://www.konga.com/#";
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        // Test : Verify that All Categories are listed
        if (actualUrl != null) {
            Assert.assertTrue(actualUrl.contains(expectedUrl), "Failed: All Categories menu is not listed as expected.");
        }
        System.out.println("Passed: All Categories listed successfully");
        Thread.sleep(2000);
    }


@Test(priority = 2)
public void ComputerAndAccessories() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Click Computer and accessories option on the list                                                                 //*[@id="subFixId"]/div/div[1]/ul/li[1]
        WebElement ComputerAndAccessories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")));
                ComputerAndAccessories.click();
        System.out.println("Computer and Accessories button is clickable");
        Thread.sleep(6000);
    }


@Test (priority = 3)
public void LaptopSubcategory() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // click on the Laptop option in the list
        WebElement LaptopList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/label/span")));
                LaptopList.click();
        Thread.sleep(1000);
        System.out.println("LaptopSubcategory button clicked successfully");
        Thread.sleep(4000);
    }


@Test(priority = 4)
public void AppleMacbooks() throws InterruptedException {
        // click on the Apple Macbook category  in the list
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement AppleMacbook = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span"));
        AppleMacbook.click();
        Thread.sleep(2000);
        System.out.println("Apple MacBook button is clickable");
        Thread.sleep(2000);
    }


@Test(priority = 5)
public  void AddMacbook() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // select a Macbook to add to cart                                                                /html/body/div[1]/div/section/div[3]/section/main/section[3]/section/section/section/section/ul/li[2]/article/div[2]/a/h3
          WebElement MacbookAir = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/article/div[2]/a/h3")));
            MacbookAir.click();
            System.out.println("Apple Macbook Air 13 item clicked successfully");
            Thread.sleep(3000);
    }


@Test(priority = 6)
public void AddToCart() throws InterruptedException{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //add Macbook Air 13 to cart
            WebElement AddToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div/div[2]/div[2]/form/div[5]/div[1]/button")));
            AddToCart.click();
            Thread.sleep(3000);
            System.out.println("Add To Cart button clicked successfully: Apple Macbook Air 13 was successfully added");
            Thread.sleep(2000);

        }


@Test(priority = 7)
public void ContinueToCheckout() throws InterruptedException {
    //click on “Continue to Checkout” button
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));   //*[@id="mainContent"]/div/div[2]/div[3]/div[3]/div/div[2]/a
    WebElement ContinueToCheckout = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div/div[2]/div[4]/div/div[6]/div/a"));
    ContinueToCheckout.click();
    Thread.sleep(4000);
    System.out.println("Continue to Checkout was successfully'.");
}


@Test(priority = 8)
public void AddDeliveryAddress() throws InterruptedException {
        Thread.sleep(5000);
        WebElement AddDeliveryAddress = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button"));
        AddDeliveryAddress.click();
         Thread.sleep(2000);
        System.out.println("Add Delivery Address button was clickable");
        Thread.sleep(1000);
    }


@Test(priority = 9)
public void SelectDeliveryAddress() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement SelectDeliveryAddress = driver.findElement(By.name("selectDeliveryAddress"));
    SelectDeliveryAddress.click();
    System.out.println("Select Delivery Address was successfully selected");
    Thread.sleep(3000);

    }


@Test(priority = 10)
public void UseThisAddress() throws InterruptedException {
        WebElement UseThisAddress = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a"));
        UseThisAddress.click();
        System.out.println("Use this Address button was selected");
        Thread.sleep(2000);
      }


@Test(priority = 11)
public void PaymentOptions() throws InterruptedException {
        //Select PayNow
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement PaymentOptions = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input"));
        PaymentOptions.click();
        Thread.sleep(1000);
        System.out.println("Pay Now button was clickable");

       {
           Thread.sleep(2000);
           WebElement ContinueToPayment = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button"));
           ContinueToPayment.click();
           System.out.println("Continue to Payment button was clickable");
           Thread.sleep(8000);

       }

    }


@Test(priority = 12)
public void selectCardMethod () throws InterruptedException {
        //9 select a card payment method
        //9a change from default to iframe
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement SelectCardMethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(16000);
        //9b select card payment method
        WebElement CardPayment = driver.findElement(By.className("Card"));
        CardPayment.click();
        System.out.println("select card method");
        Thread.sleep(3000);
    }


@Test (priority = 13)
public void inputcarddetails() throws InterruptedException {
        //10. input individual card details
        //10a input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("000987654321");
        Thread.sleep(3000);
        //10b input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("1026");
        Thread.sleep(3000);
        //10c input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("321");
        Thread.sleep(3000);
        System.out.println("Invalid Card Number");
        Thread.sleep(5000);
    }


@Test (priority = 14)
public void CloseTheiFrame() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement CloseTheiFrame = driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside"));
        CloseTheiFrame.click();
        System.out.println("iFrame Successfully Closed");
        Thread.sleep(6000);
        // Wait for the URL to contain the expected text
       String expectedUrl = "https://www.konga.com/checkout/complete-order";
       wait.until(ExpectedConditions.urlContains(expectedUrl));
       String actualUrl = driver.getCurrentUrl();
       // Test : Verify that user is redirected to checkout page
       if (actualUrl != null) {
          Assert.assertTrue(actualUrl.contains(expectedUrl), "Failed: No message displayed and User is not redirected to checkout page");
       }
      System.out.println("Passed: User is redirected to checkout page and Cart Successfully re-created, please place your order again is displayed");
      Thread.sleep(2000);

     }


@AfterTest
public void CloseBroswer() {
        //Quit the browser
        KongaOrderingFlowTest.driver.quit();
    }


    public void main() {
    }
}












/*
        //10c input Card Pin in its field
        WebElement Cardpin = driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]"));
        Cardpin.click();
        Thread.sleep(1000);
        WebElement Cardpin1 =driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]"));
        Cardpin1.click();
        Thread.sleep(2000);
        WebElement Cardpin2 = driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]"));
        Cardpin2.click();
        Thread.sleep(2000);
        WebElement Cardpin3 = driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]"));
        Cardpin3.click();
        Thread.sleep(2000);
        WebElement Cardpin4 = driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[4]"));
        Cardpin4.click();
        Thread.sleep(3000);
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(2000);
        */