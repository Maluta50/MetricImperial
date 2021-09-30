package za.co.ayo.metricimperial.service;

import za.co.ayo.metricimperial.data.models.MetricsToImperialConversion;
import za.co.ayo.metricimperial.data.repository.MetricsToImperialConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class MetricsToImperialConversionServiceImpl implements MetricsToImperialConversionService {

    @Autowired
    private MetricsToImperialConversionRepository metricsToImperialConversionRepository;

    @Override
    public List<MetricsToImperialConversion> getAllMetrics() {
        return metricsToImperialConversionRepository.findAll();
    }

    @Override
    public String convertUnits(String fromUnit, String toUnit, BigDecimal value) {
        MetricsToImperialConversion conversion = metricsToImperialConversionRepository.findByFromUnitAndToUnit(fromUnit, toUnit);
        BigDecimal convertedValue = null;

        switch (conversion.getConversionFormula().getCode()) {
            case "MULTIPLY":
                convertedValue = value.multiply(conversion.getFactor());
                break;
            case "DIVIDE":
                convertedValue = value.divide(conversion.getFactor(), 4, RoundingMode.HALF_UP);
                break;
            case "CELCIUS":
                int celcius = (value.intValue() * 9 / 5) + 32;
                convertedValue = new BigDecimal(celcius);
                break;
            case "FAHRENHEIT":
                int farhre = (value.intValue() - 32) * 5 / 9;
                convertedValue = new BigDecimal(farhre);
                break;
        }

        return convertedValue + " " + toUnit;
    }
}
