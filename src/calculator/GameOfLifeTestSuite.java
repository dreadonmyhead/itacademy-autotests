package gameoflife;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GameOfLifeTestSuite {

    private final static WebDriver driver = new ChromeDriver();
    private static final String INTRO_TEXT = "Please seed your universe";
    private static final String IN_PROGRESS_TEXT = "Press 'Next Generation' to see how this universe evolves...";

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void testGameOfLifeNavigation() {
        GameOfLifePage page = new GameOfLifePage(driver);
        page.goToPage();
        page.clickNewGame();
        page.checkIntroText(INTRO_TEXT);
        page.goBack();
    }

    @Test
    public void testGameOfLife() {
        GameOfLifePage page = new GameOfLifePage(driver);
        page.goToPage();
        page.clickNewGame();
        page.selectCell(0, 0);
        page.clickGo();
        page.checkIntroText(IN_PROGRESS_TEXT);
        page.checkCellPosition(0, 0);
        page.clickNextGeneration();
        Assert.assertFalse(page.isCellAlive(0, 0));
    }
}
