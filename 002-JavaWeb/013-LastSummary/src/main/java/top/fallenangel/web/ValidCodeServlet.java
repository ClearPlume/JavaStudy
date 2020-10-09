package top.fallenangel.web;

import top.fallenangel.service.IValidCodeService;
import top.fallenangel.service.impl.ValidCodeServiceImpl;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "ValidCodeServlet", urlPatterns = "/validCode")
public class ValidCodeServlet extends BaseServlet {
    private final IValidCodeService validCodeService = new ValidCodeServiceImpl();

    protected void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int validWidth = 100;
        int validHeight = 43;
        BufferedImage validImage = validCodeService.getValidCodeImage(validWidth, validHeight, validCodeService.TYPE_INT_RGB);
        String validCode = validCodeService.getValidCode();
        req.getSession().setAttribute("trueValidCode", validCode);
        ImageIO.write(validImage, "JPEG", resp.getOutputStream());
        resp.getOutputStream().flush();
    }
}