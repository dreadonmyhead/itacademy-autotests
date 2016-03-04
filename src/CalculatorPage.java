import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    private final WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://www.swedbank.lt/lt/spreadsheets/consumer2");
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