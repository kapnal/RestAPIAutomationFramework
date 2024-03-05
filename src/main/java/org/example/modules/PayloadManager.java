package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {

    Gson gson;

    // JAVA -> JSON

    public String createPayloadGSON() {
        Faker faker = new Faker();

        Booking booking = new Booking();
        String expectFirstName = faker.name().firstName();


        booking.setFirstname(expectFirstName);
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        // Object -> JSON String (GSON)
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    public BookingRespons bookingResponseJava(String responseString){
        gson = new Gson();
        BookingRespons bookingRespons = gson.fromJson(responseString,BookingRespons.class);
        return bookingRespons;

    }


}
