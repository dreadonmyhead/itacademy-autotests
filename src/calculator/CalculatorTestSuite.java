package calculator;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CalculatorTestSuite {

    private final static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void testCalculator() throws InterruptedException {
        CalculatorPage page = new CalculatorPage(driver);
        page.goToPage();
        page.insertFirstAmount("5000");

        page.calculate();

        page.assertMessage("Atsižvelgdami į Jūsų nurodytas mėnesio pajamas, paskolos suteikti negalime.");
    }
}