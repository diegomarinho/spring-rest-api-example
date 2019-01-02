package com.dma.example.rest.converter;

import org.modelmapper.ModelMapper;

import com.dma.example.rest.dto.InvoiceDto;
import com.dma.example.rest.entity.Invoice;

public class InvoiceConverter {
	private static final ModelMapper modelMapper = new ModelMapper();
	
	public static Invoice convertDtoToEntity(InvoiceDto invoiceDto) {
		return modelMapper.map(invoiceDto, Invoice.class);
	}
	
	public static InvoiceDto convertEntityToDto(Invoice invoice) {
		return modelMapper.map(invoice, InvoiceDto.class);
	}
}
