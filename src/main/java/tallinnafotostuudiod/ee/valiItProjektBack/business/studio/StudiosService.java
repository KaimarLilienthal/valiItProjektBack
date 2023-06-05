package tallinnafotostuudiod.ee.valiItProjektBack.business.studio;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioDtoBasic;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioGeneralInfo;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioPriceDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.BookingService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.image.Image;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.image.ImageService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.address.Address;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.address.AddressMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.address.AddressService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district.District;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district.DistrictService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraRepository;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.User;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.UserService;
import tallinnafotostuudiod.ee.valiItProjektBack.util.ImageUtil;

import java.util.List;
import java.util.Optional;


@Service
public class StudiosService {

    @Resource
    private StudioService studioService;

    @Resource
    private AddressService addressService;

    @Resource
    private ImageService imageService;
    @Resource
    private UserService userService;
    @Resource
    private DistrictService districtService;

    @Resource
    private StudioMapper studioMapper;
    @Resource
    private AddressMapper addressMapper;

    @Resource
    private StudioExtraService studioExtraService;

    @Resource
    private StudioExtraRepository studioExtraRepository;

    @Resource
    private BookingService bookingService;

    public StudiosService(StudioExtraRepository studioExtraRepository) {
        this.studioExtraRepository = studioExtraRepository;
    }


    public List<StudioDto> findUserStudios(Integer userId) {
        List<Studio> studios = studioService.findUserActiveStudios(userId);
        List<StudioDto> studioDtos = studioMapper.toStudioDtos(studios);
        return studioDtos;
    }

    public void addStudio(StudioGeneralInfo studioGeneralInfo) {
        //  ME KUNAGI EI MÄPI FOREING key väärtusi ENTITITELE,
        //  vaid kas otsime nende id'de abil üllesse vastate tabelite objektid/read
        //  või siis tekitame uued objektid/read
        studioService.findExistsUrlBy(studioGeneralInfo.getWebsite());

        //  mapime 'studio' objektile/reale nii palju andmeid kui saame
        Studio studio = studioMapper.toStudio(studioGeneralInfo);

        // TODO: 5/19/2023 otsime ownerUserId abil andmebaasist ülesse 'user' objekti/rea
        User user = userService.findActiveStudioUserBy(studioGeneralInfo.getOwnerUserId());


        // TODO: Loome 'address' objekti/rea ja salvestame andmebaasi
        Address address = addressMapper.toAddress(studioGeneralInfo);
        addressService.addAddress(address);

        // TODO: 5/19/2023 otsime districtId abil andmebaasist ülesse 'district' objekti/rea
        District district = districtService.findDistrictBy(studioGeneralInfo.getDistrictId());

        // TODO: toStudio() mäppimise käigus, kui dto (studioGeneralInfo) imageData välja ei olnud tühi
        //  siis loodi mäppimise käigus loodi Image objekt koos byte array data'ga.
        //  Kui imageData väli oli tühi, siis image väärtus jäi null'iks
        Image image = studio.getImage();

        //  seda 'image' objekti/rida pole veel andmebaasi salvestatud
        // TODO: Peame kontrollima, kas studio küljes on pilt või mitte (kas jäi null või mitte),
        if (ImageUtil.imageIsPresent(image)) {

            //  kui jah siis peame selle ära salvestama
            // TODO: imageService->ImageRepository save(image)
            imageService.addImage(image);
        }

        // TODO: nyyd enne kui hakkame 'studio' objekti/rida andbmebaasi salvestama, siis peame veenduma,
        //  et selle studio objekti/rea küljes on olemas kõik nõutud info

        // TODO: 5/19/2023 kõik mis puudu, tuleb siis setterite abil külge panna
        studio.setAddress(address);
        studio.setDistrict(district);
        studio.setOwnerUser(user);


        studioService.addStudio(studio);
        // TODO: 5/19/2023 Siin oleks hea debbugeri breakpoint

        // TODO: 5/19/2023 toimub 'studio' objekt/rea salvestamine (studioService->studioRepository save() abil)
    }

    public void editUserStudioHourPrice(Integer studioId, StudioPriceDto studioPriceDto) {
        Studio studio = studioService.getUserActiveStudio(studioId);
        studioMapper.partialUpdate(studioPriceDto, studio);
        studioService.addStudio(studio);
    }

    @Transactional
    public void changeUserStudio(Integer studioId, StudioGeneralInfo studioGeneralInfo) {
        Studio studio = studioService.getUserActiveStudio(studioId);
        studioMapper.partialUpdate(studioGeneralInfo, studio);

        Image image = studio.getImage();

        //  seda 'image' objekti/rida pole veel andmebaasi salvestatud
        // TODO: Peame kontrollima, kas studio küljes on pilt või mitte (kas jäi null või mitte),
        if (ImageUtil.imageIsPresent(image)) {

            //  kui jah siis peame selle ära salvestama
            // TODO: imageService->ImageRepository save(image)
            imageService.addImage(image);
        }

        User user = userService.findActiveStudioUserBy(studioGeneralInfo.getOwnerUserId());
        studio.setOwnerUser(user);

        District district = districtService.findDistrictBy(studioGeneralInfo.getDistrictId());
        studio.setDistrict(district);

        studioService.addStudio(studio);
    }

    public StudioGeneralInfo findUserStudio(Integer studioId) {
        Studio studio = studioService.getUserActiveStudio(studioId);
        StudioGeneralInfo studioDto = studioMapper.toUserStudioDto(studio);
        return studioDto;
    }

    public void deleteUserStudio(Integer studioId) {
        Studio studio = studioService.getUserActiveStudio(studioId);
        studio.setStatus("D");
        studioService.addStudio(studio);
    }

    public List<StudioDtoBasic> findAllAreaStudios(Integer districtId) {
        List<Studio> studios = studioService.findAllAreaStudios(districtId);
        List<StudioDtoBasic> allStudioDtos = studioMapper.toAllStudioDtos(studios);
        return allStudioDtos;
    }


    public StudioPriceDto findUserStudioHourPrice(Integer studioId) {
        Optional<Studio> userStudioHourPrice = studioService.findUserStudioHourPrice(studioId);
        StudioPriceDto studioPriceDto = studioMapper.toStudioPriceDto(userStudioHourPrice.get());
        return studioPriceDto;
    }

}
