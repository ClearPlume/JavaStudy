package top.fallenangel.spring.mvc.util;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import top.fallenangel.spring.mvc.entity.UploadResult;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Util {
    private static final Logger logger;

    static {
        logger = Logger.getLogger("系统日志");
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static void debug(Object msg) {
        logger.debug(msg);
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static UploadResult uploadFile(MultipartFile file) {
        UploadResult result = new UploadResult();

        if (file != null && file.getSize() > 0) {
            String originalAvatarName = file.getOriginalFilename();
            assert originalAvatarName != null;
            result.setFileName(Util.uuid() + originalAvatarName.substring(originalAvatarName.lastIndexOf('.')));
            result.setPath("/upload/img");

            try {
                file.transferTo(new File(Config.uploadImgPath + File.separatorChar + result.getFileName()));
                result.setSuccess(true);
                result.setMsg("文件上传成功");
                result.setFileSize(file.getSize());
            } catch (IOException e) {
                result.setSuccess(false);
                result.setMsg("文件上传失败");
                e.printStackTrace();
            }
            debug(result.getMsg());
        } else {
            debug("未选择文件或文件大小为零");
        }
        return result;
    }

    public static void deleteFile(String fileName) {
        File file = new File(Config.uploadImgPath + File.separatorChar + fileName);
        if (file.exists()) {
            debug("旧文件删除" + (file.delete() ? "成功" : "失败"));
        }
    }
}