package nl.backbase.automation.pages.deleteComputer;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteComputer extends PageObject {
    @FindBy(xpath = "//input[@value='Delete this computer']")
    private WebElement btn_delete;

    public void clickOnDelete() {
        btn_delete.click();
    }
}
