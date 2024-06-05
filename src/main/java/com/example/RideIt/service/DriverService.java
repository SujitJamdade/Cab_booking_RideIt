package com.example.RideIt.service;

import com.example.RideIt.dto.request.CabRequest;
import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Driver;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.transformer.CabTransformer;
import com.example.RideIt.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;
    public String addDriver(DriverRequest driverRequest) {

        CabRequest cabRequest = driverRequest.getCab();

        // driver request >> driver
        // cab request >> cab

        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);

        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCab());

        // Set The relationship attribute
        driver.setCab(cab);
        cab.setDriver(driver);

        Driver savedDriver = driverRepository.save(driver);

        return "Driver & Cab saved Successfully !";

    }
}
