/**
 * 
 */
package com.zs.tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 黄光辉
 *<br/>这个类是用来进行数据导出	
 *
 */
public class ExcelExport {
	public static String NO_DEFINE = "no_define";//未定义的字段
    public static String DEFAULT_DATE_PATTERN="yyyy年MM月dd日";//默认日期格式
    public static int DEFAULT_COLOUMN_WIDTH = 17;
	
	
	static Logger log=Logger.getLogger(ExcelExport.class);
	
	/**
	 * @author 黄光辉
	 * 数据导出不分工作表，适用于小数据量
	 * 
	 */
	public static void OutExcel(Object[] obj, Object[][] obj2 , String path,String sheetName){
		try {     
			// 创建新的Excel 工作簿     
			HSSFWorkbook workbook = new HSSFWorkbook();    
			// 在Excel 工作簿中建一工作表    
			HSSFSheet sheet = workbook.createSheet(sheetName); 
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
			HSSFRow row = sheet.createRow((int) 0); 
			for(int i = 0 ; i < obj.length ; i++){
				HSSFCell cell1 = row.createCell((int) i);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING); 
//				cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell1.setCellValue(obj[i].toString());
			}
			for(int j = 0 ; j < obj2.length ; j++){    
				row = sheet.createRow((int) j+1);     
				//设置i列从第二列开始     
				for (int i = 0; i < obj2[j].length; i++) {      
					HSSFCell cell = row.createCell((int) (i));   
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
	
	
	/**
	 * @author 黄光辉
	 * 数据导出分工作表，适用于数据量比较大
	 * 
	 */
	public static void OutExcel1(Object[] obj, Object[][] obj2 , String path){
		try {     
			// 创建新的Excel 工作簿     
			HSSFWorkbook workbook = new HSSFWorkbook();    
			// 设置单元格格式(文本) 
			HSSFCellStyle cellStyle = workbook.createCellStyle(); 
			// 生成一个字体   
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setFontHeightInPoints((short) 12); //设置字号
			font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL); //设置字体样式 正常显示
			cellStyle.setFont(font);
			cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));         
			int index = obj2.length/50000;
			for (int k = 0; k <= index; k++) {
				// 在Excel 工作簿中建一工作表    
				HSSFSheet sheet = workbook.createSheet(k*50000+"-"+(k+1)*50000+"条数据");
				// 在索引0的位置创建行（第一行）     
				HSSFRow row = sheet.createRow((int) 0); 
				for(int i = 0 ; i < obj.length ; i++){
					HSSFCell cell1 = row.createCell((int) i);
					cell1.setCellType(HSSFCell.CELL_TYPE_STRING); 
//				cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell1.setCellValue(obj[i].toString());
				}
				if(k==index){
					for(int j = k*50000 ; j < obj2.length ; j++){    
						row = sheet.createRow((int) j+1-k*50000);     
						//设置i列从第二列开始     
						for (int i = 0; i < obj2[j].length; i++) {      
							HSSFCell cell = row.createCell((int) (i));   
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
				}else{
					for(int j = k*50000 ; j < (k+1)*50000 ; j++){    
						row = sheet.createRow((int) j+1-k*50000);     
						//设置i列从第二列开始     
						for (int i = 0; i < obj2[j].length; i++) {      
							HSSFCell cell = row.createCell((int) (i));   
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
	
	/**
	 * @author 黄光辉
	 * 适用于表头栏位有多行
	 * 数据导出不分工作表，适用于小数据量
	 * 
	 */
	public static void OutExcel2line(Object[][] obj1, Object[][] obj2 , String path,String sheetName){
		try {     
			// 创建新的Excel 工作簿     
			HSSFWorkbook workbook = new HSSFWorkbook();    
			// 在Excel 工作簿中建一工作表    
			HSSFSheet sheet = workbook.createSheet(sheetName); 
			// 设置单元格格式(文本) 
			HSSFCellStyle cellStyle = workbook.createCellStyle(); 
			// 生成一个字体   
	        HSSFFont font = workbook.createFont();
	        font.setFontName("宋体");
	        font.setFontHeightInPoints((short) 12); //设置字号
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL); //设置字体样式 正常显示
			cellStyle.setFont(font);
			cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));         
			HSSFRow row =sheet.createRow((int) 0); 
			for (int i = 0; i < obj1.length; i++) {
				// 在索引0的位置创建行（第一行）     
				row = sheet.createRow((int) i); 
				for(int j = 0 ; j < obj1[i].length ; j++){
					HSSFCell cell1 = row.createCell((int) j);
					cell1.setCellType(HSSFCell.CELL_TYPE_STRING); 
//				cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell1.setCellValue(obj1[i][j].toString());
				}
				
			}
			for(int j = 0 ; j < obj2.length ; j++){    
				row = sheet.createRow((int) j+obj1.length);     
				//设置i列从第二列开始     
				for (int i = 0; i < obj2[j].length; i++) {      
					HSSFCell cell = row.createCell((int) (i));   
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
	/**
	 * @author 黄光辉
	 * 
	 *     暂时还未使用
     * 
     * 导出Excel 2007 OOXML (.xlsx)格式
     * @param title 标题行
     * @param headMap 属性-列头
     * @param jsonArray 数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth 列宽 默认 至少17个字节
     * @param out 输出流
     */
    public static void exportExcelX(String title,Map<String, String> headMap,JSONArray jsonArray,String datePattern,int colWidth, OutputStream out) {
        if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
        workbook.setCompressTempFiles(true);
         //表头样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);
        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // 生成一个(带标题)表格
        SXSSFSheet sheet = workbook.createSheet();
        //设置列宽
        int minBytes = colWidth<DEFAULT_COLOUMN_WIDTH?DEFAULT_COLOUMN_WIDTH:colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext();) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] =  bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii,arrColWidth[ii]*256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : jsonArray) {
            if(rowIndex == 65535 || rowIndex == 0){
                if ( rowIndex != 0 ) sheet = workbook.createSheet();//如果数据超过了，则在第二页显示

                SXSSFRow titleRow = sheet.createRow(0);//表头 rowIndex=0
                titleRow.createCell(0).setCellValue(title);
                titleRow.getCell(0).setCellStyle(titleStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                SXSSFRow headerRow = sheet.createRow(1); //列头 rowIndex =1
                for(int i=0;i<headers.length;i++)
                {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);

                }
                rowIndex = 2;//数据内容从 rowIndex=2开始
            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            SXSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++)
            {
                SXSSFCell newCell = dataRow.createCell(i);

                Object o =  jo.get(properties[i]);
                String cellValue = ""; 
                if(o==null) cellValue = "";
                else if(o instanceof Date) cellValue = new SimpleDateFormat(datePattern).format(o);
                else if(o instanceof Float || o instanceof Double) 
                    cellValue= new BigDecimal(o.toString()).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
                else cellValue = o.toString();

                newCell.setCellValue(cellValue);
                newCell.setCellStyle(cellStyle);
            }
            rowIndex++;
        }
        // 自动调整宽度
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/
        try {
            workbook.write(out);
            workbook.close();
            workbook.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
