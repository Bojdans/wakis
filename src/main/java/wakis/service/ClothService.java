package wakis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wakis.entity.Cloth;
import wakis.entity.OrderCloth;
import wakis.exceptions.ClothException;
import wakis.exceptions.OrderClothException;
import wakis.repository.ClothRepository;
import wakis.repository.PromocodeRepository;

import java.util.List;

@Service
public class ClothService {
    private final ClothRepository clothRepository;
    public ClothService(ClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }
    /**
     * CRUD ↓
     */
    public void saveCloth(Cloth cloth) throws ClothException {
        isRightData(cloth);
        clothRepository.saveAndFlush(cloth);
    }

    
    public void delete(long id) {
        clothRepository.deleteById(id);
    }

    
    public Cloth getById(long id) {
        return clothRepository.findById(id).get();
    }


    
    public void updateCloth(Cloth cloth) throws ClothException {
        isRightData(cloth);
        clothRepository.saveAndFlush(cloth);
    }

    
    public List<Cloth> getAll() {
        return clothRepository.findAll();
    }
    /**
     * все проверки ↓
     */
    private void isRightData(Cloth cloth) throws ClothException {
        isRightCost(cloth);
        isRightImages(cloth);
        isRightName(cloth);
        isRightType(cloth);
        isRightSizes(cloth);
        isRightCostWithoutDiscount(cloth);
    }
    private void isRightName(Cloth cloth) throws ClothException {
        if(cloth.getName() == null){
            throw new ClothException("название не может быть пустым");
        }
        if (cloth.getName().length() > 50) {
            throw new ClothException("название не может быть больше 50 символов");
        }
    }

    /**
     *
     * @param cloth
     * @throws ClothException проверка размерной сетки
     */
    private void isRightSizes(Cloth cloth) throws ClothException {

    }
    /**
     *
     * @param cloth
     * @throws ClothException проверка типа одежды
     */
    private void isRightType(Cloth cloth) throws ClothException {
        if(cloth.getType() == null){
            throw new ClothException("тип одежды не может быть пустым");
        }
    }
    /**
     *
     * @param cloth
     * @throws ClothException проверка картинок
     */
    private void isRightImages(Cloth cloth) throws ClothException {
        if(cloth.getImages() == null){
            throw new ClothException("одежда не может не иметь изображений");
        }
    }
    /**
     *
     * @param cloth
     * @throws ClothException проверка цены
     */
    private void isRightCost(Cloth cloth) throws ClothException {
        if(cloth.getCost() == null){
            throw new ClothException("поле цены не может быть пустым");
        }
        if(cloth.getCost() < 0){
            throw new ClothException("цена не может быть меньше 0");
        }
    }
    /**
     * @param cloth
     * @throws ClothException
     *
     * проверка цены без скидки(которая перечёркивается типо какая раньше была)
     */
    private void isRightCostWithoutDiscount(Cloth cloth) throws ClothException {
        if(cloth.getCostWithoutDiscount() < 0){
            throw new ClothException("цена без скидки не может быть меньше 0");
        }
    }
    //TODO:checks
    // done
}
