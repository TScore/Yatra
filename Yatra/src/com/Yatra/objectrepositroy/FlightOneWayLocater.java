package com.Yatra.objectrepositroy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightOneWayLocater {
	@FindBy(xpath="//ul[@class='nav-tabs tabletHidden']/descendant::li[@id='menu_flights']/a")
	private WebElement flight;
    @FindBy(xpath="//ul[@id='BE_Nav']/li[1]/a")
    private WebElement subflight;
    //leaving text box
    @FindBy(id="BE_flight_origin_city")
    private WebElement Leavingfrom;
    //reaching text box
    @FindBy(id="BE_flight_arrival_city")
    private WebElement goingTo;
    //departucher time set
    @FindBy(id="BE_flight_depart_date")
    private WebElement departdate;
    //arival time
    @FindBy(id="BE_flight_return_date")
    private WebElement returndate;
    //travaler selection button
    @FindBy(id="BE_flight_paxInfoBox")
    private WebElement tarvlerselect;
    //chose whic class you travle
    @FindBy(id="flight_class_select_title")
    private WebElement classSlection;
    //flight button
    @FindBy(id="BE_flight_flsearch_btn")
    private WebElement flightButton;
    //chose flight and hotel
    @FindBy(id="BE_flight_fhsearch_btn")
    private WebElement flightHotel;
    //calander pop locater
    @FindBy(xpath="//div[@id='calmain']/div[1]/span")
    private WebElement calander;
    //moth selected
    @FindBy(xpath="//div[@id='calmain']/div[2]/span")
    private WebElement mothSelected;
    //next button
    @FindBy(xpath="//a[@class='js_btnNext sprite nextBtn']")
    private WebElement nextbutton;
    //passangerSlecttion
    //select adult
    @FindBy(xpath="//span[@id='msdrpdd20_title']")
    private WebElement adult;
    //select childern
    @FindBy(xpath="//span[@id='msdrpdd21_title']")
    private WebElement children;
    //in fantes
    @FindBy(xpath="//span[@id='msdrpdd22_title']")
    private WebElement infants;
    //total fiee
    @FindBy(id="totalFare")
    private WebElement totalFare;
    //two way locater button
    @FindBy(xpath="//a[text()='Round Trip']")
    private WebElement RoundTrip;
    
    
	public WebElement getRoundTrip() {
		return RoundTrip;
	}
	public WebElement getTotalFare() {
		return totalFare;
	}
	public WebElement getAdult() {
		return adult;
	}
	public WebElement getChildren() {
		return children;
	}
	public WebElement getInfants() {
		return infants;
	}
	public WebElement getLeavingfrom() {
		return Leavingfrom;
	}
	public WebElement getGoingTo() {
		return goingTo;
	}
	public WebElement getDepartdate() {
		return departdate;
	}
	public WebElement getReturndate() {
		return returndate;
	}
	public WebElement getTarvlerselect() {
		return tarvlerselect;
	}
	public WebElement getClassSlection() {
		return classSlection;
	}
	public WebElement getFlightButton() {
		return flightButton;
	}
	public WebElement getFlightHotel() {
		return flightHotel;
	}
	public WebElement getCalander() {
		return calander;
	}
	public WebElement getMothSelected() {
		return mothSelected;
	}
	public WebElement getNextbutton() {
		return nextbutton;
	}
	public WebElement getFlight() {
		return flight;
	}
	public WebElement getSubflight() {
		return subflight;
	}
    
}
