package com.example.project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.json.JSONObject;


public class PdfSomainUtil {

    public static void DownloadPdf() {
        List<HiController> list=new ArrayList<HiController>();
        for (int i=0;i<100;i++){
            list.add(new HiController());
        }
        File file = new File("E:/xiazai/itext.pdf");//文件名为itext.pdf， 默认路径下。
        Document document = new Document();
        BaseFont bf = null;
        Font fontChinese = null;
        Font fontChar=new Font();
        fontChar.setSize(7);
        fontChar.setColor(BaseColor.DARK_GRAY);
        try {
            bf = BaseFont.createFont(
                    "E:\\xiazai\\STKAITI.TTF",//windows自带的字体文件,我放在了resource文件下
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            fontChinese = new Font(bf, 10, Font.NORMAL);// 中文字体
            fontChinese.setSize(8);//字体大小
            PdfWriter pdfWriter=PdfWriter.getInstance(document, new FileOutputStream(file));// 文档输出流。
            Paragraph par3=new Paragraph("这就是标题含义",fontChinese);
            //设置局中对齐
            par3.setAlignment(Element.ALIGN_CENTER);
            document.open();
            document.add(par3);
            Paragraph par4=new Paragraph(new Date()+"",fontChinese);
            //设置局右对齐
            par4.setAlignment(Element.ALIGN_RIGHT);
            document.add(par4);
            document.addTitle("这是标题");
            PdfPTable table = new PdfPTable(new float[] {28,19, 15,27, 12,15, 14, 16});// 8列的表格以及单元格的宽度。
            //table.setPaddingTop(2);// 顶部空白区高度
            table.setTotalWidth(360);//表格整体宽度
            //PdfPCell cell;
            //cell = new PdfPCell(new Phrase("Details of past one month on sale."));



            //cell.setColspan(8);//占据八列
            //cell.setRowspan(2);
            //table.addCell(cell);
            table.addCell(new Paragraph("销售单号", fontChinese));
            table.addCell(new Paragraph("客户编号", fontChinese));
            table.addCell(new Paragraph("客户名称", fontChinese));
            table.addCell(new Paragraph("销售日期", fontChinese));
            table.addCell(new Paragraph("经手人", fontChinese));
            table.addCell(new Paragraph("总金额", fontChinese));
            table.addCell(new Paragraph("预付款", fontChinese));
            table.addCell(new Paragraph("购买方式", fontChinese));
            for(HiController s :list){//将集合内的对象循环写入到表格
                table.addCell(new Paragraph("1q2w3e4r5t",fontChar));
                table.addCell(new Paragraph("第二asdasdasd类",fontChinese));
                table.addCell(new Paragraph("第二asasdad类",fontChinese));
                table.addCell(new Paragraph("第二adasdas类",fontChinese));
                table.addCell(new Paragraph("第二类",fontChar));
                table.addCell(new Paragraph(String.valueOf(7),fontChar));
                table.addCell(new Paragraph(String.valueOf(7),fontChar));
                if(Integer.parseInt("1")==1){
                    table.addCell(new Paragraph("预付款发货", fontChinese));
                }else if(Integer.parseInt("0")==0){
                    table.addCell(new Paragraph("货到付款", fontChinese));
                }else{
                    table.addCell(new Paragraph("款到发货", fontChinese));
                }
            }





            document.add(table);
            document.close();
            pdfWriter.flush();
            System.out.println("document itext pdf write finished...100%");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void druidTest() throws IOException, DocumentException {

        String title="This is a  pigdog";
        String year_month="月份";


        String sum_suff="合计件数：  服务件数：  操作人：万事屋"+"  打印日期："+ new SimpleDateFormat("yyyy-MM-dd").format(new Date());;
        BaseFont baseFontChinese = BaseFont.createFont("E:\\xiazai\\STKAITI.TTF",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font fontChinese =  new  Font(baseFontChinese , 12 , Font.NORMAL);
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

        Paragraph par3=new Paragraph(title,fontChinese);
        //设置局中对齐
        par3.setAlignment(Element.ALIGN_CENTER);
        document.add(par3);
        Paragraph par4=new Paragraph(year_month,fontChinese);
        //设置局右对齐
        par4.setAlignment(Element.ALIGN_RIGHT);
        document.add(par4);
        // 3列的表.
        PdfPTable table = new PdfPTable(15);
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f); // 前间距
        table.setSpacingAfter(10f); // 后间距
        List<PdfPRow> listRow = table.getRows();
        //设置列宽
        //float[] columnWidths = { 2f, 3f, 3f, 3f, 3f, 3f, 5f, 8f, 8f, 3f, 3f, 3f, 3f, 3f, 5f};
       int [] columnWidths = { 4,6,6,6,10,6,6,6,11,11,6,6,6,6,6,8,9};
        try {
            table.setWidths(columnWidths);
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //行1
        PdfPCell cells1[]= new PdfPCell[15];
        PdfPRow row1 = new PdfPRow(cells1);
        //单元格

        cells1[0] = new PdfPCell(new Paragraph("序号",fontChinese));//单元格内容
        cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[1] = new PdfPCell(new Paragraph("机构代码",fontChinese));
        cells1[2] = new PdfPCell(new Paragraph("档案类型",fontChinese));
        cells1[3] = new PdfPCell(new Paragraph("渠道",fontChinese));
        cells1[4] = new PdfPCell(new Paragraph("应交日期",fontChinese));
        cells1[5] = new PdfPCell(new Paragraph("保单号",fontChinese));
        cells1[6] = new PdfPCell(new Paragraph("投保人",fontChinese));
        cells1[7] = new PdfPCell(new Paragraph("交次",fontChinese));
        cells1[8] = new PdfPCell(new Paragraph("电话次数",fontChinese));
        cells1[9] = new PdfPCell(new Paragraph("面访次数",fontChinese));
        cells1[10] = new PdfPCell(new Paragraph("IM次数",fontChinese));
        cells1[11] = new PdfPCell(new Paragraph("电子签名",fontChinese));
        cells1[12] = new PdfPCell(new Paragraph("GPS定位",fontChinese));
        cells1[13] = new PdfPCell(new Paragraph("上传图片",fontChinese));
        cells1[14] = new PdfPCell(new Paragraph("续期人员",fontChinese));
        //把第一行添加到集合
        listRow.add(row1);
        String formatDate="";
        for (int i=0;i<100;i++) {
            //EvalArchiveInfo evalArchiveInfo = list.get(i);
            //行1
            PdfPCell cells[]= new PdfPCell[15];
            PdfPRow row = new PdfPRow(cells);
            //单元格
            int number =i+1;
            cells[0] = new PdfPCell(new Paragraph(number+"",fontChinese));//单元格内容
            cells[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
            cells[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

            cells[1] = new PdfPCell(new Paragraph("中国人呢",fontChinese));
            cells[2] = new PdfPCell(new Paragraph("中国人呢2",fontChinese));
            cells[3] = new PdfPCell(new Paragraph("中国人呢3",fontChinese));
            cells[4] = new PdfPCell(new Paragraph("中国人呢233",fontChinese));
            cells[5] = new PdfPCell(new Paragraph("中国人2呢",fontChinese));
            cells[6] = new PdfPCell(new Paragraph("中国1人呢",fontChinese));
            cells[7] = new PdfPCell(new Paragraph("1",fontChinese));
            cells[8] = new PdfPCell(new Paragraph("中国人呢喝哈哈",fontChinese));
            cells[9] = new PdfPCell(new Paragraph("中国人呢",fontChinese));
            cells[10] = new PdfPCell(new Paragraph("中国人呢",fontChinese));
            cells[11] = new PdfPCell(new Paragraph("中国人呢",fontChinese));
            cells[12] = new PdfPCell(new Paragraph("中国人呢",fontChinese));
            cells[13] = new PdfPCell(new Paragraph("中国人呢",fontChinese));
            cells[14] = new PdfPCell(new Paragraph("中国人呢",fontChinese));
            listRow.add(row);
        }

        //把表格添加到文件中
        document.add(table);
        //添加操作人，总条数，打印时间
        Paragraph par5=new Paragraph(sum_suff,fontChinese);
        //设置局右对齐
        par5.setAlignment(Element.ALIGN_RIGHT);
        document.add(par5);
        //关闭文档
        document.close();
        //关闭书写器
        writer.close();


    }
public static void main(String[] args) {
    try {
        //DownloadPdf();
        druidTest();
        List<HiController> list=new ArrayList<>();
        for (int i=0;i<3;i++){
            HiController hiController=new HiController();
            hiController.setId(i);
            hiController.setA('c');
            hiController.setName("这是名字几："+i);
            list.add(hiController);
        }
        String str=JSON.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(str);
        JSONArray jsonArray =JSON.parseArray(str);
        for(int i=0;i<jsonArray.size();i++){
            System.out.println(jsonArray.get(i));
            String s=JSON.toJSONString(jsonArray.get(i), SerializerFeature.WriteDateUseDateFormat);
            JSONObject json = new JSONObject(s);
            System.out.println(json.get("name"));
        }

        System.out.println("分隔符");
        System.out.println(jsonArray);

        Double a=-1.333;
        Integer aa=-1;
        System.out.println(a+aa);
    } catch (Exception e) {
        e.printStackTrace();
    }
}



}
