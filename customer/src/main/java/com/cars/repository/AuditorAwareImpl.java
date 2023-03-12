package com.cars.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Value("${spring.auditor.user}")
    private String auditUser;
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(auditUser);
    }
}
