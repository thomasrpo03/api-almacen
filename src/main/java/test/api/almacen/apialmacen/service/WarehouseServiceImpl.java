package test.api.almacen.apialmacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.api.almacen.apialmacen.model.warehouse.*;
import test.api.almacen.apialmacen.repository.WarehouseRepository;

import javax.transaction.Transactional;

@Service
public class WarehouseServiceImpl implements WarehouseService{

    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public WarehouseResponseData createWarehouse(CreateWarehouseData createWarehouseData) {
        Warehouse warehouse = warehouseRepository.save(new Warehouse(createWarehouseData));
        return new WarehouseResponseData(warehouse.getId(), warehouse.getName(), warehouse.getPrefixBilling(), warehouse.getPrefixConsecutive(), warehouse.getCostCenter(), warehouse.getProductionWarehouse(), warehouse.getMaxQuantity());
    }

    @Override
    public Page<ListWarehouseData> getAllWarehouses(Pageable pagination) {
        return warehouseRepository.findByActiveTrue(pagination).map(ListWarehouseData::new);
    }

    @Override
    public WarehouseResponseData getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.getReferenceById(id);
        return new WarehouseResponseData(warehouse.getId(), warehouse.getName(), warehouse.getPrefixBilling(), warehouse.getPrefixConsecutive(), warehouse.getCostCenter(), warehouse.getProductionWarehouse(), warehouse.getMaxQuantity());
    }

    @Override
    public WarehouseResponseData updateWarehouse(Long id, UpdateWarehouseData updateWarehouseData) {
        Warehouse warehouse = warehouseRepository.getReferenceById(id);
        warehouse.updateData(updateWarehouseData);
        warehouseRepository.save(warehouse); // Guarda los cambios en la base de datos
        return new WarehouseResponseData(warehouse.getId(), warehouse.getName(), warehouse.getPrefixBilling(), warehouse.getPrefixConsecutive(), warehouse.getCostCenter(), warehouse.getProductionWarehouse(), warehouse.getMaxQuantity());
    }

    @Override
    @Transactional
    public void deactivateWarehouse(Long id) {
        Warehouse warehouse = warehouseRepository.getReferenceById(id);
        warehouse.deactivateWarehouse();
    }
}
