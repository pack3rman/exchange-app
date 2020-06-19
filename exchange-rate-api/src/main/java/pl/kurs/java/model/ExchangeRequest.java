package pl.kurs.java.model;

import lombok.Data;

@Data
public class ExchangeRequest {
    private String currentTo;
    private String currentFrom;
    private double amount;
}
