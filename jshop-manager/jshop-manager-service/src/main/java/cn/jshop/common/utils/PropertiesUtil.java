package cn.jshop.common.utils;


import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Properties;

/**
 * Created by 郭旭辉 on 2016/4/1.
 * 配置文件读取类
 */
public class PropertiesUtil {

    public Properties getProp4Config(String file){
        Properties properties = null;
        InputStream in = null;
        try {
            in = getClass().getResourceAsStream(file);
            InputStreamReader reader = new InputStreamReader(in, "utf-8");
            properties = new Properties();
            properties.load(reader);

        }catch (Exception e){
            throw new RuntimeException("配置文件读取失败");
        }finally {
            try {
                if (in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static  void addProperties(String key[], String value[], String file){
        Properties iniFile = getProperties(file);
        FileOutputStream oFile = null;
        try {
            iniFile.put(key, value);
            oFile = new FileOutputStream(file, true);
            iniFile.store(oFile, "modify properties file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oFile != null) {
                    oFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取配置文件
     * @param file 配置文件路径
     * @return
     */
    public static Properties getProperties(String file){
        Properties properties = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return properties;
    }

    /**
     * 保存属性到配置文件中
     * @param properties
     * @param file
     */
    public static void saveProperties(Properties properties, String file){
        if (properties == null){
            return;
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file, false);
            properties.store(out, "修改配置文件");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 修改属性文件
     * @param key
     * @param value
     * @param file
     */
    public static  void updateProperties(String key, String value, String file){
        if (StringUtils.isEmpty(key)){
            return;
        }
        Properties properties = getProperties(file);
        if (properties == null){
            properties = new Properties();
        }
        properties.put(key ,value);

        //保存属性到文件中
        saveProperties(properties, file);
    }
    public static void main(String[] args){
//        System.out.println(getProperties("/sysConfig/sms-config.properties").get("is_test"));
        String ignoreUrl = new PropertiesUtil().getProp4Config("/sysConfig/ignoreUrl-config.properties").getProperty("IGNOREURL");
        String[] url = ignoreUrl.split(",");
        System.out.println();
    }
}
