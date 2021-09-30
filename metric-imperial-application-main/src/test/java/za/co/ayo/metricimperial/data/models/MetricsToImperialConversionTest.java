package za.co.ayo.metricimperial.data.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MetricsToImperialConversionTest {

    @Test
    public void testPojo() {
        MetricsToImperialConversion pojo = MetricsToImperialConversion.builder().conversionType(ConversionType.TEMPERATURE)
                .conversionFormula(ConversionFormula.CELCIUS)
                .factor(BigDecimal.TEN)
                .id(1)
                .build();

        assertEquals(ConversionType.TEMPERATURE, pojo.getConversionType());
        assertEquals(ConversionFormula.CELCIUS, pojo.getConversionFormula());
        assertEquals(BigDecimal.TEN, pojo.getFactor());
        assertEquals(1, pojo.getId());
    }

}