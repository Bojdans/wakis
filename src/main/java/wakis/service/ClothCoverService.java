package wakis.service;

import org.springframework.stereotype.Service;
import wakis.entity.covers.ClothCover;
import wakis.exceptions.ClothCoverException;
import wakis.repository.ClothCoverRepository;

import java.util.List;

@Service
public class ClothCoverService {
    private final ClothCoverRepository clothCoverRepository;
    public ClothCoverService(ClothCoverRepository clothCoverRepository) {
        this.clothCoverRepository = clothCoverRepository;
    }
    /**
     * методы CRUD ↓
     */
    public void saveClothCover(ClothCover clothCover) throws ClothCoverException {
        isRightData(clothCover);
        clothCoverRepository.saveAndFlush(clothCover);
    }

    
    public void delete(long id) {
        clothCoverRepository.deleteById(id);
    }

    
    public ClothCover getById(long id) {
        return clothCoverRepository.findById(id).get();
    }

    
    public void updateClothCover(ClothCover clothCover) throws ClothCoverException {
        isRightData(clothCover);
        clothCoverRepository.saveAndFlush(clothCover);
    }

    
    public List<ClothCover> getAll() {
        return clothCoverRepository.findAll();
    }
    /**
     * все проверки ↓
     */
    private void isRightData(ClothCover clothCover) throws ClothCoverException {
        isRightCloth(clothCover);
        isRightQuantity(clothCover);
        isRightSize(clothCover);
    }

    /**
     *
     * @param clothCover
     * @throws ClothCoverException проверка одежды для которой создаётся обёртка
     */
    private void isRightCloth(ClothCover clothCover) throws ClothCoverException {

    }

    /**
     *
     * @param clothCover
     * @throws ClothCoverException проверка кол-ва одежды
     */
    private void isRightQuantity(ClothCover clothCover) throws ClothCoverException {
        if(clothCover.getQuantity()  == null) {
            throw new ClothCoverException("поле кол-ва не может быть пустым");
        }
        if (clothCover.getQuantity() == 0) {
            throw new ClothCoverException("поле кол-ва не может быть равно 0");
        }
        if(clothCover.getQuantity() < 0) {
            throw new ClothCoverException("поле кол-ва не может быть меньше 0");
        }
    }

    /**
     *
     * @param clothCover
     * @throws ClothCoverException проверка выбранного размера
     */
    private void isRightSize(ClothCover clothCover) throws ClothCoverException {
        if(clothCover.getSize() == null) {
            throw new ClothCoverException("поле размера не может быть пустым");
        }
        List<String> clothSizes = clothCoverRepository.findAll().stream().map(ClothCover::getSize).toList();
        if (!clothSizes.contains(clothCover.getSize())){
            throw new ClothCoverException("размер не существует");
        }

    }
}
