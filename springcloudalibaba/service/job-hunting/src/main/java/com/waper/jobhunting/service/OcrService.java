package com.waper.jobhunting.service;

import java.awt.image.BufferedImage;

/**
 * OCR
 * @author wangpeng
 * @ClassName OcrService
 * @description TODO
 * @date 2023/12/4 17:25
 */

public interface OcrService {
    /**
     * 识别文字
     * @param image
     * @return
     */
    String recognizeText(BufferedImage image);
}
