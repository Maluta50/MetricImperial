package za.co.ayo.metricimperial.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.ayo.metricimperial.data.models.ConversionFormula;
import za.co.ayo.metricimperial.data.models.MetricsToImperialConversion;
import za.co.ayo.metricimperial.service.MetricsToImperialConversionService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MetricsControllerTest {
    private Fixture fixture;

    @Before
    public void before() {
        fixture = new Fixture();
    }

    @Test
    public void testGtAll() {
        fixture.givenDependenciesAreMocked(ConversionFormula.CELCIUS);
        fixture.whenGetAllConversionsIcalled();
        fixture.thenResultsAre(ConversionFormula.CELCIUS, 1);
    }

    @Test
    public void testConvertMetricsToImperial() {
        fixture.givenDependenciesAreMocked("109.400000 Yards");
        fixture.whenConvertMetricsToImperialIsCalled();
        fixture.thenResultsAre("109.400000 Yards");
    }

    private class Fixture {
        @Mock
        private MetricsToImperialConversionService metricsToImperialConversionService1;

        @Mock
        private MetricsToImperialConversion metricsToImperialConversion;
        @InjectMocks
        private MetricsController metricsController;
        private ResponseEntity<List<MetricsToImperialConversion>> allMetrics;
        private ResponseEntity<String> resukts;


        public Fixture() {
            MockitoAnnotations.initMocks(this);
        }

        private void givenDependenciesAreMocked(ConversionFormula conversionFormula) {

            List<MetricsToImperialConversion> list = new ArrayList<>();
            list.add(metricsToImperialConversion);
            when(metricsToImperialConversion.getConversionFormula()).thenReturn(conversionFormula);
            when(metricsToImperialConversionService1.getAllMetrics()).thenReturn(list);
        }

        private void givenDependenciesAreMocked(String value) {
            when(metricsToImperialConversionService1.convertUnits(anyString(), anyString(), any(BigDecimal.class))).thenReturn(value);
        }

        private void whenGetAllConversionsIcalled() {
            allMetrics = metricsController.getAllMetrics();
        }

        private void whenConvertMetricsToImperialIsCalled() {
            resukts = metricsController.convertMetricsToImperial("Meters", "Yards", "100");
        }

        private void thenResultsAre(ConversionFormula conversionFormula, int size) {
            assertEquals(HttpStatus.OK, allMetrics.getStatusCode());
            assertEquals(size, allMetrics.getBody().size());
            assertEquals(conversionFormula, allMetrics.getBody().get(0).getConversionFormula());
        }

        private void thenResultsAre(String value) {
            assertEquals(HttpStatus.OK, resukts.getStatusCode());
            assertEquals(value, resukts.getBody());
        }
    }
}