package top.fallenangel.springtransaction.controller;

import top.fallenangel.service.IValidCodeService;
import top.fallenangel.service.impl.ValidCodeServiceImpl;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/validCode")
public class ValidCodeServlet extends HttpServlet {
    private final IValidCodeService validCodeService = new ValidCodeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int validWidth = 92;
        int validHeight = 30;
        BufferedImage validImage = validCodeService.getValidCodeImage(validWidth, validHeight, validCodeService.TYPE_INT_RGB);
        String validCode = validCodeService.getValidCode();
        req.getSession().setAttribute("trueValidCode", validCode);
        ImageIO.write(validImage, "JPEG", resp.getOutputStream());
        resp.getOutputStream().flush();
    }
}