package calculator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class CalculatorPage {

    private final WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://www.swedbank.lt/private/credit/loans/newSmall/small_loanLT/personal");
    }

    public void insertFirstAmount(String amount) {
        WebElement firstInput = driver.findElement(By.id("SpreadsheetRequestedLoanAmount"));
        firstInput.clear();
        firstInput.sendKeys(amount);
    }

    public void calculate() {
        WebElement buttonSubmit = driver.findElement(By.id("SpreadsheetHasOutstandingLoan1"));
        buttonSubmit.submit();
    }

    public void assertMessage(String msg) {
        WebElement errorMsg = driver.findElement(By.xpath("//span[contains(@class, 'consumer-invalid-txt')]"));
        Assert.assertEquals(msg, errorMsg.getText());
    }
}