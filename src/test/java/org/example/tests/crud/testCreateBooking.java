package org.example.tests.crud;

import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingRespons;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import static org.assertj.core.api.Assertions.*;

public class testCreateBooking extends BaseTest {

    @Test
    @Owner("Kapil")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBooking() {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayloadGSON()).post();


        validatableResponse = response.then().log().all();
        BookingRespons bookingRespons = payloadManager.bookingResponseJava(response.asString());

        // Validatable Default
        validatableResponse.statusCode(200);

        // Assert J
        assertThat(bookingRespons.getBookingid()).isNotNull();
        assertThat(bookingRespons.getBooking().getFirstname()).isNotNull().isNotBlank();
      // assertThat(bookingRespons.getBooking().getFirstname()).isEqualTo();

        // TestNG Assertions
        assertActions.verifyStatusCode(response);

    }


}
