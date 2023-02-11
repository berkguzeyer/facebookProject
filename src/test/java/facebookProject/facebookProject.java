package facebookProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class facebookProject {

//Goal of the project: As an Automation tester, you are going to visit Facebook page, manually test the sign-up functionality. Then automate your test cases and run your automation.
//Step 1- Create your user stories for each part of the sign-up functionality
//Step 2- Based on your user stories create your test cases and test scenarios
//Step 3- Based on your test cases start the test execution manually
//Step 4- Write your codes on Maven Project and automate your test cases.

//Summary of the Task :
//// Navigate https://www.facebook.com/
//// Click on Create New Account button
//// Fill the form
//// Get text for Sign Up button


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String fName = "Techno";
        String lName = "Study";
        String email = "batch7group4@gmail.com";
        String pw = "12345";
        String month = "";

        WebElement createAccountButton = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createAccountButton.click();

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys(fName);

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys(lName);

        WebElement mobileOrEmail = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        mobileOrEmail.sendKeys(email);

        //<input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text" name="reg_email_confirmation__" value="" aria-required="true" placeholder="" aria-label="Re-enter email" id="u_2_j_/E">
        WebElement emailConfirm = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        emailConfirm.sendKeys(email);

        WebElement password = driver.findElement(By.id("password_step_input"));
        password.sendKeys(pw);

        WebElement monthDropdownMenu = driver.findElement(By.id("month"));
        Select monthDropdown = new Select(monthDropdownMenu);
        monthDropdown.selectByVisibleText("Oct");


        WebElement dayDropdownMenu = driver.findElement(By.id("day"));
        Select dayDropdown = new Select(dayDropdownMenu);
        dayDropdown.selectByVisibleText("5");

        WebElement yearDropdownMenu = driver.findElement(By.id("year"));
        Select yearDropdown = new Select(yearDropdownMenu);
        yearDropdown.selectByVisibleText("1990");

        WebElement femaleRadio = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));

        WebElement maleRadio = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        maleRadio.click();

        WebElement customRadio = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));

        //<button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v" name="websubmit" id="u_2_s_Dj">Sign Up</button>
        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();

    }
}
