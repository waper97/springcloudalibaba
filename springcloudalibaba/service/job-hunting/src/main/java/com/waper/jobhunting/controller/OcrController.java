package com.waper.jobhunting.controller;

import com.waper.common.entity.R;
import com.waper.jobhunting.service.OcrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * ocr控制器
 * @author wangpeng
 * @ClassName OcrController
 * @description TODO
 * @date 2023/12/4 17:36
 */
@RestController
@RequestMapping("/api/ocr/")
public class OcrController {

    @Autowired
    private OcrService ocrService;
    @PostMapping("recognizeText")

    @ApiOperation("识别图片文字")
    public R recognizeText(@RequestParam("file") MultipartFile file) throws IOException {
        String result = ocrService.recognizeText(ImageIO.read(file.getInputStream()));
        return R.success(result);
    }
}
