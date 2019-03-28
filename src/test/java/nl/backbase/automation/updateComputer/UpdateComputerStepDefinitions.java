package nl.backbase.automation.updateComputer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.pages.homePage.HomePage;
import nl.backbase.automation.pages.updateComputer.UpdateComputer;
import org.junit.Assert;

public class UpdateComputerStepDefinitions {

    @Steps
    private DataMapper dataMapper;
    @Steps
    private UpdateComputer updateComputer;

    private HomePage homePage;

    @Given("^user is on Update computer page$")
    public void openUpdatePage() {
        String url = dataMapper.getConfigValueOf("url");
        homePage.openHerokuApp(url);
        homePage.enterSearchText(dataMapper.getCreateComputerValueof("name"));
        homePage.clickOnSearchButton();
        homePage.openItem();
        Assert.assertTrue(updateComputer.validateEditPageIsOpened().contains("Edit computer"));
    }

    @When("^user enter the computer details to edit$")
    public void enterNewDetailsOfComputer() {
        updateComputer.enterName(dataMapper.getUpdateComputerValueof("name"));
        updateComputer.enterIntroducedDate(dataMapper.getUpdateComputerValueof("introducedDate"));
        updateComputer.enterDiscontinuedDate(dataMapper.getUpdateComputerValueof("DiscontinuedDate"));
        updateComputer.selectCompany(dataMapper.getUpdateComputerValueof("company"));
    }

    @And("^click on Update_This_Computer_Button$")
    public void clickOnUpdate() {
        updateComputer.clickOnSave();
    }

}
