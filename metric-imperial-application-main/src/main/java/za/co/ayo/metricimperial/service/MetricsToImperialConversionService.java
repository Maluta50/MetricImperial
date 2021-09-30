package za.co.ayo.metricimperial.service;

import za.co.ayo.metricimperial.data.models.MetricsToImperialConversion;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface MetricsToImperialConversionService {
    List<MetricsToImperialConversion> getAllMetrics();

    String convertUnits(String fromUnit, String toUnit, BigDecimal value);
}
