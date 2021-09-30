package za.co.ayo.metricimperial.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import za.co.ayo.metricimperial.data.models.ConversionFormula;
import za.co.ayo.metricimperial.data.models.MetricsToImperialConversion;
import za.co.ayo.metricimperial.data.repository.MetricsToImperialConversionRepository;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MetricsToImperialConversionServiceImplTest {

    private Fixture fixture;

    @Before
    public void before() {
        fixture = new Fixture();
    }

    @Test
    public void convertUnitsCelciousToFah() {
        fixture.givenDependenciesAreMocked(ConversionFormula.CELCIUS);
        fixture.whenConvertUnitISCalled("CELCIUS", "FAHRENHEIT", new BigDecimal("100"));
        fixture.thenResultsAre("212 FAHRENHEIT");
    }

    @Test
    public void convertUnitsFahToCelcious() {
        fixture.givenDependenciesAreMocked(ConversionFormula.FAHRENHEIT);
        fixture.whenConvertUnitISCalled("FAHRENHEIT", "CELCIUS", new BigDecimal("100"));
        fixture.thenResultsAre("37 CELCIUS");
    }

    @Test
    public void convertUnitsMultiply() {
        fixture.givenDependenciesAreMocked(ConversionFormula.MULTIPLY, new BigDecimal("1.094000"));
        fixture.whenConvertUnitISCalled("Meters", "Yards", new BigDecimal("100"));
        fixture.thenResultsAre("109.400000 Yards");
    }

    @Test
    public void convertUnitsDivide() {
        fixture.givenDependenciesAreMocked(ConversionFormula.DIVIDE, new BigDecimal("1.094000"));
        fixture.whenConvertUnitISCalled("Yards", "Meters", new BigDecimal("100"));
        fixture.thenResultsAre("91.4077 Meters");
    }

    private class Fixture {
        @Mock
        private MetricsToImperialConversionRepository metricsToImperialConversionRepository;

        @Mock
        private MetricsToImperialConversion metricsToImperialConversion;

        @InjectMocks
        private MetricsToImperialConversionServiceImpl metricsToImperialConversionService;

        private String convertUnits;

        public Fixture() {
            MockitoAnnotations.initMocks(this);
        }

        private void givenDependenciesAreMocked(ConversionFormula conversionFormula) {
            when(metricsToImperialConversion.getConversionFormula()).thenReturn(conversionFormula);
            when(metricsToImperialConversionRepository.findByFromUnitAndToUnit(anyString(), anyString())).thenReturn(metricsToImperialConversion);
        }

        private void givenDependenciesAreMocked(ConversionFormula conversionFormula, BigDecimal factor) {
            when(metricsToImperialConversion.getFactor()).thenReturn(factor);
            when(metricsToImperialConversion.getConversionFormula()).thenReturn(conversionFormula);
            when(metricsToImperialConversionRepository.findByFromUnitAndToUnit(anyString(), anyString())).thenReturn(metricsToImperialConversion);
        }

        private void whenConvertUnitISCalled(String fromUnit, String toUnit, BigDecimal value) {
            convertUnits = metricsToImperialConversionService.convertUnits(fromUnit, toUnit, value);
        }

        private void thenResultsAre(String value) {
            assertEquals(value, convertUnits);
        }
    }
}
