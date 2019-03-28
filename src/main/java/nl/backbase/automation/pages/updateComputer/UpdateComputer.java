package nl.backbase.automation.pages.updateComputer;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpdateComputer extends PageObject {
    @FindBy(xpath = "//input[@id='name']")
    private WebElement input_name;
    @FindBy(xpath = "//input[@id='introduced']")
    private WebElement input_introduced;
    @FindBy(xpath = "//input[@id='discontinued']")
    private WebElement input_discontinued;
    @FindBy(xpath = "//select[@id='company']")
    private WebElement dropdown_company;
    @FindBy(xpath = "//input[@value='Save this computer']")
    private WebElement btn_Save;

    public String validateEditPageIsOpened() {
        return getDriver().findElement(By.xpath("//section//h1")).getText();
    }

    public void enterName(String name) {
        input_name.sendKeys(name);
    }

    public void enterIntroducedDate(String date) {
        input_name.sendKeys(date);
    }

    public void enterDiscontinuedDate(String date) {
        input_name.sendKeys(date);
    }

    public void selectCompany(String name) {
        Select company = new Select(dropdown_company);
        company.selectByVisibleText(name);
    }

    public void clickOnSave() {
        btn_Save.click();
    }
}
