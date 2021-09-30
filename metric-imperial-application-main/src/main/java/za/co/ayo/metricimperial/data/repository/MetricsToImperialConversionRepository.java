package za.co.ayo.metricimperial.data.repository;

import za.co.ayo.metricimperial.data.models.MetricsToImperialConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricsToImperialConversionRepository extends JpaRepository<MetricsToImperialConversion, Integer> {
    MetricsToImperialConversion findByFromUnitAndToUnit(String fromUnit, String toUnit);
    //MetricsToImperialConversion findByConvertionType(String conversionType);
}
