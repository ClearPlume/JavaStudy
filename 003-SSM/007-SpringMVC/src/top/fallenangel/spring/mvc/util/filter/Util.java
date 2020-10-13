package top.fallenangel.spring.mvc.util.filter;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Util {
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
                file.transferTo(new File("D:/upload/img/" + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
}