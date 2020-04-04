package com.mtit.service;

public class AmbulanceService {
	public String calculateAmbulanceFee(AmbulanceModel ambulance, double distance) {
		String type = ambulance.getAmbulanceType();
		
		if(type.equals("A")) {
			return "====================================================\n"+
					
					"AMBULANCE TYPE:\t" + type + 
					"\nDISTANCE:\t"+ distance +
					"\n---------------------------------"+
					"\nFEE =\tRs. " + ( distance * 50.00)+
					"\n---------------------------------"; 
		}else if (type.equals("B")){
			return "====================================================\n"+
					"AMBULANCE TYPE:\t" + type + 
					"\nDISTANCE:\t"+ distance +
					"\nRATE:\tRs. 30/km" +
					"\n---------------------------------"+
					"\nFEE =\tRs. " + ( distance * 30.00)+
					"\n---------------------------------"; 
		}else if (type.equals("C")){
			return "====================================================\n"+
					"AMBULANCE TYPE:\t" + type + 
					"\nDISTANCE:\t"+ distance +
					"\nRATE:\tRs. 20/km" +
					"\n---------------------------------"+
					"\nFEE = Rs. \t" + ( distance * 20.00)+
					"\n---------------------------------"; 
		}else {
			return "INVALID AMBULANCE TYPE!";
		}
		
	}
}
