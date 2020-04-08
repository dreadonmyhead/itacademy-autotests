package gameoflife;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class GameOfLifePage {

    private final WebDriver driver;

    public GameOfLifePage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(""); //URL should be added
    }

    public void clickNewGame() {
        WebElement newGameButton = driver.findElement(By.cssSelector(".action-button"));
        newGameButton.click();
    }

    public void goBack() {
        WebElement backLink = driver.findElement(By.cssSelector(".breadcrumbs"));
        backLink.click();
    }

    public void clickGo() {
        WebElement goButton = driver.findElement(By.cssSelector("#submit"));
        goButton.click();
    }

    public void clickNextGeneration() {
        WebElement goButton = driver.findElement(By.cssSelector("#submit"));
        goButton.click();
    }

    public void selectCell(int r, int c) {
        WebElement selectFirstCheckbox = driver.findElement(By.cssSelector("input[name='cell_" + r + "_" + c + "']"));
        selectFirstCheckbox.click();
    }

    public void checkCellPosition(int r, int c) {
        WebElement cell = driver.findElement(By.cssSelector("input[name='cell_" + r + "_" + c + "']"));
        Assert.assertEquals("on", cell.getAttribute("value"));
    }

    public boolean isCellAlive(int r, int c) {
        WebElement cell = driver.findElement(By.cssSelector("input[name='cell_" + r + "_" + c + "']"));
        return "on".equals(cell.getAttribute("value"));
    }

    public void checkIntroText(String text) {
        WebElement introText = driver.findElement(By.cssSelector(".intro"));
        Assert.assertEquals(text, introText.getText());
    }
}
