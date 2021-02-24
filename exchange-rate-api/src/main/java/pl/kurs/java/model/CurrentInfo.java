package pl.kurs.java.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@Builder
public class CurrentInfo {
    private String base;
    private Map<String,Double> rates;
    private Date date;
}
