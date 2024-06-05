package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){

        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .panNumber(driverRequest.getPanNumber())
                .mobNo(driverRequest.getMobNo())
                .rating(0)
                .build();
    }
}
