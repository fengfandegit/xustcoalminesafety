package com.xust.service;

import com.xust.dao.AverageDao;
import com.xust.utils.RedisPoll;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 10045 on 2018/5/22.
 */
@Service
@MapperScan("com.xust.dao")
@ComponentScan(basePackages={"com.xust.dao"})
public class HistoryService {
    private static final Logger log = Logger.getLogger(HistoryService.class);
    public void insertHistoryData(MultipartFile  file){

        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        List<String[]> Stringlist = new ArrayList<String[]>();
        int count = 0;
        if(workbook != null){
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum  = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getLastCellNum();
                    String[] cells = new String[row.getLastCellNum()];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
/*                        System.out.println("cells[cellNum]:"+cells[cellNum]+"cell:"+cell);*/
                    }
                    list.add(cells);
                    Stringlist.add(cells);
                }
            }
        }
        List<String[]> list1 = list;
        List<String[]> list2 = list;
        Map<String,String> map = new LinkedHashMap<>();
        Map<String,String> map2 = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                System.out.println(list.get(i)[j]);
            }
            list2.get(i)[4] = list.get(i)[4].replaceAll("-","_");
            list2.get(i)[4] = list2.get(i)[4].replaceAll(":","_");
            list2.get(i)[4] = list2.get(i)[4].replaceAll(" ","_");
            list1.get(i)[4] = Stringlist.get(i)[4].replaceAll("-","");
            list1.get(i)[4] = list1.get(i)[4].replaceAll(":","_");
            list1.get(i)[4] = list1.get(i)[4].replaceAll(" ","_");
/*            map.put(list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2],
                    list2.get(i)[4]+"/"+list2.get(i)[3]);*/
            String a[] = list2.get(i)[4].split("_");
            /*a[0]+""+a[1]+""+a[2];*/
                if (map.size()==0){
                    map2.put(list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2]+"_"+a[0]+""+a[1]+""+a[2],list2.get(i)[4]+"/"+list2.get(i)[3]);
                }
                if (map.size()>0){
                    for(Map.Entry entry:map.entrySet()) {
                    if ((list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2]+"_"+a[0]+""+a[1]+""+a[2]).equals((String) entry.getKey())){
                        String s100 = map.get(list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2]+"_"+a[0]+""+a[1]+""+a[2]);
                        StringBuilder stringBuilder = new StringBuilder(s100);
                        map2.put(list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2]+"_"+a[0]+""+a[1]+""+a[2],stringBuilder.append(","+list2.get(i)[4]+"/"+list2.get(i)[3]).toString());
                    }else{
                            count++;
           /*             for(Map.Entry entry1:map.entrySet()) {
                            if ((list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2]+"_"+a[0]+""+a[1]+""+a[2]).equals(entry1.getValue())){

                            }
                        }
                        if (i<=40)*/
                        /*System.out.println(entry.getKey()+":"+list2.get(i)[4]+"/"+list2.get(i)[3]);*/
 /*                       count++;
                        if (map.size()==count){
                            map.put(list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2],list2.get(i)[4]+"/"+list2.get(i)[3]);
                            count=0;
                            break;
                        }*/
                        /*                        map.remove(list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2]);*/
                    }
                }
                    if (count == map.size()){
                        map2.put(list1.get(i)[0]+"_"+list1.get(i)[1]+"_"+list1.get(i)[2]+"_"+a[0]+""+a[1]+""+a[2],list2.get(i)[4]+"/"+list2.get(i)[3]);
                        count = 0;
                    }
                }
            for (Map.Entry entry:map2.entrySet()
                 ) {
                map.put((String) entry.getKey(),(String) entry.getValue());
                System.out.println("key:"+(String) entry.getKey()+"value:"+(String) entry.getValue());
            }
            for (Map.Entry entry:map2.entrySet()
                    ) {
                map2.remove(entry.getKey());
                count = 0;
            }
            System.out.println("ok");
        }
        System.out.println("start:");
        for (String key:map.keySet()) {
            System.out.println(key+"!!!!!!"+map.get(key));
        }
        Jedis jedis = null;
        try{
            jedis = RedisPoll.getResource();
            for (String key:map.keySet()){
                if (jedis.exists(key) == false){
                    //写入
                    jedis.set(key,map.get(key));
                }else{
                    String s = jedis.get(key);
                    StringBuilder stringBuilder = new StringBuilder(s);
                    jedis.set(key,stringBuilder.append(map.get(key)).toString());
                }
            }
            System.out.println("OK!!!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null) {
                jedis.close();
            }
        }
    }

    /**
     * key:站的编号_传感器类型_传感器编号
     * value:数据_时间
     * 检查文件
     * @param file
     * @throws IOException
     */
/*    public static  void checkFile(MultipartFile file) throws IOException {
        //判断文件是否存在
        if(null == file){
            log.error("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
            log.error(fileName + "不是excel文件");
        }
    }*/

    public static  Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007 及2007以上
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return workbook;
    }

    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = stringDateProcess(cell);
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    /**
     * 时间格式处理
     * @return
     * @author Liu Xin Nan
     * @data 2017年11月27日
     */
    public static String stringDateProcess(Cell cell){
        String result = new String();
        if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
            SimpleDateFormat sdf = null;
            if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                sdf = new SimpleDateFormat("HH:mm");
            } else {// 日期
                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
            Date date = cell.getDateCellValue();
            result = sdf.format(date);
        } else if (cell.getCellStyle().getDataFormat() == 58) {
            // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            double value = cell.getNumericCellValue();
            Date date = org.apache.poi.ss.usermodel.DateUtil
                    .getJavaDate(value);
            result = sdf.format(date);
        } else {
            double value = cell.getNumericCellValue();
            CellStyle style = cell.getCellStyle();
            DecimalFormat format = new DecimalFormat();
            String temp = style.getDataFormatString();
            // 单元格设置成常规
            if (temp.equals("General")) {
                format.applyPattern("#");
            }
            result = format.format(value);
        }

        return result;
    }
    /**
     * 获取历史数据
     */
/*    public Map<String,AverageDao[]> listHistory(String no, String type, String id, String starttime, String endtime){
        Map<String,AverageDao[]> map = new ReadRunService().getData(no,type,id,starttime,endtime);
    public Map<String,AverageDao[]> listHistory(String no, String type, String id, String starttime,
                                                String endtime,String black,boolean flag){
        Map<String,AverageDao[]> map = new ReadRunService().getData(no,type,id,starttime,endtime,black,flag);
        return map;
    }*/
    public Map<String,AverageDao[]> listpreHistory(String no, String type, String id, String starttime, String endtime){
/*        Map<String,AverageDao[]> map = new ReadRunService().getData(no,type,id,starttime,endtime);*/
        Map<String,AverageDao[]> map = new HashMap<>();
        return map;
    }
    public Map<String,AverageDao[]> listpreHistory(String no, String type, String id, String starttime,
                                                   String endtime,String black,boolean flag){
        Map<String,AverageDao[]> map = new ReadRunService().getData(no,type,id,starttime,endtime,black,flag);
        System.out.println("start");
        System.out.println("end");
        return map;
    }
/*    public static void main(String[] args){
        listpreHistory("1","1","1","20180330","20180401");
    }*/

}
