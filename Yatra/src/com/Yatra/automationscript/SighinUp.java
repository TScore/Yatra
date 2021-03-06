package com.Yatra.automationscript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Yatra.bean.SighinUpdetail;
import com.Yatra.dblayer.Exceldatamanager;
import com.Yatra.objectrepositroy.SighinUpData;
import com.Yatra.utilites.BussenesCompernat;
import com.Yatra.utilites.PropertyHandler;
import com.Yatra.utilites.YatraAbstract;
import com.Yatra.utilites.Yatradriver;
/*@Authore:Tapana
 *@Version:1.0
 *Description: in this class create one user use of excel sheet and sigh in that user. 
 * 
 * */
public class SighinUp extends YatraAbstract {
	//load log4j class
	private static Logger Log = Logger.getLogger(SighinUp.class.getName());
	//create object of Baseness comperanet  class and give it name util
	BussenesCompernat util=new BussenesCompernat();
	//load excel operation
	Exceldatamanager excelmangaer=new Exceldatamanager();
	private SighinUpData sighinUpData=null;
	@BeforeClass
	public void openBrowser(){
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		Log.info("openFireFox");
		util.getfirefox();
		Log.info("url load");
		Yatradriver.Driver.get(PropertyHandler.getProperty("URL"));
		Yatradriver.Driver.manage().window().maximize();
		Yatradriver.Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void loadObjectTest(){
		sighinUpData=loadObject(new SighinUpData());
	}
	@Test
	public void SighinUpTest(){
		sighinUpData.getGetSighinup().click();
		String page=Yatradriver.Driver.findElement(By.xpath("//li[text()='Create Your Yatra Account']")).getText();
		Log.info("titlePageName:"+Yatradriver.Driver.getTitle());
		Log.info("pagetitle:"+page);
		List<SighinUpdetail>listSighindata= excelmangaer.getSighinUpdetail(0);
		Log.info("size of excelshet:"+listSighindata.size());
		for(int i=0;i<listSighindata.size();i++){
			Log.info("FirstName coming from excel sheet:"+listSighindata.get(i).getFistName());
			//send the excel sheetdata in firstname
			sighinUpData.getGetFirstName().sendKeys(listSighindata.get(i).getFistName());
			Log.info("LastName:"+listSighindata.get(i).getLastname());
			//last name send in textbox
			sighinUpData.getGetlastname().sendKeys(listSighindata.get(i).getLastname());
			//mobileNo input in mobile no textbox
			String  mobileno=(listSighindata.get(i).getMobileNo())+"";
			mobileno=mobileno.replace(".","");
			Log.info("mobileno:"+mobileno);
			sighinUpData.getGetMobile().sendKeys(mobileno);
			//get the email from excel sheet and input it in email box
			Log.info("email name:"+listSighindata.get(i).getEmailId());
			sighinUpData.getGetEmail().sendKeys(listSighindata.get(i).getEmailId());

			if(Yatradriver.Driver.findElement(By.id("emailavailable")) != null){
				Log.info(listSighindata.get(i).getEmailId()+"this email id sucses full taken");
			}
			else if(Yatradriver.Driver.findElement(By.xpath("//html/body/div[4]/div[1]")) != null)
			{
				Log.info("invalide email id");
			}else{
				Log.info("not work normaly");
			}
			sighinUpData.getGetPassword().sendKeys(listSighindata.get(i).getPassword());
			sighinUpData.getGetConpassword().sendKeys(listSighindata.get(i).getConformpassword());
			if(sighinUpData.getGetCondradioButton().isSelected()){
				Log.info("all rady selected");
			}
			else
			{
				Log.info("please selected");
			}
			sighinUpData.getGetregisterButon().click();
		}
	}
	@AfterMethod
	public void sighOutTest(){
		util.takeScreenShot("SighUp");
	}
	@AfterClass
	public void qiutApplicationTest(){
		Yatradriver.Driver.quit();
	}
}
