package wakis.service;

import org.springframework.stereotype.Service;
import wakis.entity.covers.ImageWakis;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
@Service
public class FileService {


    public List<String> getImages(List<String> images){
        try {
            List<String> imagesCodes = images.stream().map(image -> {
                try {
                    return Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(image)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).toList();
            return imagesCodes;
        } catch (Exception e) {
            return List.of("Ошибка: " + e.getMessage());
        }
    }

    public String getTextFromFile(String pathFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir"),"src/main/resources/CMS/" + pathFile + ".txt"));
        String fileContent = "";
        while(scanner.hasNextLine()){
            fileContent += scanner.nextLine();
        }
        System.out.println(fileContent);
        return fileContent;
    }
    public void addImages(List<ImageWakis> imagesWakis){
        String baseImagesPath = "src/main/webapp/static/images/";
        imagesWakis.stream().forEach(image -> {
            try {
                if (image.getContent().contains("base64")){
                    image.setContent(image.getContent().replace("data:image/png;base64,",""));
                    image.setContent(image.getContent().replace("data:image/jpeg;base64,",""));
                }

                byte[] imageBytes = Base64.getDecoder().decode(image.getContent());

                try (OutputStream outputStream = new FileOutputStream(baseImagesPath + image.getPathFile() + ".png")) {
                    outputStream.write(imageBytes);
                    System.out.println("Изображение успешно сохранено в файл: " + baseImagesPath + image.getPathFile() + ".png");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка при сохранении изображения: " + e.getMessage());
            }
        });
    }
    public void addText(String content,String pathFile){
        try {
            FileWriter writer = new FileWriter("src/main/resources/CMS/" + pathFile + ".txt");
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
    public void deleteImage(String pathFile){
        String baseImagesPath = "src/main/webapp/static/images/";
        File file = new File(baseImagesPath + pathFile + ".png");
        System.out.println(file.getPath());
        if (file.delete()) {
            System.out.println("Файл успешно удалён.");
        } else {
            System.out.println("Не удалось удалить файл.");
        }
    }
}