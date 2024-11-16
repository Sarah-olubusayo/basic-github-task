import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Objects;


public class SeleniumWebSignupTest {

    //import the Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your chrome browser
        driver = new ChromeDriver();
        //2. Open your selenium web browser
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(3000);
        //Test 1. Verify the user input the right url and his on the right webpage
        if (Objects.requireNonNull(driver.getCurrentUrl()).contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
                System.out.println("Wrong Webpage");
        Thread.sleep(2000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        // 4. click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(3000);
    }

    @Test (priority =0)
    public void PositiveSignUp() throws InterruptedException {
        //Test 7. Verify that user is successfully signed up when valid details are inputted
        // 5. input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("chiiddy");
        //6. Input email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("busayo91@mailinator.com");
        //7. locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("testi2024");
        //8 click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
    }

        @Test(priority = 1)
        public void clickUser1Item() throws InterruptedException {
            //9. click on user1 item on the listpage
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]")).click();
             Thread.sleep(3000);
            //Test 2. Verify that when user clicks on the signup button, the user is directed to the signup page
            String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl != null;
            if (actualUrl.contains(expectedUrl))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");
            Thread.sleep(2000);
        }

        @Test (priority = 2)
        public void clickUser2Item() throws InterruptedException {
            //10. Search for an item (using python with selenium) and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
            //Test 9. Verify that the item searched for on the meaghan page is present
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
            String actualPageUrl = driver.getCurrentUrl();
            String actualUrl = "https://selenium-blog.herokuapp.com/users/1";
            if (actualUrl.contains(expectedPageUrl))
                //Pass
                System.out.println("Correct MeaghanPage");
            else
                //Fail
                System.out.println("Wrong MeaghanPage");
            Thread.sleep(2000);
        }

        @Test (priority = 3)
            public void logoutSuccessfully() throws InterruptedException {
            //11. click on logout
            //Test 10. Verify that when the user logout, he.she is directed back to the home page
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            assert actualTitle != null;
            if (actualTitle.contains(expectedTitle))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");
            Thread.sleep(3000);
        }

    @Test (priority =4)
    public void InvalidUsername() throws InterruptedException {
        // click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(3000);
        //Test 3. Verify that user cannot signup with username less than 3 characters
        // 5. input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("re");
        //6. Input email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("busayo29@mailinator.com");
        //7. locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("test30024");
        //8 click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
    }

    @Test (priority =6)
    public void InvalidEmailAddress() throws InterruptedException {
        //click on sign up on the sign up page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        //Test 4. Verify that user cannot signup with invalid Email Address
        // 5. input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("gammie34");
        //6. Input email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("fuss6@.com");
        //7. locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("testiy3024");
        //8 click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
    }

    @Test (priority =7)
    public void WrongPassword() throws InterruptedException {
        //click on sign up on the sign up page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        //Test 4. Verify that user cannot signup with invalid Email Address
        // 5. input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("chioma5");
        //6. Input email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("busayo788@mailinator.com");
        //7. locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("w");
        String expectedTitle = "Password too short";
        String actualTitle = driver.getTitle();
        assert actualTitle != null;
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(3000);

        //8 click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
    }

    @Test (priority =8)
    public void EmptyFields() throws InterruptedException {
        //click on sign up on the sign up page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        //Test 4. Verify that user cannot signup with invalid Email Address
        // 5. input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //6. Input email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7. locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("");
        //8 click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
    }

    @AfterTest
        public void closeBrowser() {
        //Quit the browser
        driver.quit();
        }
}




