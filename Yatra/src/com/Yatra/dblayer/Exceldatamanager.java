package com.Yatra.dblayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Yatra.bean.FlightOneWayData;
import com.Yatra.bean.SighinUpdetail;
import com.Yatra.bean.SighinIndata;
import com.Yatra.utilites.PropertyHandler;
/*@Authore:Tapana
 *@Version:1.0
 *ExcelDataExctrater for data extracted from excel sheet and it
 *only for data retrieve from excel data.
 * 
 * 
 * */
public class Exceldatamanager {
	//Load  the logger file.
	private static Logger Log = Logger.getLogger(Exceldatamanager.class.getName());
	//create Hssfsheet method for collation  of sheet.
	public void copyData(){
		try {
			FileInputStream file = new FileInputStream(new File(PropertyHandler.getProperty("InPutDataFile")));
			//Get the workbook instance for XLS file 
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			//Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				//For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch(cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:

						break;
					case Cell.CELL_TYPE_NUMERIC:

						break;
					case Cell.CELL_TYPE_STRING:

						break;
					}
				}
			}
			file.close();
			FileOutputStream out =new FileOutputStream(new File(PropertyHandler.getProperty("OutPutDataFile")));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			Log.info("exception in reading  data from list");
		} catch (IOException e) {
			Log.info("exception in reading  data from list");
		}
	}
	//set the data in excel sheet
	public void setExcelStringData(int sheetNo, int rowNum , int columeNum , String data) throws InvalidFormatException, IOException{
		//Property   file add
		//prop.load(new FileInputStream("../CiscoMapsAutomation/CiscoMap.properties"));
		//out put data set
		FileInputStream fis = new FileInputStream(PropertyHandler.getProperty("OutPutDataFile"));
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(sheetNo);
		Row r = sh.getRow(rowNum);
		Cell c = r.createCell(columeNum);
		c.setCellType(Cell.CELL_TYPE_STRING);
		c.setCellValue(data);
		//set the value in out put data(OutPutDataFile)
		FileOutputStream fos = new FileOutputStream(PropertyHandler.getProperty("OutPutDataFile"));
		wb.write(fos);	 
	}
	public void setOverallResult(int sheetNo, int rowNum , int columeNum , int data) throws InvalidFormatException, IOException{
		//Property   file add
		//prop.load(new FileInputStream("../CiscoMapsAutomation/CiscoMap.properties"));
		//out put data set
		FileInputStream fis = new FileInputStream(PropertyHandler.getProperty("OVERALLRESULT"));   //("result"));
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(sheetNo);
		Row r = sh.getRow(rowNum);
		Cell c = r.createCell(columeNum);
		c.setCellType(Cell.CELL_TYPE_NUMERIC);
		c.setCellValue(data);
		//set the value in out put data(OutPutDataFile)
		FileOutputStream fos = new FileOutputStream(PropertyHandler.getProperty("OVERALLRESULT")); //("result"));
		wb.write(fos);	 
	}	
	private HSSFSheet getHssfSheet(Integer sheetNumber){
		//create HSSFSheet object.
		Log.info("creat object Of Hssfsheet");
		HSSFSheet hssfSheet = null;	
		try {
			//excel sheet data input in FileInputStream and create object file
			Log.info("loade file of excel sheet");
			FileInputStream file = new FileInputStream(new File(PropertyHandler.getProperty("InPutDataFile")));
			//create hssfWorkbook for  xls file excel sheet.
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file);
			//get the sheet of excel sheet and store in hssfSheet
			hssfSheet = hssfWorkbook.getSheetAt(sheetNumber);
		} catch (FileNotFoundException e) {		
			Log.info("exception in reading  data from list");
		} catch (IOException e) {
			Log.info("exception in reading  data from list");
		}
		return hssfSheet;
	}
	//Useardetaildata lode in excel sheet method
	public List<SighinUpdetail> getSighinUpdetail(Integer sheetNumber){
		//Collation of all data Useardetaildata and make a object UseardetaildataList
		List<SighinUpdetail>SighinUpdetaillist = null;		
		try{
			//call the getHssfSheet and pass argument sheetNumber.
			HSSFSheet hssfSheet = getHssfSheet(sheetNumber);
			//check sheet is empty or not if emptay return null.   
			if(hssfSheet == null){
				return null;
			}
			//Row number starts with 0
			int totalRows = hssfSheet.getLastRowNum();			
			if(totalRows!=0){
				//column number starts with 1				
				SighinUpdetaillist = new ArrayList<SighinUpdetail>();				
				//0th row contains column headings
				for (int i = 1; i <= totalRows; i++){
					SighinUpdetail sighindata = new SighinUpdetail();					
					Row row = hssfSheet.getRow(i);
					//set the data to the variables defined in peopleData class
					sighindata.setFistName(row.getCell(0).getStringCellValue()!=null ? row.getCell(0).getStringCellValue() : null );
					sighindata.setLastname(row.getCell(1).getStringCellValue()!=null ? row.getCell(1).getStringCellValue() : null);
					sighindata.setMobileNo(row.getCell(2).getNumericCellValue()!=0 ? row.getCell(2).getNumericCellValue():0);
					sighindata.setEmailId(row.getCell(3).getStringCellValue()!=null ? row.getCell(3).getStringCellValue():null);
					sighindata.setPassword(row.getCell(4).getStringCellValue()!=null ? row.getCell(4).getStringCellValue():null);
					sighindata.setConformpassword(row.getCell(5).getStringCellValue()!=null?row.getCell(5).getStringCellValue():null);
					//adding values to Peopledatalist
					SighinUpdetaillist.add(sighindata);					
				}
			}				
		}catch(Exception e){
			Log.info("exception in Useardetaildata");
		}		
		return SighinUpdetaillist;
	}


	public List<SighinIndata> getSighinIndata(Integer sheetNumber){
		//Collation of all data Useardetaildata and make a object UseardetaildataList
		List<SighinIndata>SighinIndatalist = null;		
		try{
			//call the getHssfSheet and pass argument sheetNumber.
			HSSFSheet hssfSheet = getHssfSheet(sheetNumber);
			//check sheet is empty or not if emptay return null.   
			if(hssfSheet == null){
				return null;
			}
			//Row number starts with 0
			int totalRows = hssfSheet.getLastRowNum();			
			if(totalRows!=0){
				//column number starts with 1				
				SighinIndatalist = new ArrayList<SighinIndata>();				
				//0th row contains column headings
				for (int i = 1; i <= totalRows; i++){
					SighinIndata sighinIndata= new SighinIndata();					
					Row row = hssfSheet.getRow(i);
					//set the data to the variables defined in peopleData class
					sighinIndata.setUsearname(row.getCell(0).getStringCellValue()!=null ? row.getCell(0).getStringCellValue() : null );
					sighinIndata.setPassword(row.getCell(1).getStringCellValue()!=null ? row.getCell(1).getStringCellValue() : null);
					//adding values to Peopledatalist
					SighinIndatalist.add(sighinIndata);					
				}
			}				
		}catch(Exception e){
			Log.info("exception in Useardetaildata");
		}		
		return SighinIndatalist;
	}
	public List<FlightOneWayData> getFlightOneWayData(Integer sheetNumber){
		//Collation of all data Useardetaildata and make a object UseardetaildataList
		List<FlightOneWayData>flightOneWayList = null;		
		try{
			//call the getHssfSheet and pass argument sheetNumber.
			HSSFSheet hssfSheet = getHssfSheet(sheetNumber);
			//check sheet is empty or not if emptay return null.   
			if(hssfSheet == null){
				return null;
			}
			//Row number starts with 0
			int totalRows = hssfSheet.getLastRowNum();			
			if(totalRows!=0){
				//column number starts with 1				
				flightOneWayList = new ArrayList<FlightOneWayData>();				
				//0th row contains column headings
				for (int i = 1; i <= totalRows; i++){
					FlightOneWayData flightOneWayData= new FlightOneWayData();					
					Row row = hssfSheet.getRow(i);
					//set the data to the variables defined in peopleData class
					flightOneWayData.setLeavingFrom(row.getCell(0).getStringCellValue()!=null ? row.getCell(0).getStringCellValue() : null );
					flightOneWayData.setGoingTo(row.getCell(1).getStringCellValue()!=null ? row.getCell(1).getStringCellValue() : null);
					flightOneWayData.setDepatcherDate(row.getCell(2).getStringCellValue()!=null ? row.getCell(2).getStringCellValue() : null);
					flightOneWayData.setAdualtselection(row.getCell(3).getNumericCellValue()!=0 ? row.getCell(3).getNumericCellValue():0);
					flightOneWayData.setChildrenSelection(row.getCell(4).getNumericCellValue()!=0 ? row.getCell(4).getNumericCellValue():0);
					flightOneWayData.setInfantsSelection(row.getCell(5).getNumericCellValue()!=0 ? row.getCell(5).getNumericCellValue():0);
					flightOneWayData.setClassSelection(row.getCell(6).getStringCellValue()!=null ? row.getCell(6).getStringCellValue() : null);
					flightOneWayData.setArivaldate(row.getCell(7).getStringCellValue()!=null?row.getCell(7).getStringCellValue():null);
					//adding values to Peopledatalist
					flightOneWayList.add(flightOneWayData);					
				}
			}				
		}catch(Exception e){
			Log.info("exception in flightOneWayData");
		}		
		return flightOneWayList;
	}
}
