package com.viajar.definitions;

import com.viajar.steps.DespegarFlightSearchSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.model.ExamplesTable;

import java.io.IOException;

public class DespegarFlightSearchDefinitions {

    @Steps
    private DespegarFlightSearchSteps despegarFlightSearchSteps;

    @Given("I am on despegar.com.co home's page")
    public void openPage(){
        despegarFlightSearchSteps.openPage();
        despegarFlightSearchSteps.goFlights();
    }

    @When("I fill search fields $searchDataTable")
    public void fillSearchFields(ExamplesTable searchDataTable){
        despegarFlightSearchSteps.fillSearchFields(searchDataTable);
    }

    @When("click on search button")
    public void searchFlight(){
        despegarFlightSearchSteps.searchFlight();
    }

    @Then ("system show the result the consult")
    public void orderFlightsByPrice(){
        despegarFlightSearchSteps.orderFlightsByPrice();
    }

    @Then ("system save the consult in excel <file_path>")
    public void saveDataExcel(@Named("file_path") String file_path)throws IOException {
        despegarFlightSearchSteps.saveDataExcel(file_path);
    }

    @Then ("system save the consult")
    public void saveExcel()throws IOException {
        despegarFlightSearchSteps.saveExcel();
    }


    @Then("system show a same city error notification below destiny field")
    public void verifySameCity(){
        despegarFlightSearchSteps.verifySameCity();
    }

    @Then("system show a origin is empty error notification below origin field")
    public void  verifyOnlyOrigin(){
        despegarFlightSearchSteps.verifyOnlyOrigin();
    }

    @Then("system show a destiny is empty error notification below origin field")
    public void verifyOnlyDestiny(){
        despegarFlightSearchSteps.verifyOnlyDestiny();
    }
}
