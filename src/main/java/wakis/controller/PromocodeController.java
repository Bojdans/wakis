package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wakis.entity.Promocode;
import wakis.exceptions.PromocodeException;
import wakis.service.PromocodeService;

import java.util.List;

@RestController
@RequestMapping("/promocodes")
public class PromocodeController {
    @Autowired
    private PromocodeService promocodeService;
    @GetMapping
    public List<Promocode> getAll() {
        return promocodeService.getAll();
    }
    @GetMapping("/{id}")
    public Promocode getById(@PathVariable long id) {
        return promocodeService.getById(id);
    }
    @PostMapping(value = "/save")
    public void save(@RequestBody Promocode promocode) throws PromocodeException {
        promocodeService.savePromocode(promocode);
    }

    @PostMapping(value = "/update")
    public void update(@RequestBody Promocode promocode) throws PromocodeException {
        promocodeService.updatePromocode(promocode);
    }
}