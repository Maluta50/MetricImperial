package za.co.ayo.metricimperial;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCelciousToFahrenheit() throws Exception {
        this.mockMvc.perform(get("/metrics/CELCIUS/FAHRENHEIT/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("212 FAHRENHEIT")));
    }

    @Test
    public void testFahrenheitToCelcious() throws Exception {
        this.mockMvc.perform(get("/metrics/FAHRENHEIT/CELCIUS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("37 CELCIUS")));
    }

    @Test
    public void testSqCentimetersToSqInches() throws Exception {
        this.mockMvc.perform(get("/metrics/SQCentimeters/SQInches/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("15.4991 SQInches")));
    }

    @Test
    public void testSqMetersToSqYards() throws Exception {
        this.mockMvc.perform(get("/metrics/SQMeters/SQYards/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("119.600000 SQYards")));
    }

    @Test
    public void testSqKilometerToSqMiles() throws Exception {
        this.mockMvc.perform(get("/metrics/SQKilometers/SQMiles/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("38.6100 SQMiles")));
    }

    @Test
    public void testSqYardsToSqMeters() throws Exception {
        this.mockMvc.perform(get("/metrics/SQYards/SQMeters/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("83.6120 SQMeters")));
    }

    @Test
    public void testSqMilesToSqKilometers() throws Exception {
        this.mockMvc.perform(get("/metrics/SQMiles/SQKilometers/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("259.000000 SQKilometers")));
    }

    @Test
    public void testCubicCentimetersToCubicInches() throws Exception {
        this.mockMvc.perform(get("/metrics/CUBICCENTIMETERS/CUBICINCHES/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("6.1024 CUBICINCHES")));
    }

    @Test
    public void testCubicInchesToCubicCentimeters() throws Exception {
        this.mockMvc.perform(get("/metrics/CUBICINCHES/CUBICCENTIMETERS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("1638.700000 CUBICCENTIMETERS")));
    }

    @Test
    public void testCubicDecimetersToCubicFeet() throws Exception {
        this.mockMvc.perform(get("/metrics/CUBICDECIMETERS/CUBICFEET/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("3.5336 CUBICFEET")));
    }

    @Test
    public void testCubicFeetToCubicDecimeters() throws Exception {
        this.mockMvc.perform(get("/metrics/CUBICFEET/CUBICDECIMETERS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("2830.000000 CUBICDECIMETERS")));
    }

    @Test
    public void testCubicMetersToCubicYards() throws Exception {
        this.mockMvc.perform(get("/metrics/CUBICMETERS/CUBICYARDS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("130.800000 CUBICYARDS")));
    }

    @Test
    public void testCubicYardsToCubicMeters() throws Exception {
        this.mockMvc.perform(get("/metrics/CUBICYARDS/CUBICMETERS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("76.4526 CUBICMETERS")));
    }

    @Test
    public void testMilliGramsToGrains() throws Exception {
        this.mockMvc.perform(get("/metrics/MILLIGRAMS/GRAINS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("0.1000 GRAINS")));
    }

    @Test
    public void testGrainsToMilliGrams() throws Exception {
        this.mockMvc.perform(get("/metrics/GRAINS/MILLIGRAMS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("100000.000000 MILLIGRAMS")));
    }

    @Test
    public void testGramsToOunces() throws Exception {
        this.mockMvc.perform(get("/metrics/GRAMS/OUNCES/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("3.5273 OUNCES")));
    }

    @Test
    public void testOuncesToGrams() throws Exception {
        this.mockMvc.perform(get("/metrics/OUNCES/GRAMS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("2835.000000 GRAMS")));
    }

    @Test
    public void testKilogramsToPounds() throws Exception {
        this.mockMvc.perform(get("/metrics/KILOGRAMS/POUNDS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("220.500000 POUNDS")));
    }

    @Test
    public void testPoundsToKilograms() throws Exception {
        this.mockMvc.perform(get("/metrics/POUNDS/KILOGRAMS/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("45.3515 KILOGRAMS")));
    }

    @Test
    public void testCentimetersToInches() throws Exception {
        this.mockMvc.perform(get("/metrics/Centimeters/Inches/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("39.3701 Inches")));
    }

    @Test
    public void testMetersToYards() throws Exception {
        this.mockMvc.perform(get("/metrics/Meters/Yards/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("109.400000 Yards")));
    }

    @Test
    public void testKilometersToMiles() throws Exception {
        this.mockMvc.perform(get("/metrics/Kilometers/Miles/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("62.1504 Miles")));
    }

    @Test
    public void testInchesToCentimeters() throws Exception {
        this.mockMvc.perform(get("/metrics/Inches/Centimeters/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("254.000000 Centimeters")));
    }

    @Test
    public void testYardsToMeters() throws Exception {
        this.mockMvc.perform(get("/metrics/Yards/Meters/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("91.4077 Meters")));
    }

    @Test
    public void testMilesToKilometers() throws Exception {
        this.mockMvc.perform(get("/metrics/Miles/Kilometers/convert/100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("160.900000 Kilometers")));
    }
}