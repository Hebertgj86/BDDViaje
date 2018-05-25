package com.viajar.pages;

import com.viajar.util.ficherosexcel;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;
import java.util.List;

@DefaultUrl("https://www.despegar.com.co")
public class DespegarHomePage extends PageObject {
    /*String annomes = "2018-09";
    String startDate = "1";
    String endDate= "29";*/

    String yyyy_ini = "2018";
    String mm_ini = "09";
    Integer dd_ini = 01;

    String yyyy_fin = "2018";
    String mm_fin = "09";
    Integer dd_fin = 28;

    Integer nro_adults = 2;
    Integer nro_children = 0;

    ficherosexcel excel;
    Calendar c1 = Calendar.getInstance();
    Integer mes = c1.get(Calendar.MONTH);
    String mesCaracter="";
    Select order_flight;

    // region Elementos Página
    @FindBy(xpath = "./html/body/div[8]/div[2]/div/ul/li[2]/a/span[2]")
    private WebElementFacade flightsButton;

    //@FindBy(xpath ="/html/body/div[16]/div/div[1]/span")
    //private WebElementFacade closePopup;

    @FindBy(xpath = "//span[@class='as-login-close as-login-icon-close-circled']")
    private WebElementFacade closePopup;

    @FindBy(xpath = "//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-origin-input sbox-primary sbox-places-first places-inline']")
    private WebElementFacade originField;

    @FindBy(xpath = "//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-destination-input sbox-secondary sbox-places-second places-inline']")
    private WebElementFacade destinyField;

    @FindBy(xpath = "//input[@class='input-tag sbox-bind-disable-start-date sbox-bind-value-start-date-segment-1 sbox-bind-reference-flight-start-date-input -sbox-3-no-radius-right']")
    private WebElementFacade departureDateField;

    @FindBy(xpath = "//div[@class='_dpmg2--months']")
    private WebElementFacade departuretable;

    //@FindBy(xpath = "//*[@class='_dpmg2--months']//*[@class=\'_dpmg2--month-title\']//*[@class=\'_dpmg2--month-title-month\' and contains(text(),'Septiembre')]")
    @FindBy(xpath = "//*[@class='_dpmg2--month _dpmg2--o-6']//*[@class='_dpmg2--month-title-month' and contains(text(),'Septiembre')]")
    private WebElementFacade monthSelect;

    //@FindBy(xpath = "//*[@class='_dpmg2--dates']//*[@class='_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip _dpmg2--days--modifier' and contains(text(),'1')]")
    //@FindBy(xpath = "//*[@class='_dpmg2--month _dpmg2--o-6']//*[@class='_dpmg2--dates']//*[@class='_dpmg2--date _dpmg2--available' and contains(text(),'1')]")
    //@FindBy (css = "._dpmg2--date._dpmg2--available span:nth-of-type(1)")
    //@FindBy (xpath = "//*[@id=\'searchbox-sbox-all-boxes\']/div/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input")
    //@FindBy (xpath = "/html/body/div[4]/div/div[2]/div[2]/i")
    @FindBy (xpath = "/html/body/div[4]/div/div[2]/div[2]")
    private WebElementFacade selectDate;

    @FindBy(xpath = "/html/body/div[4]/div/div[4]/div")
    /*@FindBy(xpath = "/html/body/div[4]/div/div[4]/div[1]")
            /html/body/div[4]/div/div[4]/div[2
            /html/body/div[4]/div/div[4]/div[4]
            /html/body/div[4]/div/div[4]/div[5]
            /html/body/div[4]/div/div[4]/div[6]*/
    private List<WebElementFacade> listMonth;

    @FindBy(xpath = "//*[@class=\'_dpmg2--controls-next\']")
    private WebElementFacade nextButton;



    @FindBy(xpath = "//*[@id=\'searchbox-sbox-all-boxes\']/div/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/input")
    private WebElementFacade prueba2;



    @FindBy(xpath = "//input[@class='input-tag -sbox-3-no-radius-left sbox-bind-disable-end-date sbox-bind-value-end-date sbox-bind-reference-flight-end-date-input']")
    private WebElementFacade returnDateField;

    @FindBy(xpath = "//*[@id=\'searchbox-sbox-all-boxes\']/div[2]/div/div/div[3]/div[2]/div[4]/div/a/em")
    private WebElementFacade searchButton;

    @FindBy(id = "eva-select")
    private WebElementFacade orderFlight;

    @FindBy(xpath = "//*[@id='searchbox-sbox-all-boxes']/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/span[1]")
    private WebElementFacade errorTooltipempty;

    @FindBy(xpath = "//*[@id='searchbox-sbox-all-boxes']/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/span[2]")
    private WebElementFacade errorTooltipdestination;

    @FindBy(xpath = "//*[@id='searchbox-sbox-all-boxes']/div/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/span")
    private WebElementFacade errorTooltip;

    //endregion


    public DespegarHomePage (WebDriver driver){
        super(driver);
    }

    @WhenPageOpens
    public void waitUntilMainElementsAppears() {getDriver().manage().window().maximize();}

    public void fillSearchFields(ExamplesTable searchDataTable){
        Map<String, String> searchData = searchDataTable.getRow(0);
        clearFields();
        originField.waitUntilVisible().sendKeys(searchData.get("from"));
        waitABit(1000);
        originField.sendKeys(Keys.ENTER);
        destinyField.sendKeys(searchData.get("to"));
        waitABit(1000);
        destinyField.sendKeys(Keys.ENTER);
        fillStartDateFields(yyyy_ini,mm_ini,dd_ini);
        fillEndDateFields(yyyy_fin, mm_fin, dd_fin , mm_ini);
        numberPersons(nro_adults, nro_children);
    }

    public void fillStartDateFields (String yyyy_ini, String mm_ini, Integer dd_ini){
        if (mes >=0 || mes<=8 ) {
            mesCaracter = "0" + Integer.toString(mes+1);
        }else {
            mesCaracter = Integer.toString(mes+1);
        }
        String path = "/html/body/div/div/div/div[@data-month='" + yyyy_ini + "-" + mm_ini + "']/div/span[@class='_dpmg2--date _dpmg2--available'][" + dd_ini + "]";

        departureDateField.click();

        while (!$(path).isDisplayed()){
            waitABit(1000);
            selectDate.click();
        }

        if (!mesCaracter.equals(mm_ini)) {
            waitABit(1000);
            selectDate.click();
        }

        waitABit(1000);
        $(path).click();
    }

    public void fillEndDateFields(String yyyy_fin, String mm_fin, Integer dd_fin , String mm_ini) {
        String path = "/html/body/div/div/div/div[@data-month='" + yyyy_fin + "-" + mm_fin + "']/div/span[contains(text(),'" + dd_fin + "')]";
        String xpath ="/html/body/div/div/div/div[@data-month='" + yyyy_fin + "-" + mm_fin + "']/div/span[@class='_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip _dpmg2--days--modifier'][" + dd_fin + "]";

        while (!$(path).isDisplayed()){
            waitABit(1000);
            selectDate.click();
        }

        if (mm_fin.equals(mm_ini)) {
            $(xpath).click();
        }else {
            selectDate.click();
            $(xpath).click();
        }


    }

    public void numberPersons(Integer nro_adults, Integer nro_children) {
        waitABit(1000);
        String path = "//*[@id='searchbox-sbox-all-boxes']/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div/input";
        $(path).click();


        int old_children =  (int) (Math.random()*(5-(2-1))+2);

        for (int i = 1; i < nro_adults; i++) {
            waitABit(1000);
            String xpath = "/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]";
            $(xpath).click();

        }

        for (int i = 1; i <= nro_children; i++) {
            waitABit(1000);
            String xpath2 = "/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/a[2]";
            $(xpath2).click();
            String xpath3 = "/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[3]/div["+ nro_children +"]/div[2]/div/div/select";
            $(xpath3).click();
            String xpath4 = "/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[3]/div["+ nro_children +"]/div[2]/div/div/select/option[" + old_children + "]";
            $(xpath4).click();
        }

        String xpath5 = "/html/body/div[3]/div/div[2]/a";
        $(xpath5).click();

    }

    public void orderFlightsByPrice (){
        waitABit(1000);
        order_flight = new Select(orderFlight);
        waitABit(1000);
        order_flight.selectByIndex(0);
    }



    public void saveExcel(){

        excel = new ficherosexcel();

        String[][] precios = new String [7][7];

        String pathvalor1 ="//*[@id=\'clusters\']/span[1]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]";
        String pathaerolinea1 ="//*[@id=\'clusters\']/span[1]/span/cluster/div/div/span/div/div/span[1]/route-choice/ul/li[1]/route/itinerary/div/span/itinerary-element[2]/span/itinerary-element-airline/span/span/span/span[2]";

        String pathvalor2 ="//*[@id=\'clusters\']/span[2]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]";
        String pathaerolinea2 ="//*[@id=\'clusters\']/span[2]/span/cluster/div/div/span/div/div/span[1]/route-choice/ul/li/route/itinerary/div/span/itinerary-element[2]/span/itinerary-element-airline/span/span/span/span[2]";

        String pathvalor3 ="//*[@id=\'clusters\']/span[3]/span[1]/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]";
        String pathaerolinea3 ="//*[@id=\'clusters\']/span[3]/span[1]/cluster/div/div/span/div/div/span[1]/route-choice/ul/li[1]/route/itinerary/div/span/itinerary-element[2]/span/itinerary-element-airline/span/span/span/span[2]";

        String pathvalor4 ="//*[@id=\'clusters\']/span[4]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]";
        String pathaerolinea4 ="//*[@id=\'clusters\']/span[4]/span/cluster/div/div/span/div/div/span[1]/route-choice/ul/li[1]/route/itinerary/div/span/itinerary-element[2]/span/itinerary-element-airline/span/span/span/span[2]";

        String pathvalor5 ="//*[@id=\'clusters\']/span[5]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]";
        String pathaerolinea5 ="//*[@id=\'clusters\']/span[5]/span/cluster/div/div/span/div/div/span[1]/route-choice/ul/li/route/itinerary/div/span/itinerary-element[2]/span/itinerary-element-airline/span/span/span/span[2]";

        String pathvalor6 ="//*[@id=\'clusters\']/span[6]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]";
        String pathaerolinea6 ="//*[@id=\'clusters\']/span[6]/span/cluster/div/div/span/div/div/span[1]/route-choice/ul/li/route/itinerary/div/span/itinerary-element[2]/span/itinerary-element-airline/span/span/span/span[2]";

        String pathvalor7 ="//*[@id=\'clusters\']/span[7]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]";
        String pathaerolinea7 ="//*[@id=\'clusters\']/span[7]/span/cluster/div/div/span/div/div/span[1]/route-choice/ul/li/route/itinerary/div/span/itinerary-element[2]/span/itinerary-element-airline/span/span/span/span[2]";

        precios[0][0] = $(pathvalor1).getText();
        precios[0][1] = $(pathaerolinea1).getText();

        precios[1][0] = $(pathvalor2).getText();
        precios[1][1] = $(pathaerolinea2).getText();

        precios[2][0] = $(pathvalor3).getText();
        precios[2][1] = $(pathaerolinea3).getText();

        precios[3][0] = $(pathvalor4).getText();
        precios[3][1] = $(pathaerolinea4).getText();

        precios[4][0] = $(pathvalor5).getText();
        precios[4][1] = $(pathaerolinea5).getText();

        precios[5][0] = $(pathvalor6).getText();
        precios[5][1] = $(pathaerolinea6).getText();

        precios[6][0] = $(pathvalor7).getText();
        precios[6][1] = $(pathaerolinea7).getText();

        excel.Excel(precios);
    }




    public void searchFlight(){
        searchButton.click();
        waitABit(6000);
    }

    public void closePopUp(){
        waitABit(2600);
        closePopup.waitUntilPresent();
        closePopup.click();
    }

    public void verifyOnlyOrigin(){
        String sameCityText = errorTooltip.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("Ingresa un origen"));
    }

    public void verifyOnlyDestiny(){
        String sameCityText = errorTooltipempty.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("Ingresa un destino"));
    }

    public void verifyOnlyDepartureDate(){
        String sameCityText = errorTooltip.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("Ingresa una fecha de partida"));
    }

    public void verifyOnlyreturnDate(){
        String sameCityText = errorTooltip.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("Ingresa una fecha de regreso"));
    }

    public void verifySameCity(){
        String sameCityText = errorTooltipdestination.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("El destino debe ser diferente del origen"));
    }

    public void buttonFlights(){
        flightsButton.waitUntilPresent();
        flightsButton.click();
    }

    private void clearFields(){
        originField.clear();
        destinyField.clear();
    }

   /*public void fillDateFields (String annomes, String startDate, String endDate){
        boolean fligh = true;
        //WebElementFacade month = null;
        String xpathStart = "/html/body/div[4]/div/div[4]/div[5]/div[4]/span["+ startDate +"]";
        String xpathEnd = "/html/body/div[4]/div/div[4]/div[5]/div[4]/span["+ endDate +"]";

        departureDateField.click();

        while (fligh){

            for (WebElementFacade elemento: listMonth){
                if (elemento.getAttribute("data-month").equalsIgnoreCase(annomes) & (elemento.getAttribute("class").contains("active"))){
                    //month=elemento;
                    fligh=false;
                    break;
                }
            }

            if (fligh){
                selectDate.click();
                selectDate.click();
                selectDate.click();

            }
        }

        prueba2.click();
        $(xpathStart).click();
        prueba2.click();
        $(xpathEnd).click();
    }*/

}
