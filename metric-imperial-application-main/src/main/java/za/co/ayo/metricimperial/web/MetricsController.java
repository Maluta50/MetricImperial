package za.co.ayo.metricimperial.web;

import org.springframework.web.bind.annotation.*;
import za.co.ayo.metricimperial.data.models.MetricsToImperialConversion;
import za.co.ayo.metricimperial.service.MetricsToImperialConversionService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/metrics")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down."),
}
)
public class MetricsController {

    @Autowired
    MetricsToImperialConversionService metricsToImperialConversionService;

    @GetMapping("/all")
    public ResponseEntity<List<MetricsToImperialConversion>> getAllMetrics() {
        List<MetricsToImperialConversion> metrics = metricsToImperialConversionService.getAllMetrics();
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

    @GetMapping(path = "/{fromUnit}/{toUnit}/convert/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> convertMetricsToImperial(@PathVariable(name = "fromUnit") String fromUnit,
                                                           @PathVariable(name = "toUnit") String toUnit,
                                                           @PathVariable(name = "value") String value) {
        String metrics = metricsToImperialConversionService.convertUnits(fromUnit, toUnit, new BigDecimal(value));
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

}
