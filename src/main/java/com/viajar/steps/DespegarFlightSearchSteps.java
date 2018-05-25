package com.viajar.steps;

import com.viajar.pages.DespegarHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;
import org.jbehave.core.model.ExamplesTable;

import java.io.IOException;

public class DespegarFlightSearchSteps extends ScenarioSteps {

    @Page
    private DespegarHomePage despegarHomePage;

    @Step
    public void openPage(){
        despegarHomePage.open();
    }

    @Step
    public void goFlights(){
        despegarHomePage.closePopUp();
        despegarHomePage.buttonFlights();
    }

    @Step
    public void fillSearchFields(ExamplesTable searchDataTable){
        despegarHomePage.fillSearchFields(searchDataTable);
    }

    @Step
    public void searchFlight(){
        despegarHomePage.searchFlight();
    }

    @Step
    public void orderFlightsByPrice(){
        despegarHomePage.orderFlightsByPrice();
    }

    @Step
    public void saveDataExcel(String file_path) throws IOException {
        //despegarHomePage.saveDataExcel(file_path);
    }

    @Step
    public void verifyOnlyOrigin(){
        despegarHomePage.verifyOnlyOrigin();
    }

    @Step
    public void verifyOnlyDestiny(){
        despegarHomePage.verifyOnlyDestiny();
    }

    @Step
    public void verifySameCity(){
        despegarHomePage.verifySameCity();
    }

    @Step
    public void saveExcel(){
        despegarHomePage.saveExcel();
    }

}
