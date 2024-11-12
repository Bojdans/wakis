package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wakis.entity.covers.ImageWakis;
import wakis.entity.covers.TextWakis;
import wakis.service.FileService;

import java.awt.*;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FilesController {
    @Autowired
    private FileService fileService;
    @GetMapping("/image/")
    public List<String> getImages(@RequestBody List<ImageWakis> images) {
        return fileService.getImages(images.stream().map(ImageWakis::getPathFile).toList());
    }
    @GetMapping("/text/")
    public String getTextFromFile(@RequestBody String pathFile) throws FileNotFoundException {
        return fileService.getTextFromFile(pathFile);
    }
    @PostMapping("/addImages/")
    public void addImages(@RequestBody() List<ImageWakis> images){
        fileService.addImages(images);
    }
    @PostMapping("/addText/")
    public void addText(@RequestBody TextWakis textWakis) {
        fileService.addText(textWakis.getContent(), textWakis.getPathFile());
    }
    @PostMapping("/deleteImage/")
    public void deleteImage(@RequestParam String pathFile){
        fileService.deleteImage(pathFile);
    }
}
