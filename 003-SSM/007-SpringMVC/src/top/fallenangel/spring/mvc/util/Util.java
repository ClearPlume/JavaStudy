package top.fallenangel.spring.mvc.util;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import top.fallenangel.spring.mvc.controller.UserController;
import top.fallenangel.spring.mvc.entity.UploadResult;
import top.fallenangel.spring.mvc.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    public static UploadResult uploadFile(MultipartFile file, String savePath) {
        UploadResult result = new UploadResult();

        if (file != null && file.getSize() > 0) {
            String originalFileName = file.getOriginalFilename();
            result.setFileShowName(originalFileName);
            assert originalFileName != null;
            result.setFileRealName(uuid() + originalFileName.substring(originalFileName.lastIndexOf('.')));
            result.setPath(Config.uploadWebRoot + savePath);

            try {
                file.transferTo(new File(Config.uploadRootPath + File.separatorChar + savePath + File.separatorChar + result.getFileRealName()));
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

    public static void deleteFile(String fileName, String savePath) {
        File file = new File(Config.uploadRootPath + File.separatorChar + savePath + File.separatorChar + fileName);
        if (file.exists()) {
            debug("旧文件删除" + (file.delete() ? "成功" : "失败"));
        }
    }

    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public static HttpSession getCurrentSession() {
        return getCurrentRequest().getSession();
    }

    public static User getLoginUserFromSession() {
        return (User) getCurrentSession().getAttribute(UserController.LOGIN_USER);
    }

    public static Integer getLoginUserIdFromSession() {
        return getLoginUserFromSession().getUserId();
    }

    /**
     * 从文件名取得其后缀
     *
     * @param fileName 文件名
     * @return 后缀
     */
    public static String extension(String fileName) {
        String type = isEmpty(fileName) ? "unknown" : fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        String extension;

        switch (type) {
            case ".jpg":
            case ".jpeg":
            case ".png":
            case ".gif":
            case ".bmp":
            case ".psd":
                extension = "pic";
                break;
            case ".mp4":
            case ".avi":
            case ".rmvb":
            case ".mpeg":
            case ".mov":
            case ".3gp":
            case ".wmv":
                extension = "video";
                break;
            case ".zip":
            case ".rar":
            case ".7z":
                extension = "compress";
                break;
            case ".txt":
                extension = "txt";
                break;
            case ".doc":
            case ".docx":
                extension = "word";
                break;
            case ".xls":
            case ".xlsx":
                extension = "excel";
                break;
            case ".ppt":
            case ".pptx":
                extension = "ppt";
                break;
            case ".pdf":
                extension = "pdf";
                break;
            default:
                extension = "unknown";
        }

        return extension;
    }
}