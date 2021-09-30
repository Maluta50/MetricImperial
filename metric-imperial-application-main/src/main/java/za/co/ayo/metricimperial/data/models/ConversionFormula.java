package za.co.ayo.metricimperial.data.models;

public enum ConversionFormula {
    MULTIPLY("MULTIPLY"),

    DIVIDE("DIVIDE"),

    CELCIUS("CELCIUS"),

    FAHRENHEIT("FAHRENHEIT");

    private String code;

    ConversionFormula(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
