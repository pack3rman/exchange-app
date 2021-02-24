package pl.kurs.java.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeRequest {
    private String currentTo;
    private String currentFrom;
    private double amount;
}
