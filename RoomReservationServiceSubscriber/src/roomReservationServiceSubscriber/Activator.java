package roomReservationServiceSubscriber;


import java.util.Scanner;
import java.io.IOException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import roomReservationServicePublisher.RoomService;

public class Activator implements BundleActivator{

    private BundleContext m_context = null;
    private ServiceTracker m_tracker = null;

    public void start(BundleContext context) throws Exception{
        m_context = context;

        m_tracker = new ServiceTracker(
            m_context,
            m_context.createFilter(
                "(&(objectClass=" + RoomService.class.getName() + ")" +
                "(Language=*))"),
            null);
        m_tracker.open();

        try{
            while (true){
            	
            	System.out.println();
            	System.out.println("=====Welcome to the Lanka Hospitals====");
            	System.out.println("View room details : Press '1'");
            	System.out.println("Book a room for a patient : Press '2'");
                System.out.println("Enter a blank line to exit.");
                System.out.println("=======================================");
                System.out.println();
                
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter option: ");
                String option = sc.next();
                System.out.println();

                RoomService rs = (RoomService) m_tracker.getService();

                if (option.length() == 0){
                    break;
                }
                
                else if (rs == null){
                    System.out.println("No hospital room service available.");
                }

                else if (option.equalsIgnoreCase("1")){
                	rs.displayRooms();
                }
                
                else if(option.equalsIgnoreCase("2")){
                	
                    String reservedRoomNumber = "";
                    System.out.print("Enter room number that you want to reserve : ");
                    reservedRoomNumber = sc.next();
                    
                    int reservedDays;
                    System.out.print("Enter no of days that you want to reserve : ");
                    reservedDays = sc.nextInt();
                    
                    System.out.println("Total cost : " +rs.reserveRoom(reservedRoomNumber, reservedDays));
                }
                else {
                	System.out.println("Incorrect option");
                }
            }
        }catch (Exception ex){
        	
        }
    }


    public void stop(BundleContext context){
    	
    }
}