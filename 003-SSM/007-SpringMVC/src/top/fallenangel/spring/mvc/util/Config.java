package top.fallenangel.spring.mvc.util;

import java.util.ResourceBundle;

public class Config {
    private static final ResourceBundle config;
    public static String uploadImgPath;

    static {
        config = ResourceBundle.getBundle("config");
        uploadImgPath = config.getString("upload_img_path");
    }
}