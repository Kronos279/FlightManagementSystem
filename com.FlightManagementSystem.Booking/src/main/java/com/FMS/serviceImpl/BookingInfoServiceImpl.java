package com.FMS.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.BookingInfoClient.BookingInfoClient;
import com.FMS.entity.BookingInfo;
import com.FMS.entity.FlightDetails;
import com.FMS.repository.BookingInfoRepository;
import com.FMS.service.BookingInfoService;

@Service
public class BookingInfoServiceImpl implements BookingInfoService{
	
	@Autowired
	BookingInfoRepository repo;
	
	FlightDetails flightdetails = new FlightDetails();
	@Autowired
	BookingInfoClient client;
	@Override
	 public List<BookingInfo> addBooking(List<BookingInfo> bookings) {
		String pnr = generatePNR();
		for (BookingInfo booking :bookings) {
        	booking.setPnrNumber(pnr);
            repo.save(booking);
        }
        return bookings;
    }

	@Override
	public BookingInfo getBookingInfoById(String id) {
		Optional<BookingInfo> bi = repo.findById(id);
		if(bi.isPresent()) {
			BookingInfo ob = bi.get();
			flightdetails = client.getFlightDetailById(ob.getFlight_id());
			ob.setFlightetails(flightdetails);
			return ob;
		}
		else {
			return null;
		}
		
	}
	
	
	public List<BookingInfo> getBookingByPnr(String pnr){
		List<BookingInfo> bookings = repo.findByPnrNumber(pnr);
		if(!bookings.isEmpty()) {
			for(BookingInfo booking: bookings) {
				flightdetails = client.getFlightDetailById(booking.getFlight_id());
				booking.setFlightetails(flightdetails);
			}
		}
		return bookings;
	}
	
	public String generatePNR() {
		String prefix = generateRandomLetters(2);
		int number = generateRandomNumber(999, 10000);
		String suffix = generateRandomLetters(3);
		return prefix+number+suffix;
	}
	
	
	public String generateRandomLetters(int num) {
		 Random random = new Random();
	        StringBuilder builder = new StringBuilder();
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alphabet characters
	        for (int i = 0; i < num; i++) {
	            int index = random.nextInt(characters.length());
	            builder.append(characters.charAt(index));
	        }
	        return builder.toString();
	}
	
	public int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
	
	
	
	
	
	//PN2123ABC --> PNR Format

}
