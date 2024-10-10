package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wakis.entity.Cloth;
import wakis.exceptions.ClothException;
import wakis.service.ClothService;

@Controller
@RequestMapping("/clothes")
public class ClothController {
    @Autowired
    private ClothService clothService;
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("messages", clothService.getAll() );
        return "test/allentities";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable long id, Model model) {
        model.addAttribute("messages", clothService.getById(id));
        return "test/allentities";
    }
    @GetMapping("/save")
    public String save(Model model){
        return "test/save/clothform";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Cloth cloth, Model model) throws ClothException {
        clothService.saveCloth(cloth);

        return "redirect:/clothes";
    }
    @GetMapping("/update")
    public String update(Model model){
        return "test/save/clothform";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Cloth cloth, Model model) throws ClothException {
        clothService.updateCloth(cloth);
        return "redirect:/clothes";
    }
}
