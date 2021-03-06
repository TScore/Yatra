package com.Yatra.utilites;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Yatra.bean.SighinIndata;
import com.Yatra.bean.SighinUpdetail;
import com.Yatra.dblayer.Exceldatamanager;
import com.Yatra.objectrepositroy.FlightOneWayLocater;
import com.Yatra.objectrepositroy.SighinInLocater;



/*@Authore:Tapana
 *@version:1.0
 *@Descrption:in this class cover all common method or respited method.
 * 
 * */
public class BussenesCompernat extends YatraAbstract {
	Exceldatamanager exceldatamanager=new Exceldatamanager();
	private SighinInLocater sighinInLocater=null;
	private FlightOneWayLocater flightOneWayLocater=null;

	public void getfirefox(){
		//open firefox driver
		Yatradriver.Driver=new FirefoxDriver();	
	}	
	//open browser in chrome
	public void getChrome(){
		//set the path of chrome
		System.setProperty("webdriver.chrome.driver", "../Yatra/src/com/Yatra/dblayer/chromedriver.exe");
		//open chrome driver
		Yatradriver.Driver=new ChromeDriver();
	}
	public void logOut(){
		Yatradriver.Driver.findElement(By.id("logOut")).click();
	}
	public void getLogin(){
		sighinInLocater=loadObject(new SighinInLocater());
		List<SighinIndata>SighinIndatalist= exceldatamanager.getSighinIndata(1);
		sighinInLocater.getSighiIn().click();
		Yatradriver.Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		sighinInLocater.getEmailIdtextbox().sendKeys(SighinIndatalist.get(0).getUsearname());
		sighinInLocater.getPassword().sendKeys(SighinIndatalist.get(0).getPassword());
		sighinInLocater.getSighInButton().click();
	}
	public void checkAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(Yatradriver.Driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = Yatradriver.Driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			//exception handling
		}
	}
	//calanderOperate
	public void getCalander(String moth,String date){
		flightOneWayLocater=loadObject(new FlightOneWayLocater());
		//String mothname=flightOneWayLocater.getMothSelected().getText();
		for(int i=1;i<=12;i++){
			String mothname=flightOneWayLocater.getMothSelected().getText();
			System.out.println("mothname:"+mothname);
			System.out.println("moth:"+moth);
			if(mothname.equalsIgnoreCase(moth)){
				System.out.println("suces full moth select");
				System.out.println("//td[@id='"+date+"']");
				Yatradriver.Driver.findElement(By.xpath("//td[@id='"+date+"']")).click();
				break;
			}
			else
			{
				flightOneWayLocater.getNextbutton().click();
			}
		}
		//day peck

	}
	public void waitForXpath(String xpath) {
		WebDriverWait wt = new WebDriverWait(Yatradriver.Driver,70);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public void waitForIDPresent(String id) {
		WebDriverWait wt = new WebDriverWait(Yatradriver.Driver, 50);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	public void waitForName(String name){
		WebDriverWait wt=new WebDriverWait(Yatradriver.Driver,50);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}
	public void takeScreenShot(String testName) {	
			try {
			Yatradriver.Driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			//new File("../CiscoMapsAutomation/ScreenShotFile/").mkdirs();		
			//Timestamp timestamp = new Timestamp(new Date().getTime());
			//String filename = "../CiscoMapsAutomation/ScreenShotFile/"+testName+timestamp+ ".jpg";	
			Timestamp timestamp = new Timestamp(new Date().getTime());
			//String filename = "../CiscoMapsAutomation/ScreenShotFile/"+testName+ ".jpg";
			String filename = "..\\Yatra\\reportlayer\\ScrenShoot\\"+testName+timestamp+".jpg";
			WebDriver augmentedDriver = new Augmenter().augment(Yatradriver.Driver);
			File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filename), true);
		} catch (IOException e) {
			//Log.info("IO Exception in taking screen shot");
		} catch (Exception e) 
		{
			//Log.warn(e);
			//Log.info("exception in taking screen shot");
		}
	}
	
	public void getScreenShot(String imagenamee){
		File scrFile = ((TakesScreenshot)Yatradriver.Driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("..//Yatra//reportlayer//ScrenShoot//"+imagenamee));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getClosepopWindow(){
		try{
			Yatradriver.Driver.findElement(By.xpath("//input[@id='quitQbReg']")).click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}



