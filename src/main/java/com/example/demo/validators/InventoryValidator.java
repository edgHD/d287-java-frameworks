package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {

    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) {
            return true;
        }
        
        boolean isValid = true;
        
        // Skip validation if minimum or maximum inventory values aren't set
        if (part.getMinInv() == null || part.getMaxInv() == null) {
            return true;
        }
        
        // Validation rule 1: Current inventory must not be below minimum threshold
        if (part.getInv() < part.getMinInv()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Inventory (" + part.getInv() + ") cannot be less than minimum (" + part.getMinInv() + ")")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            isValid = false;
        }
        
        // Validation rule 2: Current inventory must not exceed maximum threshold
        if (part.getInv() > part.getMaxInv()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Inventory (" + part.getInv() + ") cannot be greater than maximum (" + part.getMaxInv() + ")")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            isValid = false;
        }
        
        // Validation rule 3: Minimum inventory must not be greater than maximum inventory
        if (part.getMinInv() > part.getMaxInv()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Minimum inventory (" + part.getMinInv() + ") cannot be greater than maximum (" + part.getMaxInv() + ")")
                    .addPropertyNode("minInv")
                    .addConstraintViolation();
            isValid = false;
        }
        
        return isValid;
    }
}