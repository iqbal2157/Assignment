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
    private HomePageStepDefinitions homePageStepDefinitions;

    private HomePage homePage;
    private AddComputer addComputer;

    @Given("^user is on add computer page$")
    public void AddNewComputerPage() {
        homePageStepDefinitions.openHerokuAppHomePage();
        homePage.clickOnAddComputer();
        Assert.assertTrue(addComputer.validateAddPageIsOpened().contains("Add a computer"));
    }

    @When("^user enter the computer details to add$")
    public void enterComputerDetailsToAddNew() {
        addComputer.enterName(getCreationName());
        addComputer.enterIntroducedDate(getCreationIntroducedDate());
        addComputer.enterDiscontinuedDate(getCreationDiscontinuedDate());
        addComputer.selectCompany(getCreationCompany());
    }

    @And("^click on Add_Computer_Button$")
    public void clickOnAddComputer() {
        addComputer.clickOnCreate();
    }

    public String getCreationName() {
        return dataMapper.getCreateComputerValueof("name");
    }

    public String getCreationIntroducedDate() {
        return dataMapper.getCreateComputerValueof("introducedDate");
    }

    public String getCreationDiscontinuedDate() {
        return dataMapper.getCreateComputerValueof("discontinuedDate");
    }

    public String getCreationCompany() {
        return dataMapper.getCreateComputerValueof("company");
    }
}
