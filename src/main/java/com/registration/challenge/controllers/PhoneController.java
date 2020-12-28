package com.registration.challenge.controllers;

import com.registration.challenge.models.Phone;
import com.registration.challenge.repositories.PhoneRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @PostMapping
    public Phone create(@RequestBody Phone phone) {
        return phoneRepository.saveAndFlush(phone);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Phone update(@PathVariable Long id, @RequestBody Phone phone) {
        Phone existingPhone = phoneRepository.getOne(id);
        BeanUtils.copyProperties(phone, existingPhone, "phone_id");
        return phoneRepository.saveAndFlush(existingPhone);
    }
}
