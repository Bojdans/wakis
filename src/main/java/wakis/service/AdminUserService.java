package wakis.service;

import org.springframework.stereotype.Service;
import wakis.entity.AdminUser;
import wakis.exceptions.AdminUserException;
import wakis.repository.AdminUserRepository;


import java.util.List;

@Service
public class AdminUserService {
    private final AdminUserRepository adminUserRepository;
    public AdminUserService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }
    /**
     * методы CRUD ↓
     */
    public void saveAdminUser(AdminUser adminUser) throws AdminUserException {
        isRightData(adminUser);
        adminUserRepository.saveAndFlush(adminUser);
    }
    public void delete(long id) {
        adminUserRepository.deleteById(id);
    }
    public AdminUser getById(long id) {
        return adminUserRepository.findById(id).get();
    }
    public void updateAdminUser(AdminUser adminUser) throws AdminUserException{
        isRightData(adminUser);
        adminUserRepository.saveAndFlush(adminUser);
    }
    public List<AdminUser> getAll() {
        return adminUserRepository.findAll();
    }
    /**
     * все проверки ↓
     */
    private void isRightData(AdminUser adminUser) throws AdminUserException {
        isRightLogin(adminUser);
        isRightPassword(adminUser);
        isRightPermissions(adminUser);
        isRightDescription(adminUser);
    }

    /**
     *
     * @param adminUser
     * @throws AdminUserException проверка логина
     */
    private void isRightLogin(AdminUser adminUser) throws AdminUserException {
        if(adminUser.getLogin() == null){
            throw new AdminUserException("логин не может быть пустым");
        }if (adminUser.getLogin().length() > 20) {
            throw new AdminUserException("логин не может быть длиннее 20 символов");
        }

    }

    /**
     *
     * @param adminUser
     * @throws AdminUserException проверка пароля
     */
    private void isRightPassword(AdminUser adminUser) throws AdminUserException {
        if(adminUser.getPassword() == null){
            throw new AdminUserException("пароль не может быть пустым");
        }if (adminUser.getPassword().length() > 20) {
            throw new AdminUserException("пароль не может быть длиннее 20 символов");
        }
    }

    /**
     *
     * @param adminUser
     * @throws AdminUserException проверка описания
     */
    private void isRightDescription(AdminUser adminUser) throws AdminUserException {
        if(adminUser.getDescription().length() > 40) {
            throw new AdminUserException("описание не может быть длиннее 40 символов");
        }
    }

    /**
     *
     * @param adminUser
     * @throws AdminUserException проверка прав
     */
    private void isRightPermissions(AdminUser adminUser) throws AdminUserException {
        if (adminUser.getPermissions() == null) {
            throw new AdminUserException("поле прав не может быть пустым");
        }
    }
}
