package com.mtit.service;

public class AmbulanceService {
	public String calculateAmbulanceFee(AmbulanceModel ambulance, double distance) {
		String type = ambulance.getAmbulanceType();
		
		if(type.equals("A")) {
			return "Fee = " + ( distance * 50.00); 
		}else {
			return "Fee = " + ( distance * 10.00); 
		}
		
	}
}
