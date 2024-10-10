package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wakis.entity.Promocode;
import wakis.exceptions.PromocodeException;
import wakis.service.PromocodeService;

@Controller
@RequestMapping("/promocodes")
public class PromocodeController {
    @Autowired
    private PromocodeService promocodeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("messages", promocodeService.getAll() );
        return "test/allentities";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable long id, Model model) {
        model.addAttribute("messages", promocodeService.getById(id));
        return "test/allentities";
    }

    @GetMapping("/save")
    public String save(Model model){
        return "test/save/promocodeform";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Promocode promocode, Model model) throws PromocodeException {
        promocodeService.savePromocode(promocode);
        return "redirect:/promocodes";
    }
    @GetMapping("/update")
    public String update(Model model){
        return "test/save/promocodeform";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Promocode promocode , Model model) throws PromocodeException {

        promocodeService.updatePromocode(promocode);
        return "redirect:/promocodes";
    }
}
