package nl.backbase.automation.homePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.pages.addComputer.AddComputer;
import nl.backbase.automation.pages.homePage.HomePage;
import nl.backbase.automation.pages.updateComputer.UpdateComputer;
import nl.backbase.automation.utils.ConsolePrinter;
import nl.backbase.automation.utils.Utils;
import org.junit.Assert;

import java.text.ParseException;


public class HomePageStepDefinitions {

    @Steps
    private DataMapper dataMapper;
    @Steps
    private Utils utils;

    private HomePage homePage;
    private AddComputer addComputer;
    private UpdateComputer updateComputer;

    @Given("^user is on add computer page$")
    public void open_add_computer_page(){
        String url= dataMapper.getConfigValueOf("url");
        homePage.openHerokuApp(url);
        homePage.clickOnAddComputer();
        Assert.assertTrue(addComputer.validateAddPageIsOpened().contains("Add a computer"));
    }

    @Then("^User get the success message for creation$")
    public void validate_creation_success_message(){
        ConsolePrinter.PrintToConsole(homePage.getAlertMessage());
        String expectedMessage = "Done! Computer " + dataMapper.getCreateComputerValueof("name") + " has been created";
        Assert.assertTrue(homePage.getAlertMessage().contains(expectedMessage));
    }

    @And("^user can see new entry in table with valid data$")
    public void validate_new_computer_entry() throws ParseException {
        String name = dataMapper.getCreateComputerValueof("name");
        String introducedDate = dataMapper.getCreateComputerValueof("introducedDate");
        String discontinueDate = dataMapper.getCreateComputerValueof("discontinuedDate");
        String company = dataMapper.getCreateComputerValueof("company");

        homePage.enterSearchText(name);
        homePage.clickOnSearchButton();

        Assert.assertTrue(homePage.getFilteredComputerDetail().toLowerCase().contains(utils.getDateFormated(introducedDate)));
        Assert.assertTrue(homePage.getFilteredComputerDetail().toLowerCase().contains(utils.getDateFormated(discontinueDate)));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(name));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(company));

    }

    @Given("^user is on Update computer page$")
    public void open_update_computer_page(){
        String name = dataMapper.getCreateComputerValueof("name");
        String url= dataMapper.getConfigValueOf("url");
        homePage.openHerokuApp(url);

        homePage.enterSearchText(name);
        homePage.clickOnSearchButton();

        homePage.openItem();

        Assert.assertTrue(updateComputer.validateEditPageIsOpened().contains("Edit computer"));
    }

    @Then("^User get the success message for updation$")
    public void validate_updation_success_message(){
        ConsolePrinter.PrintToConsole(homePage.getAlertMessage());
        String expectedMessage = "Done! Computer " + dataMapper.getUpdateComputerValueof("name") + " has been updated";
        Assert.assertTrue(homePage.getAlertMessage().contains(expectedMessage));
    }


    @And("^user can see record in table with updated data$")
    public void validate_updated_computer_details() throws ParseException {
        String name = dataMapper.getUpdateComputerValueof("name");
        String introducedDate = dataMapper.getUpdateComputerValueof("introducedDate");
        String discontinueDate = dataMapper.getUpdateComputerValueof("discontinuedDate");
        String company = dataMapper.getUpdateComputerValueof("company");

        homePage.enterSearchText(name);
        homePage.clickOnSearchButton();

        Assert.assertTrue(homePage.getFilteredComputerDetail().toLowerCase().contains(utils.getDateFormated(introducedDate)));
        Assert.assertTrue(homePage.getFilteredComputerDetail().toLowerCase().contains(utils.getDateFormated(discontinueDate)));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(name));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(company));

    }

    @Given("^user is on Delete computer page$")
    public void open_delete_computer_page(){
        String name = dataMapper.getUpdateComputerValueof("name");
        String url= dataMapper.getConfigValueOf("url");
        homePage.openHerokuApp(url);

        homePage.enterSearchText(name);
        homePage.clickOnSearchButton();

        homePage.openItem();

        Assert.assertTrue(updateComputer.validateEditPageIsOpened().contains("Edit computer"));
    }

    @Then("^User get the success message for deletion$")
    public void validate_deletion_success_message(){
        ConsolePrinter.PrintToConsole(homePage.getAlertMessage());
        String expectedMessage = "Done! Computer has been deleted";
        Assert.assertTrue(homePage.getAlertMessage().contains(expectedMessage));
    }

    @And("^user do not see deleted record anymore$")
    public void deleted_record_does_not_exist(){
        String name = dataMapper.getUpdateComputerValueof("name");
        homePage.enterSearchText(name);
        homePage.clickOnSearchButton();
        Assert.assertTrue(homePage.getNothingFoundMessage().contains("Nothing to display"));
    }

}
