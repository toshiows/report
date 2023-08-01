package org.br.mineradora.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class QuotationDTO {

	private Date date;
	
	private BigDecimal currencyPrice;
}
