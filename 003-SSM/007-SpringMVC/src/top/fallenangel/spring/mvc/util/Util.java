package top.fallenangel.spring.mvc.util;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Util {
    private static final Logger logger;

    static {
        logger = Logger.getLogger("系统日志");
    }

    public static void debug(Object msg) {
        logger.debug(msg);
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String upload(MultipartFile file) {
        String fileName = "";

        if (file != null && file.getSize() > 0) {
            String originalAvatarName = file.getOriginalFilename();
            assert originalAvatarName != null;
            fileName = Util.uuid() + originalAvatarName.substring(originalAvatarName.lastIndexOf('.'));

            try {
                file.transferTo(new File(Config.uploadImgPath + File.separatorChar + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }

    public static void delete(String fileName) {
        File file = new File(Config.uploadImgPath + File.separatorChar + fileName);
        if (file.exists()) {
            debug("旧文件删除" + (file.delete() ? "成功" : "失败"));
        }
    }
}