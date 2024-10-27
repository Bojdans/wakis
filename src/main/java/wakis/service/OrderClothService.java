package wakis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wakis.entity.OrderCloth;
import wakis.entity.covers.ClothCover;
import wakis.exceptions.OrderClothException;
import wakis.repository.OrderClothRepository;

import java.util.List;

@Service
public class OrderClothService {
    private final OrderClothRepository orderClothRepository;

    public OrderClothService(OrderClothRepository orderClothRepository) {
        this.orderClothRepository = orderClothRepository;
    }

    /**
     * CRUD ↓
     */
    public void saveOrderCloth(OrderCloth orderCloth) throws OrderClothException {
        isRightData(orderCloth);
        orderClothRepository.saveAndFlush(orderCloth);
    }

    public void delete(long id) {
        orderClothRepository.deleteById(id);
    }

    public OrderCloth getById(long id) {
        return orderClothRepository.findById(id).get();
    }

    public void updateOrderCloth(OrderCloth orderCloth) throws OrderClothException {
        isRightData(orderCloth);
        orderClothRepository.saveAndFlush(orderCloth);
    }

    public List<OrderCloth> getAll() {
        return (List<OrderCloth>) orderClothRepository.findAll();
    }

    /**
     * все проверки ↓
     */
    private void isRightData(OrderCloth orderCloth) throws OrderClothException {
        isRightPhoneNumber(orderCloth);
        isRightEmail(orderCloth);
        isRightTelegramUsername(orderCloth);
        countTotalCost(orderCloth);

    }

    /**
     * @param orderCloth
     * @throws OrderClothException проверка формата email
     */
    private void isRightEmail(OrderCloth orderCloth) throws OrderClothException {
        if (!orderCloth.getEmail().contains("@")) {
            throw new OrderClothException("неверный формат email");
        }
        if (!orderCloth.getEmail().substring(orderCloth.getEmail().indexOf("@")).contains(".")) {
            throw new OrderClothException("неверный формат email");
        }
    }

    /**
     * @param orderCloth
     * @throws OrderClothException проверка формата номера телефона
     */
    private void isRightPhoneNumber(OrderCloth orderCloth) throws OrderClothException {
        if (orderCloth.getPhoneNumber().length() != 12) {
            throw new OrderClothException("неверный формат номера телефона");
        }
    }

    /**
     * @param orderCloth
     * @throws OrderClothException проверка формата telegram username
     */
    private void isRightTelegramUsername(OrderCloth orderCloth) throws OrderClothException {
        if (orderCloth.getTelegramUsername().length() > 32 || orderCloth.getTelegramUsername().length() < 5 || !orderCloth.getTelegramUsername().contains("@")) {
            throw new OrderClothException("telegram username должен быть от 5 до 32 символов и начинаться с @");
        }
    }
    /**
     * считает стоимость всех шмоток в заказе и применяет скидку
     *
     * @return totalCost
     */
    private long countTotalCost(OrderCloth orderCloth) {
        long totalCost = 0;
        if (orderCloth.getClothCovers() == null) return totalCost;
        for (ClothCover clothCover : orderCloth.getClothCovers()) {
            totalCost += clothCover.getCloth().getCost();
        }

        totalCost = totalCost - (totalCost * orderCloth.getPromocode().getDiscount() / 100);
        return totalCost;
    }
}
