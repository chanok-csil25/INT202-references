package com.example.customerCRUD.controller;

import com.example.customerCRUD.model.Office;
import com.example.customerCRUD.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping
    public String listOffices(Model model) {
        model.addAttribute("offices", officeService.getAllOffices());
        return "office_list";
    }

    @GetMapping("/add")
    public String showAddOfficeForm(Model model) {
        model.addAttribute("office", new Office());
        return "office_form";
    }

    @PostMapping("/save")
    public String saveOffice(@ModelAttribute Office office) {
        officeService.saveOffice(office);
        return "redirect:/offices";
    }

    @GetMapping("/edit/{id}")
    public String showEditOfficeForm(@PathVariable("id") int id, Model model) {
        Optional<Office> office = officeService.getOfficeById(id);
        if (office.isPresent()) {
            model.addAttribute("office", office.get());
            return "office_form";
        } else {
            return "redirect:/offices";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteOffice(@PathVariable("id") int id) {
        officeService.deleteOffice(id);
        return "redirect:/offices";
    }

    @GetMapping("/searchByCity")
    public String searchOfficesByCity(@RequestParam("city") String city, Model model) {
        List<Office> offices = officeService.getOfficesByCity(city);
        model.addAttribute("offices", offices);
        return "office_list"; // You can redirect to a specific template for displaying the search results
    }

    @GetMapping("/searchByCountry")
    public String searchOfficesByCountry(@RequestParam("country") String country, Model model) {
        List<Office> offices = officeService.getOfficesByCountry(country);
        model.addAttribute("offices", offices);
        return "office_list"; // You can redirect to a specific template for displaying the search results
    }
}
