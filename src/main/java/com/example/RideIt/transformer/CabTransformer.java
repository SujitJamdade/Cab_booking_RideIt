package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.CabRequest;
import com.example.RideIt.model.Cab;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){

        return Cab.builder()
                .company(cabRequest.getCompany())
                .cabNo(cabRequest.getCabNo())
                .carModel(cabRequest.getCarModel())
                .carType(cabRequest.getCarType())
                .numberOfSeats(cabRequest.getNumberOfSeats())
                .farePerKm(cabRequest.getFarePerKm())
                .build();
    }
}


/*
 String company;
    String cabNo;
    String carModel;
    @Enumerated(EnumType.STRING)
    CarType carType;
    int numberOfSeats;
    double farePerKm;
 */