package com.registration.challenge.service;

import com.registration.challenge.models.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneService extends CrudRepository<Phone, Long> {
}
