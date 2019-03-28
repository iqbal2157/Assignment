package nl.backbase.automation.homePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.pages.homePage.HomePage;
import nl.backbase.automation.updateComputer.UpdateComputerStepDefinitions;
import org.junit.Assert;

public class HomePageStepDefinitions {
    @Steps
    private DataMapper dataMapper;
    @Steps
    private HomePage homePage;
    @Steps
    private UpdateComputerStepDefinitions updateComputerStepDefinitions;


    @Then("^User get the success message - Done! Computer Computer_name has been created$")
    public void validateTheAddSuccessMessage() {
        Assert.assertTrue(homePage.getAlertMessage().equals("Done!"));
        String expectedMessage = "Computer " + dataMapper.getCreateComputerValueof("name") + " has been created";
        Assert.assertTrue(homePage.getAlertMessage().contains(expectedMessage));
    }

    @And("^user can see new entry in table with valid data$")
    public void validateNewEntryInTable() {
        homePage.enterSearchText(dataMapper.getCreateComputerValueof("name"));
        homePage.clickOnSearchButton();
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getCreateComputerValueof("name")));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getCreateComputerValueof("introducedDate")));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getCreateComputerValueof("DiscontinuedDate")));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getCreateComputerValueof("company")));
    }

    @Then("^User get the success message - Done! Computer Computer_name has been updated$")
    public void validateTheEditSuccessMessage() {
        Assert.assertTrue(homePage.getAlertMessage().equals("Done!"));
        String expectedMessage = "Computer " + dataMapper.getUpdateComputerValueof("name") + " has been created";
        Assert.assertTrue(homePage.getAlertMessage().equals(expectedMessage));
    }

    @And("^user can see record in table with updated data$")
    public void validateEditedEntryInTable() {
        homePage.enterSearchText(dataMapper.getUpdateComputerValueof("name"));
        homePage.clickOnSearchButton();
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getUpdateComputerValueof("name")));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getUpdateComputerValueof("introducedDate")));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getUpdateComputerValueof("DiscontinuedDate")));
        Assert.assertTrue(homePage.getFilteredComputerDetail().contains(dataMapper.getUpdateComputerValueof("company")));
    }

    @Then("^User get the success message - Done! Computer has been deleted$")
    public void validateTheDeleteSuccessMessage() {
        Assert.assertTrue(homePage.getAlertMessage().contains("Done!"));
        Assert.assertTrue(homePage.getAlertMessage().contains("Computer has been deleted"));
    }

    @And("^user don't see deleted record anymore$")
    public void validateItemIsDeleted() {
        Assert.assertTrue(homePage.getNothingFoundMessage().contains("Nothing to display"));
    }

    public void open(){
        String url = dataMapper.getConfigValueOf("url");
        homePage.openHerokuApp(url);
    }
}
