package com.mtit.service;

public class ServicePublishImpl implements ServicePublish {

	@Override
	public String publishService(String type, double distance) {
		AmbulanceModel ambulanceModel = new AmbulanceModel(type);
		AmbulanceService ambulanceService = new AmbulanceService();
		
		return ambulanceService.calculateAmbulanceFee(ambulanceModel, distance);
		 
	}

}
