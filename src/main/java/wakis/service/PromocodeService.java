package wakis.service;

import org.springframework.stereotype.Service;
import wakis.entity.Promocode;
import wakis.exceptions.PromocodeException;
import wakis.repository.PromocodeRepository;

import java.util.List;

@Service
public class PromocodeService {
    private final PromocodeRepository promocodeRepository;
    public PromocodeService(PromocodeRepository promocodeRepository) {
        this.promocodeRepository = promocodeRepository;
    }
    /**
     * CRUD ↓
     */
    public void savePromocode(Promocode promocode) throws PromocodeException {
        isRightData(promocode);
        promocodeRepository.saveAndFlush(promocode);
    }
    public void delete(long id) {
        promocodeRepository.deleteById(id);
    }
    public Promocode getById(long id) {
        return promocodeRepository.findById(id).get();
    }
    public Promocode getByPromocodeName(String promocodeName){
        return  promocodeRepository.findByPromocodeName(promocodeName);
    }
    public void updatePromocode(Promocode promocode) throws PromocodeException {
        isRightData(promocode);
        promocodeRepository.saveAndFlush(promocode);
    }
    public List<Promocode> getAll() {
        return promocodeRepository.findAll();
    }

    /**
     * все проверки ↓
     */
    private void isRightData(Promocode promocode) throws PromocodeException {
        isRightPromocodeName(promocode);
        isRightDiscount(promocode);
        isRightDescription(promocode);
    }

    /**
     * @param promocode
     * @throws PromocodeException
     * проверка названия промокода
     */
    private void isRightPromocodeName(Promocode promocode) throws PromocodeException {
        if(promocode.getPromocodeName().length() > 12){
            throw new PromocodeException("название промокода должно быть меньше 12 символов");
        }
    }
    /**
     * @param promocode
     * @throws PromocodeException
     * проверка скидки
     */
    private void isRightDiscount(Promocode promocode) throws PromocodeException {
        if(promocode.getDiscount() > 100){
            throw new PromocodeException("скидка не может быть больше 100");
        }
    }
    /**
     * @param promocode
     * @throws PromocodeException
     * проверка описания
     */
    private void isRightDescription(Promocode promocode) throws PromocodeException {
        if(promocode.getDescription().length() > 50){
            throw new PromocodeException("описание должно быть меньше 50 символов");
        }
    }
    //TODO:checks
    // done
}