package pl.kurs.java.model;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class CurrentInfo {
    private String base;
    private Map<String,Double> rates;
    private Date date;
}
