package com.example.form.validation;

import com.example.form.models.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario)  target;

        ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpy.usuario.nombre");
        if(!usuario.getidentificacion().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"))
            errors.rejectValue("identificacion", "pattern.usuario.id");
    }
}
