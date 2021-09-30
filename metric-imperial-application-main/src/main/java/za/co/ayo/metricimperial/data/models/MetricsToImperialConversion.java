package za.co.ayo.metricimperial.data.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetricsToImperialConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ConversionType conversionType;
    @Enumerated(EnumType.STRING)
    private ConversionFormula conversionFormula;
    private String fromUnit;
    private String toUnit;
    private BigDecimal factor;

}
