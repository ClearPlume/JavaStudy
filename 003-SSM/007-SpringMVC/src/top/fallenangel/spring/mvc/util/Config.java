package top.fallenangel.spring.mvc.util;

import java.util.ResourceBundle;

public class Config {
    private static final ResourceBundle config;
    public static String uploadRootPath;
    public static String uploadWebRoot;

    static {
        config = ResourceBundle.getBundle("config");
        uploadRootPath = config.getString("upload_root_path");
        uploadWebRoot = config.getString("upload_web_root");
    }
}