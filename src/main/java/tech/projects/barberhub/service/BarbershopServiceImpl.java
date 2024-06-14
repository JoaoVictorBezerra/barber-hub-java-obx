package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.barbershop.BarbershopConstants;
import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop.BarbershopDetailDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarbershopDTO;
import tech.projects.barberhub.exceptions.barbershop.BarbershopAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.barbershop.BarbershopNotFoundException;
import tech.projects.barberhub.mappers.barbershop.BarbershopMapper;
import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.catalog.Catalog;
import tech.projects.barberhub.repository.BarbershopRepository;
import tech.projects.barberhub.service.interfac.BarbershopCatalogService;
import tech.projects.barberhub.service.interfac.BarbershopService;
import tech.projects.barberhub.service.interfac.CatalogService;

import java.util.List;
import java.util.Optional;

@Service
public class BarbershopServiceImpl implements BarbershopService {
    private final BarbershopRepository barbershopRepository;
    private final BarbershopCatalogService barberShopCatalogService;
    private final CatalogService catalogService;

    BarbershopMapper barbershopMapper = new BarbershopMapper();

    public BarbershopServiceImpl(BarbershopRepository barbershopRepository, BarbershopCatalogService barberShopCatalogService, CatalogService catalogService) {
        this.barbershopRepository = barbershopRepository;
        this.barberShopCatalogService = barberShopCatalogService;
        this.catalogService = catalogService;
    }

    @Override
    public List<BarbershopDTO> getBarberShops() {
        List<Barbershop> barbershopList = barbershopRepository.findAll();
        return barbershopList.stream().map(
              barbershop -> barbershopMapper.toDto(barbershop)
        ).toList();
    }

    @Override
    public BarbershopDTO getBarbershopById(String id) {
        Barbershop barbershop = findBarbershopById(id);
        return barbershopMapper.toDto(barbershop);
    }

    @Override
    public Barbershop getBarbershopEntityById(String id) {
        return findBarbershopById(id);
    }

    @Override
    public String createBarberShop(CreateBarbershopDTO dto) {
        Barbershop barberShop = barbershopMapper.toEntity(dto);
        Optional<Barbershop> slug = barbershopRepository.findBySlug(barberShop.getSlug());
        if(slug.isPresent()) {
            throw new BarbershopAlreadyRegisteredException(BarbershopConstants.ALREADY_EXISTS);
        }
        barbershopRepository.save(barberShop);
        return barberShop.getId();
    }

    @Override
    public void assignServiceToBarbershop(String barbershopId, String serviceId) {
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new BarbershopNotFoundException(BarbershopConstants.NOT_FOUND));
        Catalog catalog = catalogService.findServiceById(serviceId);
        barberShopCatalogService.addServiceToBarbershop(barbershop, catalog);
    }

    @Override
    public BarbershopDTO updateBarbershop(String barbershopId, CreateBarbershopDTO dto) {
        Barbershop entity = findBarbershopById(barbershopId);
        Barbershop updatedEntity = barbershopMapper.toEntityUpdate(dto, entity);
        barbershopRepository.save(updatedEntity);
        return barbershopMapper.toDto(updatedEntity);
    }

    @Override
    public BarbershopDetailDTO getBarbershopDetail(String id) {
        Barbershop barbershop = findBarbershopById(id);
        return barbershopMapper.toDetailDto(barbershop);
    }

    private Barbershop findBarbershopById(String id) {
        return barbershopRepository.findById(id).orElseThrow(() -> new BarbershopNotFoundException(BarbershopConstants.NOT_FOUND));
    }

    private Optional<Barbershop> findBySlug(String slug) {
        return barbershopRepository.findBySlug(slug);
    }
}
