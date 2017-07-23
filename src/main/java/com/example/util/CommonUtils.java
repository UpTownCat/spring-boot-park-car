package com.example.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/7/8.
 */
public class CommonUtils {
    private CommonUtils(){};

    /**
     * 把Iterable转换为List
     * @param iterable
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(Iterable<T> iterable) {
        List<T> items = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            items.add(t);
        }
        return items;
    }

    /**
     * 保存文件
     * @param path
     * @param file
     * @return
     * @throws IOException
     */
    public static String savePhoto(String path, MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        filename = System.currentTimeMillis() + "" + new Random().nextInt(10000) + "park" + filename.substring(filename.lastIndexOf("."));
        File toFile = new File(path + filename);
        file.transferTo(toFile);
        return filename;
    }

    /**
     * 把iterator转换为list
     * @param iterator
     * @param <T>
     * @return
     */
    public static <T> List<T> iteratorToList(Iterator<T> iterator) {
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * 打印信息
     * @param objects
     */
    public static void printMessage(Object ... objects) {
        for(int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 获得分页sql
     * @param index
     * @param size
     * @param order
     * @return
     */
    public static String getPageSql(int index, int size, String order) {
        String str = " limit " + (index - 1) * size + " , " + size;
        if(order != null)
            str = str + "  " + order;
        return str;
    }

    /**
     * 获取下标
     * @param index
     * @return
     */
    public static int getPageIndex(String index) {
        int page = 1;
        try{
            page = Integer.parseInt(index);
        }catch (Exception e) {
            page = 1;
        }
        return page - 1;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if(str == null || str.trim().length() == 0)
            return true;
        return false;
    }

    public static Date toDate(String str) {
        if(str == null || str.trim().length() == 0)
            return null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return format.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

}
