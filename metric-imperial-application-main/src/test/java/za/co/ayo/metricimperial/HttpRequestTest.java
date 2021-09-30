package za.co.ayo.metricimperial;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.ayo.metricimperial.data.models.MetricsToImperialConversion;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void tesThatAllConversionsAreReturned() throws Exception {
        ResponseEntity<List<MetricsToImperialConversion>> resp = restTemplate.exchange("http://localhost:" + port + "/metrics/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<MetricsToImperialConversion>>() {
                });
        assertEquals(HttpStatus.OK.value(), resp.getStatusCode().value());
        List<MetricsToImperialConversion> body = resp.getBody();
        assertEquals(26, body.size());// increase as we add new units
    }

    @Test
    //metrics/CELCIUS/FAHRENHEIT/convert/100
    public void testCelciousToFahrenheit() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/CELCIUS/FAHRENHEIT/convert/100",
                String.class);
        assertEquals("212 FAHRENHEIT", convertTedValue);
    }

    @Test
    //metrics/FAHRENHEIT/CELCIUS/convert/100
    public void testFahrenheitToCelcious() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/FAHRENHEIT/CELCIUS/convert/100",
                String.class);
        assertEquals("37 CELCIUS", convertTedValue);
    }

    @Test
    //metrics/SQCentimeters/SQInches/convert/100
    public void testSqCentimetersToSqInches() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/SQCentimeters/SQInches/convert/100",
                String.class);
        assertEquals("15.4991 SQInches", convertTedValue);
    }

    @Test
    //metrics/SQMeters/SQYards /convert/100
    public void testSqMetersToSqYards() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/SQMeters/SQYards/convert/100",
                String.class);
        assertEquals("119.600000 SQYards", convertTedValue);
    }

    @Test
    //metrics/SQKilometers/SQMiles /convert/100
    public void testSqKilometerToSqMiles() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/SQKilometers/SQMiles/convert/100",
                String.class);
        assertEquals("38.6100 SQMiles", convertTedValue);
    }

    @Test
    //metrics/SQInches/SQCentimeters /convert/100
    public void testSqInchesToSqCentimeters() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/SQInches/SQCentimeters/convert/100",
                String.class);
        assertEquals("645.200000 SQCentimeters", convertTedValue);
    }


    @Test
    //metrics/SQYards/SQMeters /convert/100
    public void testSqYardsToSqMeters() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/SQYards/SQMeters/convert/100",
                String.class);
        assertEquals("83.6120 SQMeters", convertTedValue);
    }

    @Test
    //metrics/SQMiles/SQKilometers/convert/100
    public void testSqMilesToSqKilometers() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/SQMiles/SQKilometers/convert/100",
                String.class);
        assertEquals("259.000000 SQKilometers", convertTedValue);
    }

    @Test
    //metrics/CUBICCENTIMETERS/CUBICINCHES/convert/100
    public void testCubicCentimetersToCubicInches() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/CUBICCENTIMETERS/CUBICINCHES/convert/100",
                String.class);
        assertEquals("6.1024 CUBICINCHES", convertTedValue);
    }

    @Test
    //metrics/CUBICINCHES/CUBICCENTIMETERS/convert/100
    public void testCubicInchesToCubicCentimeters() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/CUBICINCHES/CUBICCENTIMETERS/convert/100",
                String.class);
        assertEquals("1638.700000 CUBICCENTIMETERS", convertTedValue);
    }

    @Test
    //metrics/CUBICDECIMETERS/CUBICFEET/convert/100
    public void testCubicDecimetersToCubicFeet() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/CUBICDECIMETERS/CUBICFEET/convert/100",
                String.class);
        assertEquals("3.5336 CUBICFEET", convertTedValue);
    }

    @Test
    //metrics/CUBICFEET/CUBICDECIMETERS/convert/100
    public void testCubicFeetToCubicDecimeters() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/CUBICFEET/CUBICDECIMETERS/convert/100",
                String.class);
        assertEquals("2830.000000 CUBICDECIMETERS", convertTedValue);
    }

    @Test
    //metrics/CUBICMETERS/CUBICYARDS/convert/100
    public void testCubicMetersToCubicYards() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/CUBICMETERS/CUBICYARDS/convert/100",
                String.class);
        assertEquals("130.800000 CUBICYARDS", convertTedValue);
    }

    @Test
    //metrics/CUBICYARDS/CUBICMETERS/convert/100
    public void testCubicYardsToCubicMeters() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/CUBICYARDS/CUBICMETERS/convert/100",
                String.class);
        assertEquals("76.4526 CUBICMETERS", convertTedValue);
    }

    @Test
    //metrics/MILLIGRAMS/GRAINS/convert/100
    public void testMilliGramsToGrains() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/MILLIGRAMS/GRAINS/convert/100",
                String.class);
        assertEquals("0.1000 GRAINS", convertTedValue);
    }

    @Test
    //metrics/GRAINS/MILLIGRAMS/convert/100
    public void testGrainsToMilliGrams() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/GRAINS/MILLIGRAMS/convert/100",
                String.class);
        assertEquals("100000.000000 MILLIGRAMS", convertTedValue);
    }

    @Test
    //metrics/GRAMS/OUNCES/convert/100
    public void testGramsToOunces() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/GRAMS/OUNCES/convert/100",
                String.class);
        assertEquals("3.5273 OUNCES", convertTedValue);
    }

    @Test
    //metrics/OUNCES/GRAMS/convert/100
    public void testOuncesToGrams() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/OUNCES/GRAMS/convert/100",
                String.class);
        assertEquals("2835.000000 GRAMS", convertTedValue);
    }

    @Test
    //metrics/KILOGRAMS/POUNDS/convert/100
    public void testKilogramsToPounds() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/KILOGRAMS/POUNDS/convert/100",
                String.class);
        assertEquals("220.500000 POUNDS", convertTedValue);
    }

    @Test
    //metrics/POUNDS/KILOGRAMS/convert/100
    public void testPoundsToKilograms() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/POUNDS/KILOGRAMS/convert/100",
                String.class);
        assertEquals("45.3515 KILOGRAMS", convertTedValue);
    }

    @Test
    //metrics/Centimeters/Inches/convert/100
    public void testCentimetersToInches() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/Centimeters/Inches/convert/100",
                String.class);
        assertEquals("39.3701 Inches", convertTedValue);
    }

    @Test
    //metrics/Meters/Yards/convert/100
    public void testMetersToYards() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/Meters/Yards/convert/100",
                String.class);
        assertEquals("109.400000 Yards", convertTedValue);
    }

    @Test
    //metrics/Kilometers/Miles/convert/100
    public void testKilometersToMiles() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/Kilometers/Miles/convert/100",
                String.class);
        assertEquals("62.1504 Miles", convertTedValue);
    }

    @Test
    //metrics/Inches/Centimeters/convert/100
    public void testInchesToCentimeters() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/Inches/Centimeters/convert/100",
                String.class);
        assertEquals("254.000000 Centimeters", convertTedValue);
    }

    @Test
    //metrics/Yards/Meters/convert/100
    public void testYardsToMeters() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/Yards/Meters/convert/100",
                String.class);
        assertEquals("91.4077 Meters", convertTedValue);
    }

    @Test
    //metrics/Miles/Kilometers/convert/100
    public void testMilesToKilometers() throws Exception {
        String convertTedValue = this.restTemplate.getForObject("http://localhost:" + port + "/metrics/Miles/Kilometers/convert/100",
                String.class);
        assertEquals("160.900000 Kilometers", convertTedValue);
    }

}