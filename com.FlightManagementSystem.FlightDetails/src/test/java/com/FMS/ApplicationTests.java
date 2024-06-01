//package com.FMS;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.FMS.entity.FlightDetails;
//import com.FMS.entity.FlightSeat;
//import com.FMS.repository.FlightDetailsRepository;
//import com.FMS.repository.FlightSeatRepository;
//import com.FMS.serviceImpl.FlightDetailsServiceImpl;
//import com.FMS.serviceImpl.FlightSeatServiceImpl;
//
//@SpringBootTest
//class ApplicationTests {
//
//	@Mock
//    private FlightDetailsRepository flightDetailsRepository;
//
//    @Mock
//    private FlightSeatServiceImpl flightSeatService;
//
//    @InjectMocks
//    private FlightDetailsServiceImpl flightDetailsService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//	
//	 	@Test
//	    void testFlightDetailsEntity() {
//	        
//	        FlightDetails flightDetails = new FlightDetails();
//	        
//	        flightDetails.setFlight_id(1);
//	        flightDetails.setFlight_number("ABC123");
//	        flightDetails.setSource("New York");
//	        flightDetails.setDestination("Los Angeles");
//	        flightDetails.setDeparture_time("10:00 AM");
//	        flightDetails.setFare(500.00);
//	        
//	        
//	        assertEquals(1, flightDetails.getFlight_id());
//	        assertEquals("ABC123", flightDetails.getFlight_number());
//	        assertEquals("New York", flightDetails.getSource());
//	        assertEquals("Los Angeles", flightDetails.getDestination());
//	        assertNotNull(flightDetails.getDate());
//	        assertEquals("10:00 AM", flightDetails.getDeparture_time());
//	        assertEquals(500.00, flightDetails.getFare());
//	    }
//	 	
//	 	
//
//	    @Test
//	    void testGetAll() {
//	        List<FlightDetails> flightDetailsList = new ArrayList<>();
//	        flightDetailsList.add(new FlightDetails(1, "ABC123", "New York", "Los Angeles", null, "10:00 AM", 500.00));
//	        flightDetailsList.add(new FlightDetails(2, "DEF456", "Los Angeles", "New York", null, "2:00 PM", 550.00));
//
//	        when(flightDetailsRepository.findAll()).thenReturn(flightDetailsList);
//
//	        List<FlightDetails> result = flightDetailsService.getAll();
//
//	        assertEquals(2, result.size());
//	    }
//
//	    @Test
//	    void testGetFlightDetailsById() {
//	        FlightDetails flightDetails = new FlightDetails(1, "ABC123", "New York", "Los Angeles", null, "10:00 AM", 500.00);
//
//	        when(flightDetailsRepository.findById(1)).thenReturn(Optional.of(flightDetails));
//
//	        FlightDetails result = flightDetailsService.getFlightDetailsById(1);
//
//	        assertNotNull(result);
//	        assertEquals(1, result.getFlight_id());
//	        assertEquals("ABC123", result.getFlight_number());
//	        assertEquals("New York", result.getSource());
//	        assertEquals("Los Angeles", result.getDestination());
//	        assertNull(result.getDate());
//	        assertEquals("10:00 AM", result.getDeparture_time());
//	        assertEquals(500.00, result.getFare());
//	    }
//
//	    @Test
//	    void testAddFlightDetails() {
//	        FlightDetails flightDetails = new FlightDetails(1, "ABC123", "New York", "Los Angeles", null, "10:00 AM", 500.00);
//
//	        when(flightDetailsRepository.save(any(FlightDetails.class))).thenReturn(flightDetails);
//
//	        FlightDetails result = flightDetailsService.addFlightDetails(flightDetails);
//
//	        assertNotNull(result);
//	        assertEquals(1, result.getFlight_id());
//	        assertEquals("ABC123", result.getFlight_number());
//	        assertEquals("New York", result.getSource());
//	        assertEquals("Los Angeles", result.getDestination());
//	        assertNull(result.getDate()); 
//	        assertEquals("10:00 AM", result.getDeparture_time());
//	        assertEquals(500.00, result.getFare());
//	        verify(flightSeatService, times(1)).createFlightSeats(anyInt());
//	    }
//
//	    @Test
//	    void testDeleteFlightDetails() {
//	        FlightDetails flightDetails = new FlightDetails(1, "ABC123", "New York", "Los Angeles", null, "10:00 AM", 500.00);
//
//	        FlightDetails result = flightDetailsService.deleteFlightDetails(1);
//	        assertNull(result);
//	        verify(flightDetailsRepository, times(1)).deleteById(1);
//	    }
//	    
//	    
//	    
//	    //Not Working
//	    
//	    @Mock
//	    private FlightSeatRepository flightSeatRepository;
//
//	    
//	    @Test
//	    void testCreateFlightSeats() {
//	        int flightId = 123; // Example flight ID
//
//	        // Perform operation
//	        String result = flightSeatService.createFlightSeats(flightId);
//
//	        // Verify repository save method is called 180 times
//	        verify(flightSeatRepository, times(1)).save(any(FlightSeat.class));
//
//	        
//	        assertEquals("Successful", result);
//	    }
//
//}
