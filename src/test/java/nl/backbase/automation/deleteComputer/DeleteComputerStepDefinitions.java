package nl.backbase.automation.deleteComputer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.addComputer.AddComputerStepDefinitions;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.homePage.HomePageStepDefinitions;
import nl.backbase.automation.pages.deleteComputer.DeleteComputer;
import nl.backbase.automation.pages.homePage.HomePage;

public class DeleteComputerStepDefinitions {

    @Steps
    private DataMapper dataMapper;
    @Steps
    private AddComputerStepDefinitions addComputerStepDefinitions;
    @Steps
    private HomePageStepDefinitions homePageStepDefinitions;

    private HomePage homePage;
    private DeleteComputer deleteComputer;

    @Given("^user is on Delete computer page$")
    public void openDeletePage() {
        homePageStepDefinitions.openHerokuAppHomePage();
        homePage.enterSearchText(addComputerStepDefinitions.getCreationName());
        homePage.clickOnSearchButton();
        homePage.openItem();
    }

    @When("^click on Delete_This_Computer_Button$")
    public void clickOnDelete() {
        deleteComputer.clickOnDelete();
    }


}
