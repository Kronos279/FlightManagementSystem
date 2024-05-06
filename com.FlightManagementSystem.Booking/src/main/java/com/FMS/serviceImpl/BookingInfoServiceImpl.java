package com.FMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.ApplicationUtil.ApplicationUtil;
import com.FMS.BookingInfoClient.BookingInfoClient;
import com.FMS.Exception.ResourceNotFoundException;
import com.FMS.entity.BookingInfo;
import com.FMS.entity.FlightDetails;
import com.FMS.entity.TotalFarePNR;
import com.FMS.repository.BookingInfoRepository;
import com.FMS.repository.TotalFarePNRRepository;
import com.FMS.service.BookingInfoService;

@Service
public class BookingInfoServiceImpl implements BookingInfoService{
	
	@Autowired
	BookingInfoRepository repo;
	
	@Autowired
	TotalFarePNRRepository repo_fare;
	
	FlightDetails flightdetails = new FlightDetails();
	@Autowired
	BookingInfoClient client;
	@Override
	 public List<BookingInfo> addBooking(List<BookingInfo> bookings) {
		String pnr = ApplicationUtil.generatePNR();
		BookingInfo info = bookings.get(0);
		flightdetails = client.getFlightDetailById(info.getFlight_id());
		double fare = flightdetails.getFare() * bookings.size();
		TotalFarePNR total = new TotalFarePNR();
		total.setTotalFare(fare);
		total.setPnr(pnr);
		repo_fare.save(total);
		for(BookingInfo booking :bookings){
        	booking.setPnrNumber(pnr);
            repo.save(booking);
        }
        return bookings;
    }
	
	@Override
	public BookingInfo updateBookingInfo(BookingInfo bookingInfo) {
		repo.save(bookingInfo);
		return bookingInfo;
	}

	@Override
	public BookingInfo getBookingInfoById(String id) {
		Optional<BookingInfo> bi = repo.findById(id);
		if(bi.isPresent()) {
			BookingInfo ob = bi.get();
			flightdetails = client.getFlightDetailById(ob.getFlight_id());
			ob.setFlightdetails(flightdetails);
			return ob;
		}
		else {
			throw new ResourceNotFoundException("No Bookings Found Against Id "+id);
		}
		
	}
	
	
	public List<BookingInfo> getBookingByPnr(String pnr){
		List<BookingInfo> bookings = repo.findByPnrNumber(pnr);
		List<BookingInfo> updatedBookings = new ArrayList<BookingInfo>();
		if(!bookings.isEmpty()) {
			for(BookingInfo booking: bookings) {
				flightdetails = client.getFlightDetailById(booking.getFlight_id());
				System.out.println(flightdetails);
				booking.setFlightdetails(flightdetails);
				updatedBookings.add(booking);
			}
			return updatedBookings;
		}
		else {
			throw new ResourceNotFoundException("No Bookings Found With this PNR "+pnr);
		}
		
	}
	
//	public String generatePNR() {
//		String prefix = generateRandomLetters(2);
//		int number = generateRandomNumber(999, 10000);
//		String suffix = generateRandomLetters(3);
//		return prefix+number+suffix;
//	}
//	
//	
//	public String generateRandomLetters(int num) {
//		 Random random = new Random();
//	        StringBuilder builder = new StringBuilder();
//	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alphabet characters
//	        for (int i = 0; i < num; i++) {
//	            int index = random.nextInt(characters.length());
//	            builder.append(characters.charAt(index));
//	        }
//	        return builder.toString();
//	}
//	
//	public int generateRandomNumber(int min, int max) {
//        Random random = new Random();
//        return random.nextInt(max - min + 1) + min;
//    }
//	
//	
	
	
	
	//PN2123ABC --> PNR Format

}
