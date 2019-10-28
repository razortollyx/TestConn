/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.io.OutputStream;
			  import java.util.ArrayList;

/*  22:    */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*  23:    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*  24:    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*  25:    */ 
/*  26:    */ public class ExportExcel<T>
/*  27:    */ {
/*  28:    */   public void exportExcel(ArrayList<SubjectBean> dataset, OutputStream out)
/*  29:    */   {
/*  30: 28 */     exportExcel("测试POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void exportExcel(String[] headers, ArrayList<SubjectBean> dataset, OutputStream out)
/*  34:    */   {
/*  35: 33 */     System.out.println(dataset.size());
/*  36: 34 */     exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void exportExcel(String[] headers, ArrayList<SubjectBean> dataset, OutputStream out, String pattern)
/*  40:    */   {
/*  41: 39 */     exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void exportExcel(String title, String[] headers, ArrayList<SubjectBean> dataset, OutputStream out, String pattern)
/*  45:    */   {
/*  46: 61 */   
					HSSFWorkbook workbook = new HSSFWorkbook();
					//创建一张表
				
					
					//创建一张表
					ArrayList<SubjectBean> a = dataset;
					HSSFSheet sheet = workbook.createSheet("导出结果");
					String[] columnNames = headers ;
					HSSFRow firstRow = sheet.createRow(0);
					for (int i = 0; i < columnNames.length; i++) {
						firstRow.createCell(i + 1).setCellValue((String) columnNames[i]);
					}
					//向工作簿写入数据
			
					for (int row = 0; row < a.size(); row++) {		
						HSSFRow rows = sheet.createRow(row + 1);
						//设置第一列数据为数据行数
						String shenhe = null;
						if(a.get(row).getState()==1) {
							shenhe="已审核";
						}else if(a.get(row).getState()==0){
							shenhe="未审核";
						}else {
							shenhe="审核未通过";
						}
						rows.createCell(0).setCellValue(row + 1);
						rows.createCell(1).setCellValue(a.get(row).getId());
						rows.createCell(2).setCellValue(a.get(row).getTitle());
						rows.createCell(3).setCellValue(a.get(row).getTeacher());
						rows.createCell(4).setCellValue(a.get(row).getDirection());
						rows.createCell(5).setCellValue(a.get(row).getIntroduction());
						rows.createCell(6).setCellValue(a.get(row).getSchedule());
						rows.createCell(7).setCellValue(a.get(row).getReference());
						rows.createCell(8).setCellValue(a.get(row).getRequirement());
						rows.createCell(9).setCellValue(shenhe);
						rows.createCell(10).setCellValue(a.get(row).getKey());
						rows.createCell(11).setCellValue(a.get(row).getYuanxi());			
					}	
				  
/* 207:    */     try
/* 208:    */     {
/* 209:211 */       workbook.write(out);
/* 210:    */     }
/* 211:    */     catch (IOException e)
/* 212:    */     {
/* 213:214 */       e.printStackTrace();
/* 214:    */     }
				  
/* 215:    */   }
				

				
/* 216:    */   
/* 217:    */   public static void main(String[] args) {}
/* 218:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.ExportExcel
 * JD-Core Version:    0.7.0.1
 */