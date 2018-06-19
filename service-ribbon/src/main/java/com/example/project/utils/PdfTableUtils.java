package com.example.project.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.project.controller.PdfTableBean;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PdfTableUtils {

public String DownloadPdf(PdfTableBean pdfTableBean) throws IOException, DocumentException {

    String title=pdfTableBean.getTitle();
    String right_title=pdfTableBean.getRightTitle();
    int columnsNum=pdfTableBean.getHead().length+1;
    //底部标题
    String sum_suff=pdfTableBean.getBottomTitle();

    BaseFont baseFontChinese = BaseFont.createFont("E:\\xiazai\\STKAITI.TTF",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Font fontChinese =  new  Font(baseFontChinese , pdfTableBean.getFontSize() , Font.NORMAL);
    //创建文件
    Document document = new Document();
    String url="E:\\xiazai\\";//存放地址
    File file = new File(url);
    if(!file.exists()){
        file.mkdir();
    };
    String path=url+new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date())+".pdf";
    File file2 = new File(path);
    //建立一个书写器
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file2));
    //打开文件
    document.open();

    //主标题不为空输出
    if (title!=null&&!"".equals(title)){
        Paragraph par3=new Paragraph(title,fontChinese);
        //设置局中对齐
        par3.setAlignment(Element.ALIGN_CENTER);
        document.add(par3);
    }
    if (right_title!=null&&!"".equals(right_title)){
        Paragraph par4=new Paragraph(right_title,fontChinese);
        //设置局右对齐
        par4.setAlignment(Element.ALIGN_RIGHT);
        document.add(par4);
    }
    PdfPTable table = new PdfPTable(columnsNum);
    table.setWidthPercentage(100); // 宽度100%填充
    table.setSpacingBefore(10f); // 前间距
    table.setSpacingAfter(10f); // 后间距
    List<PdfPRow> listRow = table.getRows();
    //设置列宽
    //float[] columnWidths = { 2f, 3f, 3f, 3f, 3f, 3f, 5f, 8f, 8f, 3f, 3f, 3f, 3f, 3f, 5f};
    int [] columnWidths=new int[pdfTableBean.getColumnWidths().length+1];
    columnWidths[0]=4;
    for (int i=0;i<pdfTableBean.getColumnWidths().length;i++){
        columnWidths[i+1]= pdfTableBean.getColumnWidths()[i];
    }
    try {
        table.setWidths(columnWidths);
    } catch (DocumentException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    //设置第一行 表头
    PdfPCell cells1[]= new PdfPCell[columnsNum];
    PdfPRow row1 = new PdfPRow(cells1);
    cells1[0] = new PdfPCell(new Paragraph("序号",fontChinese));//单元格内容
    cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
    cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
    cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
    for (int i=0;i<pdfTableBean.getHead().length;i++){
        cells1[i+1] = new PdfPCell(new Paragraph(pdfTableBean.getHead()[i],fontChinese));
    }
    listRow.add(row1);

    //下为把内容添加进单元格
    String list=JSON.toJSONString(pdfTableBean.getList(), SerializerFeature.WriteDateUseDateFormat);
    JSONArray jsonArray =JSON.parseArray(list);
    for (int i=0;i<jsonArray.size();i++) {
        //EvalArchiveInfo evalArchiveInfo = list.get(i);
        //行1
        PdfPCell cells[]= new PdfPCell[columnsNum];
        PdfPRow row = new PdfPRow(cells);
        //单元格
        int number =i+1;
        cells[0] = new PdfPCell(new Paragraph(number+"",fontChinese));//单元格内容
        cells[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
        for (int j=0;j<pdfTableBean.getAttribute().length;i++){
            cells[j+1] = new PdfPCell(new Paragraph(pdfTableBean.getAttribute()[j],fontChinese));
        }
        listRow.add(row);
    }

    //把表格添加到文件中
    document.add(table);
    if (!"".equals(sum_suff)&&sum_suff!=null){
        //添加操作人，总条数，打印时间
        Paragraph par5=new Paragraph(sum_suff,fontChinese);
        //设置局右对齐
        par5.setAlignment(Element.ALIGN_RIGHT);
        document.add(par5);
    }
    //关闭文档
    document.close();
    //关闭书写器
    writer.close();
return null;
}
    private static int[] insertElement(int original[], int element, int index) {
    int length = original.length;
    int destination[] = new int[length + 1];
    System.arraycopy(original, 0, destination, 0, index);
    destination[index] = element;
    System.arraycopy(original, index, destination, index + 1, length - index);
    return destination;
}
}
