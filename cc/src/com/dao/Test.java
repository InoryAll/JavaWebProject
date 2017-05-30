package com.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.entity.Teacher;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		TeacherDao td = new TeacherDao();
//		Teacher t = new Teacher();
//		t.setId("12345678");
//		t.setName("jianghaifeng");
//		t.setBirthday("1995-04-19");
//		t.setGoodfield("123");
//		td.insert(t);
	    new Test().start();
	}

	private void start() {
		// TODO Auto-generated method stub
		TeacherDao td = new TeacherDao();
		List<Teacher> listInside = td.findAllTeacher("0",0, -1);
		List<Teacher> listOutside = td.findAllTeacher("1",0, -1);
		try {
			//输出的excel的路径
			String filePath = "D:\\test.xls";
			//创建Excel工作簿
			WritableWorkbook wwb;
			//新建一个jxl文件
			OutputStream os = new FileOutputStream(filePath);
			wwb = Workbook.createWorkbook(os);
			//添加一个工作表并设置一个sheet的名字
			WritableSheet sheet1 = wwb.createSheet("校外导师", 0);
			WritableSheet sheet2 = wwb.createSheet("校内导师", 1);
			Label label;
			
			
			/* 
             * 合并单元格 
             * 通过writablesheet.mergeCells(int x,int y,int m,int n);来实现的 
              * 表示将从第x+1列，y+1行到m+1列，n+1行合并 
             *   
             * */
			//对两个 sheet，set header
			String[] title = {"姓名","性别","出生年月","民族","职称","工作单位","擅长领域","备注"};
			sheet1.mergeCells(0, 0, 7, 0);
			label = new Label(0,0,"大连大学创新创业导师库（校外）",getTitle());
			sheet1.addCell(label);
			
			sheet2.mergeCells(0, 0, 7, 0);
			label = new Label(0,0,"大连大学创新创业导师库（校内）",getTitle());
			sheet2.addCell(label);
		
			
			//对两个sheet，set title
			label = new Label(0,1,"");
			sheet1.addCell(label);
			for(int i=0;i<title.length;i++){
				//Label(x,y,z) 代表单元格的第x+1列，第y+1行，内容z
				//在Label对象的子对象中指明单元格的位置和内容
				label = new Label(i+1,1,title[i],getHeader());
				sheet1.addCell(label);
			}
			
			label = new Label(0,1,"");
			sheet2.addCell(label);
			for(int i=0;i<title.length;i++){
				//Label(x,y,z) 代表单元格的第x+1列，第y+1行，内容z
				//在Label对象的子对象中指明单元格的位置和内容
				label = new Label(i+1,1,title[i],getHeader());
				sheet2.addCell(label);
			}
			Teacher teacher = null;
			//对两个sheet,set content
			for(int j=0;j<listOutside.size();j++){
				teacher = listOutside.get(j);
				label = new Label(0,j+2,(j+1)+"",getContent());
				sheet1.addCell(label);
				
				label = new Label(1,j+2,teacher.getName(),getContent());
				sheet1.addCell(label);
				label = new Label(2,j+2,teacher.getGender(),getContent());
				sheet1.addCell(label);
				label = new Label(3,j+2,teacher.getBirthday(),getContent());
				sheet1.addCell(label);
				label = new Label(4,j+2,teacher.getNation(),getContent());
				sheet1.addCell(label);
				label = new Label(5,j+2,teacher.getTitle(),getContent());
				sheet1.addCell(label);
				label = new Label(6,j+2,teacher.getDepartment(),getContent());
				sheet1.addCell(label);
				label = new Label(7,j+2,teacher.getGoodfield(),getContent());
				sheet1.addCell(label);
				label = new Label(8,j+2,teacher.getInfo1()+"、"+teacher.getInfo2()+"、"+teacher.getInfo3(),getContent());
				sheet1.addCell(label);
			}
			
			for(int j=0;j<listInside.size();j++){
				teacher = listInside.get(j);
				label = new Label(0,j+2,(j+1)+"",getContent());
				sheet2.addCell(label);
				
				label = new Label(1,j+2,teacher.getName(),getContent());
				sheet2.addCell(label);
				label = new Label(2,j+2,teacher.getGender(),getContent());
				sheet2.addCell(label);
				label = new Label(3,j+2,teacher.getBirthday(),getContent());
				sheet2.addCell(label);
				label = new Label(4,j+2,teacher.getNation(),getContent());
				sheet2.addCell(label);
				label = new Label(5,j+2,teacher.getTitle(),getContent());
				sheet2.addCell(label);
				label = new Label(6,j+2,teacher.getDepartment(),getContent());
				sheet2.addCell(label);
				label = new Label(7,j+2,teacher.getGoodfield(),getContent());
				sheet2.addCell(label);
				label = new Label(8,j+2,teacher.getInfo1()+"、"+teacher.getInfo2()+"、"+teacher.getInfo3(),getContent());
				sheet2.addCell(label);
			}
			

			wwb.write();
			wwb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WritableCellFormat getTitle(){
		   WritableFont font = new  WritableFont(WritableFont.ARIAL, 22 ,WritableFont.BOLD);//定义字体
		   try {
		    font.setColour(Colour.BLACK);//颜色
		   } catch (WriteException e1) {
		    // TODO 自动生成 catch 块
		    e1.printStackTrace();
		   }
		   WritableCellFormat format = new  WritableCellFormat(font);
		   try {
		    format.setAlignment(jxl.format.Alignment.CENTRE);//左右居中
		    format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//上下居中
		   } catch (WriteException e) {
		    // TODO 自动生成 catch 块
		    e.printStackTrace();
		   }
		   return format;
	}
	public static WritableCellFormat getHeader(){
		   WritableFont font = new  WritableFont(WritableFont.ARIAL, 11 ,WritableFont.BOLD);//定义字体
		   try {
		    font.setColour(Colour.BLACK);//蓝色字体
		   } catch (WriteException e1) {
		    // TODO 自动生成 catch 块
		    e1.printStackTrace();
		   }
		   WritableCellFormat format = new  WritableCellFormat(font);
		   try {
		    format.setAlignment(jxl.format.Alignment.CENTRE);//左右居中
		    format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//上下居中
		    format.setBorder(Border.ALL,BorderLineStyle.THIN,Colour.BLACK);//黑色边框
		   } catch (WriteException e) {
		    // TODO 自动生成 catch 块
		    e.printStackTrace();
		   }
		   return format;
	}
	public static WritableCellFormat getContent(){
		   WritableFont font = new  WritableFont(WritableFont.ARIAL, 11);//定义字体
		   try {
		    font.setColour(Colour.BLACK);//颜色
		   } catch (WriteException e1) {
		    // TODO 自动生成 catch 块
		    e1.printStackTrace();
		   }
		   WritableCellFormat format = new  WritableCellFormat(font);
		   try {
		    format.setAlignment(jxl.format.Alignment.CENTRE);//左右居中
		    format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//上下居中
		    format.setBorder(Border.ALL,BorderLineStyle.THIN,Colour.BLACK);//黑色边框
		   } catch (WriteException e) {
		    // TODO 自动生成 catch 块
		    e.printStackTrace();
		   }
		   return format;
	}

}
