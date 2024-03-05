package Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;

public class TestingMajorProject {
    public static void main(String[] args) throws InterruptedException {
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Appu\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        
        Thread.sleep(2000);
        //(1)
        //
        WebElement usernameField = driver.findElement(By.id("Username"));
        usernameField.sendKeys("test");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("test@1234");
        WebElement loginButton = driver.findElement(By.id("Login"));
        loginButton.click();
       
        //(2)
        // Test online widgets like date pickers, tabs, sliders
        driver.findElement(By.id("datepicker")).sendKeys("12/25/2023");               
        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
        Actions sliderAction = new Actions(driver);
        sliderAction.dragAndDropBy(slider, 50, 0).perform();
        
        Thread.sleep(2000);
        
        //(3)
        // Test interactive actions like draggable, resizable, selectable etc.
        WebElement draggable = driver.findElement(By.id("draggable"));
        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDropBy(draggable, 100, 100).build().perform();
        WebElement resizable = driver.findElement(By.id("resizable"));
        Actions resize = new Actions(driver);
        resize.clickAndHold(resizable).moveByOffset(50, 50).release().perform();

        Thread.sleep(2000);

        //(4) 
        // Test the filling up of registration form and submission
        driver.findElement(By.id("name")).sendKeys("Pramod");
        driver.findElement(By.id("email")).sendKeys("abc.doe@example.com");
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        driver.findElement(By.id("textarea")).sendKeys("123, Main Street");
        
        //(3) & (4)
        // Select value from dropdown
        Select countryDropdown = new Select(driver.findElement(By.id("country")));
        countryDropdown.selectByVisibleText("United States");

        //(4)
        // Check radio button
        driver.findElement(By.xpath("//input[@value='male']")).click();

        Thread.sleep(2000);

        //(5)
        // Test frames and windows   
        driver.switchTo().frame(driver.findElement(By.id("frame-one796456169")));
        driver.findElement(By.id("RESULT_TextField-0")).sendKeys("abcd");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.id("RESULT_TextField-2")).sendKeys("12/25/2023");
        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@class='drop_down']")));
        dropdown1.selectByVisibleText("QA Engineer");

        driver.findElement(By.id("FSsubmit")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(2000);

        //(6)
        // alert boxes
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert']"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("I am an alert box!" + alert.getText()); // Print alert text
        alert.accept();

       

        driver.quit();
    }
}
