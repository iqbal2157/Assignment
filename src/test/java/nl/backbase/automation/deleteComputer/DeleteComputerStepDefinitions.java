package nl.backbase.automation.deleteComputer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.pages.deleteComputer.DeleteComputer;
import nl.backbase.automation.pages.homePage.HomePage;

public class DeleteComputerStepDefinitions {
    @Steps
    private DeleteComputer deleteComputer;
    @Steps
    private DataMapper dataMapper;
    @Steps
    private HomePage homePage;

    @Given("^user is on Delete computer page$")
    public void openDeletePage() {
        String url = dataMapper.getConfigValueOf("url");
        homePage.openHerokuApp(url);
        homePage.enterSearchText(dataMapper.getCreateComputerValueof("name"));
        homePage.clickOnSearchButton();
        homePage.openItem();
    }

    @When("^click on Delete_This_Computer_Button$")
    public void clickOnDelete() {
        deleteComputer.clickOnDelete();
    }


}
