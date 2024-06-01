package com.FMS.service;

import java.util.List;

import com.FMS.entity.BookingInfo;

public interface BookingInfoService {

	public List<BookingInfo> addBooking(List<BookingInfo> bookings);
	public BookingInfo getBookingInfoById(String id);
	public List<BookingInfo> getBookingByPnr(String pnr);
	public BookingInfo updateBookingInfo(BookingInfo bookingInfo);
	public int getBookingCountByFlightId(int id);
	}
