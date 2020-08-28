package com.wdkf.wdkfspringbootutils.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王品峰
 * @DateTime 2020/8/28 10:33
 * @Description
 */
public class FileUtils {
    /**
     * @Method: fileToArray
     * @Description: 将文件内容转成list
     * @param path 文件路径
     * @Return:
     * @Author: chenlu
     * @Date 2020/8/27 15:08
     * @Version:  1.0
     */
    public static List<String> fileToList(String path){
        File file = new File(path);
        List<String> resList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                String[] list =  s.split("\\s{1,}");
                for (int i = 0;i < list.length; i++){
                    resList.add(list[i]);
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resList;
    }

    public static void ListToFile(List<String> list,String path){
        File file = new File(path);
        List<String> resList = new ArrayList<>();
        try{
            FileWriter fw =  new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);//构造一个BufferedReader类来读取文件
            for (String item : list) {
                bw.write(item);
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
