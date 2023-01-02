package com.svg.java.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvoicesController {
    
    @Autowired
    InvoiceService invoiceService;

    @RequestMapping("/invoicesList")
    public String invoicesList(Model model) {
        // Model is used to communicate from the controller to the list, 
        // it has a hash similar structure
        List<Invoice> invoices = invoiceService.getAll();        
        model.addAttribute("invoicesList", invoices);
        return "invoicesList"; 
    }

    @RequestMapping("/invoiceNewForm")
	public String invoiceNewForm(Model modelo) {
		modelo.addAttribute("invoice", new Invoice());
		return "invoiceNewForm";
	}

    @RequestMapping("/invoiceInsertForm")
    public String invoicesInsert(Model model, @ModelAttribute Invoice invoice) {
        invoiceService.insert(invoice);
        List<Invoice> invoices = invoiceService.getAll();
        model.addAttribute("invoicesList", invoices);
        return "invoicesList";
    }

    @RequestMapping("/invoiceEditForm")
    public String invoiceEditForm(@RequestParam("number") int number, Model model, @ModelAttribute Invoice invoice) {
        model.addAttribute("invoice", invoiceService.find(number));
        return "invoiceEditForm";
    }

    @RequestMapping("/invoiceSaveForm")
    public String invoiceSaveForm(Model model, @ModelAttribute Invoice invoice) {
        invoiceService.update(invoice);
        List<Invoice> invoices = invoiceService.getAll();
        model.addAttribute("invoicesList", invoices);
        return "invoicesList";
    }

    @RequestMapping("/invoiceDelete")
    public String invoiceDelete(@RequestParam("number") int number, Model model, @ModelAttribute Invoice invoice) {
        invoiceService.delete(new Invoice(number));
        List<Invoice> invoices = invoiceService.getAll();
        model.addAttribute("invoicesList", invoices);
        return "invoicesList";
    }

}
