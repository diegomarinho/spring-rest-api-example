package com.dma.example.rest.service;

import com.dma.example.rest.converter.InvoiceConverter;
import com.dma.example.rest.dto.InvoiceDto;
import com.dma.example.rest.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dma.example.rest.entity.Invoice;

@Service
public class InvoiceService {
	@Autowired
    private InvoiceRepository invoiceRepository;
	
	public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = InvoiceConverter.convertDtoToEntity(invoiceDto);
    	invoice = invoiceRepository.save(invoice);
    	InvoiceDto response = InvoiceConverter.convertEntityToDto(invoice);
    	return response;
	}
	
	public Page<Invoice> getInvoices(String invoiceNumber, String poNumber, Pageable pageable) {
		if(null != invoiceNumber) {
			return invoiceRepository.findByInvoiceNumberOrderByCreatedAtDesc(invoiceNumber, pageable);
		} else {
			return invoiceRepository.findByPoNumberOrderByCreatedAtDesc(poNumber, pageable);
		} 
	}
	
}
