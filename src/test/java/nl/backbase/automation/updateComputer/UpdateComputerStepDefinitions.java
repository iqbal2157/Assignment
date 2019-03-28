package nl.backbase.automation.updateComputer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.addComputer.AddComputerStepDefinitions;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.homePage.HomePageStepDefinitions;
import nl.backbase.automation.pages.homePage.HomePage;
import nl.backbase.automation.pages.updateComputer.UpdateComputer;
import org.junit.Assert;

public class UpdateComputerStepDefinitions {

    @Steps
    private DataMapper dataMapper;
    @Steps
    private AddComputerStepDefinitions addComputerStepDefinitions;
    @Steps
    private HomePageStepDefinitions homePageStepDefinitions;

    private UpdateComputer updateComputer;
    private HomePage homePage;

    @Given("^user is on Update computer page$")
    public void openUpdatePage() {
        homePageStepDefinitions.openHerokuAppHomePage();
        homePage.enterSearchText(addComputerStepDefinitions.getCreationName());
        homePage.clickOnSearchButton();
        homePage.openItem();
        Assert.assertTrue(updateComputer.validateEditPageIsOpened().contains("Edit computer"));
    }

    @When("^user enter the computer details to edit$")
    public void enterNewDetailsOfComputer() {
        updateComputer.enterName(getUpdationName());
        updateComputer.enterIntroducedDate(getUpdationIntroducedDate());
        updateComputer.enterDiscontinuedDate(getUpdationDiscontinuedDate());
        updateComputer.selectCompany(getUpdationCompany());
    }

    @And("^click on Update_This_Computer_Button$")
    public void clickOnUpdate() {
        updateComputer.clickOnSave();
    }

    public String getUpdationName() {
        return dataMapper.getUpdateComputerValueof("name");
    }

    public String getUpdationIntroducedDate() {
        return dataMapper.getUpdateComputerValueof("introducedDate");
    }

    public String getUpdationDiscontinuedDate() {
        return dataMapper.getUpdateComputerValueof("discontinuedDate");
    }

    public String getUpdationCompany() {
        return dataMapper.getUpdateComputerValueof("company");
    }

}
