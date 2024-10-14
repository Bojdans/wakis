package wakis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wakis.entity.AdminUser;
import wakis.exceptions.AdminUserException;
import wakis.service.AdminUserService;

import java.util.List;

@RestController
@RequestMapping("/admin_users")
public class  AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @GetMapping
    public List<AdminUser>  getAll() {
        return adminUserService.getAll();
    }
    @GetMapping("/{id}")
    public AdminUser getById(@PathVariable long id) {
        return adminUserService.getById(id);
    }
    @PostMapping(value = "/save")
    public void save(@RequestBody AdminUser adminUser) throws AdminUserException {
        adminUserService.saveAdminUser(adminUser);
    }

    @PostMapping(value = "/update")
    public void update(@RequestBody AdminUser adminUser) throws AdminUserException {
        adminUserService.updateAdminUser(adminUser);
    }
}
