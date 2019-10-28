/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.io.OutputStream;
			  import java.util.ArrayList;

/*  22:    */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*  23:    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*  24:    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*  25:    */ 
/*  26:    */ public class ExportExcel2<T>
/*  27:    */ {
/*  28:    */   public void exportExcel(ArrayList<StuSubTeaBean> dataset, OutputStream out)
/*  29:    */   {
/*  30: 28 */     exportExcel("测试POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void exportExcel(String[] headers, ArrayList<StuSubTeaBean> dataset, OutputStream out)
/*  34:    */   {
/*  35: 33 */     System.out.println(dataset.size());
/*  36: 34 */     exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void exportExcel(String[] headers, ArrayList<StuSubTeaBean> dataset, OutputStream out, String pattern)
/*  40:    */   {
/*  41: 39 */     exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void exportExcel(String title, String[] headers, ArrayList<StuSubTeaBean> dataset, OutputStream out, String pattern)
/*  45:    */   {
/*  46: 61 */   
					HSSFWorkbook workbook = new HSSFWorkbook();
					//创建一张表
				
					
					//创建一张表
					ArrayList<StuSubTeaBean> a = dataset;
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
						if(a.get(row).getChoose() == 1) {
							shenhe="命中";
						}else {
							shenhe="未命中";
						}
						String zhiyuan1 = null;
						if(a.get(row).getWish()==1) {
							zhiyuan1="第一志愿";
						}else if(a.get(row).getWish()==2){
							zhiyuan1="第二志愿";
						}else if(a.get(row).getWish()==3){
							zhiyuan1="第三志愿";
						}else if(a.get(row).getWish()==4){
							zhiyuan1="第四志愿";
						}else if(a.get(row).getWish()==5){
							zhiyuan1="第五志愿";
						}else if(a.get(row).getWish()==6){
							zhiyuan1="第六志愿";
						}else {
							zhiyuan1="管理员分配";
						}
						
						String zhiyuan2 = null;
						if(a.get(row).getState()==1) {
							zhiyuan2="第一志愿";
						}else if(a.get(row).getState()==2){
							zhiyuan2="第二志愿";
						}else if(a.get(row).getState()==3){
							zhiyuan2="第三志愿";
						}else {
							zhiyuan2="管理员分配";
						}
						
						//"班级序号", "题目编号", "学生选择志愿", "学生姓名", "教师姓名", "题目", "老师分配志愿", "备注", "是否选中"
						rows.createCell(0).setCellValue(row + 1);
						rows.createCell(1).setCellValue(a.get(row).getSubId());
						rows.createCell(2).setCellValue(a.get(row).getSubTitle());
						rows.createCell(3).setCellValue(a.get(row).getStuName());
						rows.createCell(4).setCellValue(a.get(row).getStuId());
						rows.createCell(5).setCellValue(zhiyuan1);
						rows.createCell(6).setCellValue(a.get(row).getTeaName());
						rows.createCell(7).setCellValue(zhiyuan2);
						rows.createCell(8).setCellValue(shenhe);
									
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