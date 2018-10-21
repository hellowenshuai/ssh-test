package com.fuji.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PropertyFactorys {

    /** 日志 */
    private static Logger sLogger = (Logger) LogManager
            .getLogger(PropertyFactorys.class);

    private PropertyFactorys() {
    }

    /**
     * 错误信息属性文件取得处理
     *
     * @return 错误信息属性
     */
    public static Properties getMessageProperties() {
        return getProperties("/errorMessage.properties");
    }

    /**
     * 上传路径属性文件取得处理
     *
     * @return 上传路径属性
     */
    public static Properties getPathProperties() {
        return getProperties("/path.properties");
    }

    /**
     * 属性取得
     *
     * @param proFile
     *            属性文件名
     * @return 属性对象
     */
    private static Properties getProperties(String proFile) {

        Properties pp = null;

        try {
            InputStream in = PropertyFactorys.class.getClassLoader()
                    .getResourceAsStream(proFile);
            pp = new Properties();
            pp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            sLogger.error(e.getStackTrace());
        }

        return pp;
    }

}
