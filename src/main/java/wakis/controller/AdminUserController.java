package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wakis.entity.AdminUser;
import wakis.exceptions.AdminUserException;
import wakis.service.AdminUserService;

@Controller
@RequestMapping("/admin_users")
public class  AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("messages", adminUserService.getAll() );
        return "test/allentities";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable long id, Model model) {
        model.addAttribute("messages", adminUserService.getById(id));
        return "test/allentities";
    }
    @GetMapping("/save")
    public String save(Model model){
        return "test/save/adminuserform";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute AdminUser adminUser, Model model) throws AdminUserException {
        adminUserService.saveAdminUser(adminUser);

        return "redirect:/admin_users";
    }
    @GetMapping("/update")
    public String update(Model model){
        return "test/save/adminuserform";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute AdminUser adminUser, Model model) throws AdminUserException {
        adminUserService.updateAdminUser(adminUser);
        return "redirect:/admin_users";
    }

}
