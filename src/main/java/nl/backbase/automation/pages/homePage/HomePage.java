package nl.backbase.automation.pages.homePage;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    @FindBy(xpath = "//a[@id='add']")
    private WebElement btn_addNewComputer;
    @FindBy(xpath = "//input[@id='searchbox']")
    private WebElement input_searchBox;
    @FindBy(xpath = "//input[@id='searchsubmit']")
    private WebElement btn_searchSubmit;

    public void openHerokuApp(String url) {
        getDriver().manage().deleteAllCookies();
        getDriver().navigate().to(url);
        getDriver().manage().window().maximize();
    }

    public void clickOnAddComputer() {
        btn_addNewComputer.click();
    }

    public void enterSearchText(String text) {
        input_searchBox.sendKeys(text);
    }

    public void clickOnSearchButton() {
        btn_searchSubmit.click();
    }

    public String getFilteredComputerDetail() {
        return getDriver().findElement(By.xpath("//table[contains(@class, 'computers')]//tr")).getText();
    }

    public void openItem() {
        getDriver().findElement(By.xpath("//table[contains(@class, 'computers')]//td/a")).click();
    }

    public String getAlertMessage() {
        return getDriver().findElement(By.xpath("//section[@id='main']//div[contains(@class, 'alert-message')]")).getText();
    }

    public String getNothingFoundMessage() {
        return getDriver().findElement(By.xpath("//div[@class='well']")).getText();
    }
}
