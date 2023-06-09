package lk.carsnow.spring.service;

import lk.carsnow.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO driver);

    void updateDriver(DriverDTO driver);

    void deleteDriver(String id);

    DriverDTO searchDriver(String id);

    List<DriverDTO> getAllDrivers();

    String generateDriverIds();

    DriverDTO searchUserFromDriver(String id);

    DriverDTO assignRandomlyDriver(String release);

    List<DriverDTO> searchAvailableDriversOrReleaseDrivers(String release);

    int availableDriversOrOccupiedDrivers(String release);


}
