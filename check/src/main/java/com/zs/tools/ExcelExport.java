/**
 * 
 */
package com.zs.tools;

import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author 黄光辉
 *<br/>这个类是用来进行数据导出	
 *
 */
public class ExcelExport {
	
	static Logger log=Logger.getLogger(ExcelExport.class);
	
	public static void OutExcel(Object[] obj, Object[][] obj2 , String path){
		try {     
			// 创建新的Excel 工作簿     
			HSSFWorkbook workbook = new HSSFWorkbook();    
			// 在Excel 工作簿中建一工作表    
			HSSFSheet sheet = workbook.createSheet("Sheet1"); 
			// 设置单元格格式(文本) 
			HSSFCellStyle cellStyle = workbook.createCellStyle(); 
			// 生成一个字体   
	        HSSFFont font = workbook.createFont();
	        font.setFontName("宋体");
	        font.setFontHeightInPoints((short) 12); //设置字号
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL); //设置字体样式 正常显示
			cellStyle.setFont(font);
			cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));         
			// 在索引0的位置创建行（第一行）     
			HSSFRow row = sheet.createRow((short) 0); 
			for(int i = 0 ; i < obj.length ; i++){
				HSSFCell cell1 = row.createCell((short) i);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING); 
//				cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell1.setCellValue(obj[i].toString());
			}
			for(int j = 0 ; j < obj2.length ; j++){    
				row = sheet.createRow((short) j+1);     
				//设置i列从第二列开始     
				for (int i = 0; i < obj2[j].length; i++) {      
					HSSFCell cell = row.createCell((short) (i));   
					// 设置单元格格式        
					cell.setCellStyle(cellStyle);  
					cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
//					cell.setEncoding(HSSFCell.ENCODING_UTF_16); 
					if (obj2[j][i]==null) {
						cell.setCellValue(""); 
					}else{
						cell.setCellValue(obj2[j][i].toString());    
					}
				}            
			}        
			// 新建一输出文件流    
			FileOutputStream fOut = new FileOutputStream(path);  
			// 把相应的Excel 工作簿存盘    
			workbook.write(fOut);  
			// 操作结束，关闭文件  
			fOut.flush();   
			fOut.close();    
		}catch (Exception ioexception) { 
			ioexception.printStackTrace();
			log.error("文件导出失败");
		}  
	}
}
