package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wakis.DTO.ClothPreviewDTO;
import wakis.entity.Cloth;
import wakis.exceptions.ClothException;
import wakis.service.ClothService;
import wakis.service.FileService;
import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothController {
    @Autowired
    private ClothService clothService;
    @Autowired
    private FileService fileService;
    @GetMapping
    public List<Cloth> getAll() {
        return clothService.getAll();
    }
    @GetMapping("/{id}")
    public Cloth getById(@PathVariable long id) {
        return clothService.getById(id);
    }
    @PostMapping(value = "/save")
    public void save(@RequestBody Cloth cloth) throws ClothException {
        clothService.saveCloth(cloth);
    }
    @PostMapping(value = "/update")
    public void update(@RequestBody Cloth cloth) throws ClothException {
        clothService.updateCloth(cloth);
    }
    @GetMapping("/getAllForPreview")
    public List<ClothPreviewDTO> getAllForPreview() throws ClothException {
        return clothService.getAll().stream()
                .map(x -> new ClothPreviewDTO(x.getName(),fileService.getImages(x.getImages()),x.getCost(),x.getFakeCost(),x.getDescription()))
                .toList();
    }
}