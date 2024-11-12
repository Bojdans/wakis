package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wakis.entity.OrderCloth;
import wakis.exceptions.OrderClothException;
import wakis.service.OrderClothService;
import wakis.service.PromocodeService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderClothController {
    @Autowired
    private OrderClothService orderClothService;
    @Autowired
    private PromocodeService promocodeService;
     @GetMapping
     public List<OrderCloth> getAll() {
        return orderClothService.getAll();
     }
    @GetMapping("/{id}")
    public OrderCloth getById(@PathVariable long id) {
        return orderClothService.getById(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody OrderCloth orderCloth,@RequestParam String promocodeName) throws OrderClothException {
         orderCloth.setPromocode(promocodeService.getByPromocodeName(promocodeName));
         orderClothService.saveOrderCloth(orderCloth);
    }

    @PostMapping(value = "/update")
    public void update(@RequestBody OrderCloth orderCloth,@RequestParam String promocodeName) throws OrderClothException {
        orderCloth.setPromocode(promocodeService.getByPromocodeName(promocodeName));
        orderClothService.saveOrderCloth(orderCloth);
    }
}
