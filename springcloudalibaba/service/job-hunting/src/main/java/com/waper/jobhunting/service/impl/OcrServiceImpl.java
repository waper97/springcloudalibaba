package com.waper.jobhunting.service.impl;

import com.waper.jobhunting.service.OcrService;
import lombok.SneakyThrows;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;

/**
 * @author wangpeng
 * @ClassName OcrServiceImpl
 * @description TODO
 * @date 2023/12/4 17:26
 */
@Service
public class OcrServiceImpl implements OcrService {

    private final ITesseract tesseract;

    public OcrServiceImpl() {
        this.tesseract = new Tesseract();

        this.tesseract.setDatapath("D:\\Program Files\\Tesseract-OCR\\tessdata");

    }

    @SneakyThrows
    @Override
    public String recognizeText(BufferedImage image) {
        tesseract.setLanguage("chi_sim");
        return tesseract.doOCR(image);
    }
}
