package com.example.customerCRUD.service;

import com.example.customerCRUD.model.Office;
import com.example.customerCRUD.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public void saveOffice(Office office) {
        officeRepository.save(office);
    }

    public Optional<Office> getOfficeById(int id) {
        return officeRepository.findById(id);
    }

    public void deleteOffice(int id) {
        officeRepository.deleteById(id);
    }

    public List<Office> getOfficesByCity(String city) {
        return officeRepository.findByCity(city);
    }

    public List<Office> getOfficesByCountry(String country) {
        return officeRepository.findByCountry(country);
    }
}
