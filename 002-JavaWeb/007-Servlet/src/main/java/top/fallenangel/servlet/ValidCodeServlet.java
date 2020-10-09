package top.fallenangel.servlet;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ValidCodeServlet", urlPatterns = "/validCode")
public class ValidCodeServlet extends HttpServlet {
    private final char[] codeSequence = {'A', '1', 'B', 'C', '2', 'D', '3', 'E', '4', 'F', '5', 'G', '6', 'H', '7', 'I', '8', 'J', 'K', '9', 'L', '1', 'M', '2', 'N', 'P', '3', 'Q', '4', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'j', 'm', 'n', 'r', 't', 'u'};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int width = 92;
        int height = 30;
        Random random = new Random();

        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(100, 160, 190));
        g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        g.fillRect(0, 0, width, height);
        for (int i = 0; i < 20; i++) {
            g.setColor(this.getColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        StringBuilder strCode = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            strCode.append(rand);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            // g.setColor(new Color(255, 255, 255));
            g.drawString(rand, 20 * i + 8, 25);
        }

        //保存每次生成的正确的验证码
        req.getSession().setAttribute("true-code", strCode.toString().toLowerCase());
        g.dispose();

        ImageIO.write(image, "JPEG", resp.getOutputStream());
        resp.getOutputStream().flush();
    }

    public Color getColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}