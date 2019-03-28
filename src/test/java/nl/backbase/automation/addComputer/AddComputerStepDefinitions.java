package nl.backbase.automation.addComputer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.homePage.HomePageStepDefinitions;
import nl.backbase.automation.pages.addComputer.AddComputer;
import nl.backbase.automation.pages.homePage.HomePage;
import org.junit.Assert;

public class AddComputerStepDefinitions {
    @Steps
    private DataMapper dataMapper;
    @Steps
    private HomePage homePage;
    @Steps
    private AddComputer addComputer;
    @Steps
    private HomePageStepDefinitions homePageStepDefinitions;

    @Given("^user is on add computer page$")
    public void AddNewComputerPage() {
        homePageStepDefinitions.open();
        homePage.clickOnAddComputer();
        Assert.assertTrue(addComputer.validateAddPageIsOpened().contains("Add a computer"));
    }

    @When("^user enter the computer details to add$")
    public void enterComputerDetailsToAddNew() {
        addComputer.enterName(dataMapper.getCreateComputerValueof("name"));
        addComputer.enterIntroducedDate(dataMapper.getCreateComputerValueof("introducedDate"));
        addComputer.enterDiscontinuedDate(dataMapper.getCreateComputerValueof("DiscontinuedDate"));
        addComputer.selectCompany(dataMapper.getCreateComputerValueof("company"));
    }

    @And("^click on Add_Computer_Button$")
    public void clickOnAddComputer() {
        addComputer.clickOnCreate();
    }
}
