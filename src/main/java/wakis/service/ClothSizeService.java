package wakis.service;

import org.springframework.stereotype.Service;
import wakis.entity.covers.ClothSize;
import wakis.exceptions.ClothSizeException;
import wakis.repository.ClothSizeRepository;

import java.util.List;
@Service
public class ClothSizeService {
    private final ClothSizeRepository clothSizeRepository;

    public ClothSizeService(ClothSizeRepository clothSizeRepository) {
        this.clothSizeRepository = clothSizeRepository;
    }

    /**
     * CRUD ↓
     */
    public void saveCloth(ClothSize clothSize) throws ClothSizeException {
        isRightData(clothSize);
        clothSizeRepository.saveAndFlush(clothSize);
    }


    public void delete(long id) {
        clothSizeRepository.deleteById(id);
    }


    public ClothSize getById(long id) {
        return clothSizeRepository.findById(id).get();
    }



    public void updateCloth(ClothSize clothSize) throws ClothSizeException {
        isRightData(clothSize);
        clothSizeRepository.saveAndFlush(clothSize);
    }


    public List<ClothSize> getAll() {
        return clothSizeRepository.findAll();
    }
    /**
     * все проверки ↓
     */
    private void isRightData(ClothSize clothSize) throws ClothSizeException {
        isRightClothSizes(clothSize);
        isRightQuantity(clothSize);
    }
    /**
     *
     * @param clothSize
     * @throws ClothSizeException проверка размера
     */
    private void isRightClothSizes(ClothSize clothSize) throws ClothSizeException {
        if(clothSize.getClothSize() == null){
            throw new ClothSizeException("поле размеров не может быть пустым");
        }
        if(clothSize.getClothSize().length() > 10){
            throw new ClothSizeException("длина превышает 10");
        }
    }
    private void isRightQuantity(ClothSize clothSize) throws ClothSizeException {
        if(clothSize.getQuantity() == null){
            throw new ClothSizeException("поле кол-ва не может быть пустым");
        }
    }
}
