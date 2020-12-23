package br.com.concrete.challenge.controllers;

import br.com.concrete.challenge.models.Phone;
import br.com.concrete.challenge.repositories.PhoneRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping
    @RequestMapping("{id}")
    public Phone get(@PathVariable Long id) {
        return phoneRepository.getOne(id);
    }

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
