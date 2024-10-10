package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wakis.entity.OrderCloth;
import wakis.exceptions.OrderClothException;
import wakis.service.OrderClothService;
import wakis.service.PromocodeService;

@Controller
@RequestMapping("/orders")
public class OrderClothController {
    @Autowired
    private OrderClothService orderClothService;
    @Autowired
    private PromocodeService promocodeService;
     @GetMapping
     public String getAll(Model model) {
         model.addAttribute("messages", orderClothService.getAll() );
         return "test/allentities";
     }
    @GetMapping("/{id}")
    public String getById(@PathVariable long id, Model model) {
         model.addAttribute("messages", orderClothService.getById(id));
        return "test/allentities";
    }
    @GetMapping("/save")
    public String save(Model model){
        return "test/save/orderclothform";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute OrderCloth orderCloth,@RequestParam String randomName, Model model) throws OrderClothException {
         orderCloth.setPromocode(promocodeService.getByPromocodeName(randomName));
         System.out.println(orderCloth);
        orderClothService.saveOrderCloth(orderCloth);

        return "redirect:/orders";
    }
    @GetMapping("/update")
    public String update(Model model){
        return "test/save/orderclothform";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute OrderCloth orderCloth,@RequestParam String randomName , Model model) throws OrderClothException {
        orderCloth.setPromocode(promocodeService.getByPromocodeName(randomName));
        orderClothService.updateOrderCloth(orderCloth);
        return "redirect:/orders";
    }
}
