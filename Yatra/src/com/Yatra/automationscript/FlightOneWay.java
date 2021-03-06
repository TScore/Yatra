package com.Yatra.automationscript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;








import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Yatra.bean.FlightOneWayData;
import com.Yatra.bean.SighinUpdetail;
import com.Yatra.dblayer.Exceldatamanager;
import com.Yatra.objectrepositroy.FlightOneWayLocater;
import com.Yatra.utilites.BussenesCompernat;
import com.Yatra.utilites.PropertyHandler;
import com.Yatra.utilites.YatraAbstract;
import com.Yatra.utilites.Yatradriver;

/*it this class we determine one way fligt mony 
 * in this class mainly searc flight and verifay which flight cost so less
 * 
 * 
 * */
public class FlightOneWay extends YatraAbstract {
	//load log4j class
	private static Logger Log = Logger.getLogger(FlightOneWay.class.getName());
	//creat object of util class
	BussenesCompernat util=new BussenesCompernat();
	//load excel operation
	Exceldatamanager excelmangaer=new Exceldatamanager();
	private FlightOneWayLocater flightOneWayLocater=null;
	private String moth ,date=null;
	
	@BeforeClass
	public void openUrl(){
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		Log.info("openFireFox");
		util.getfirefox();
		Log.info("url load");
		Yatradriver.Driver.get(PropertyHandler.getProperty("URL"));
		Yatradriver.Driver.manage().window().maximize();
		Yatradriver.Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		excelmangaer.copyData();
	}
	@BeforeMethod
	public void lodLocaterTest(){
		flightOneWayLocater=loadObject(new FlightOneWayLocater());
	}
	@Test
	public void FlightOneWayTest(){
		List<FlightOneWayData>flightOneWayList= excelmangaer.getFlightOneWayData(2);
		Log.info("size of excel sheet"+flightOneWayList.size());
		for(int i=0;i<flightOneWayList.size();i++){
		try{
		flightOneWayLocater.getFlight().click();
		Log.info("chake 2 botten click ya not ");
		if(flightOneWayLocater.getSubflight().isEnabled()){
			Log.info("all rady clicked");
			System.out.println("all rady selected");
		}
		else
		{	
			Log.info("if not selcted just click that one");
			flightOneWayLocater.getSubflight().click();
		}
		Log.info("Leaving from data sent:"+flightOneWayList.get(i).getLeavingFrom());
		flightOneWayLocater.getLeavingfrom().sendKeys(flightOneWayList.get(i).getLeavingFrom());
		Log.info("going to data:"+flightOneWayList.get(i).getGoingTo());
		flightOneWayLocater.getGoingTo().sendKeys(flightOneWayList.get(i).getGoingTo());
		Log.info("depatur date click");
		flightOneWayLocater.getDepartdate().click();
		Log.info("moth selcted:");
		moth=PropertyHandler.getProperty("MothOFArivial");
		Log.info("date selected:"+moth);
		date=flightOneWayList.get(i).getDepatcherDate();
		Log.info("call the calder selcttion method with pass paramiter moth and date");
		util.getCalander(moth,date);
		Log.info("click retin date");
		flightOneWayLocater.getReturndate().click();
		date=flightOneWayList.get(i).getArivaldate();
		moth=PropertyHandler.getProperty("MothOfReturn");
		Log.info("agine call the calder method");
		util.getCalander(moth,date);
		Log.info("traveler mamber select ");
		flightOneWayLocater.getTarvlerselect().click();
		//selected adalt
		Log.info("adul selct");
		Yatradriver.Driver.findElement(By.id("msdrpdd20_title")).click();
		Log.info("click adult button");
		Log.info("select wich adualt opction");
		int k=2;
		Yatradriver.Driver.findElement(By.xpath("//div[@id='msdrpdd20_child']/ul/li["+k+"]")).click();
		
		Log.info("children selection");
		flightOneWayLocater.getChildren().click();
		int k1=1;
		Yatradriver.Driver.findElement(By.xpath("//div[@id='msdrpdd21_child']/ul/li["+k1+"]")).click();
		
		Log.info("infants selection");
		flightOneWayLocater.getInfants().click();
		int k2=2;
		Yatradriver.Driver.findElement(By.xpath("//div[@id='msdrpdd22_child']/ul/li["+k2+"]")).click();
		
		flightOneWayLocater.getTarvlerselect().click();
		Log.info("class selction");
		flightOneWayLocater.getClassSlection().click();
		String selectclass="Economy";
		Yatradriver.Driver.findElement(By.xpath("//span[text()='"+selectclass+"']")).click();
		flightOneWayLocater.getFlightButton().click();
		util.getClosepopWindow();
		util.waitForIDPresent("totalFare");
		String totalFee=flightOneWayLocater.getTotalFare().getText();
		Log.info("totalFee:"+totalFee);
		try {
			excelmangaer.setExcelStringData(2, 1, 8, totalFee);
		} catch (InvalidFormatException e) {
			Log.warn(totalFee);
		} catch (IOException e) {
			
			Log.warn(totalFee, e);
		}
		//placeholder
		}catch(Exception e)
		{
			Log.warn(flightOneWayList, e);
	}
	}
	}
	@AfterMethod
	public void sighOut(){
	util.takeScreenShot("FlightOneWay");
	}
	@AfterClass
	public void quitBrowserTest(){
		Yatradriver.Driver.quit();
	}
}
