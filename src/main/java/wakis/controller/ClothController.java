package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wakis.entity.Cloth;
import wakis.exceptions.ClothException;
import wakis.service.ClothService;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothController {
    @Autowired
    private ClothService clothService;
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
}