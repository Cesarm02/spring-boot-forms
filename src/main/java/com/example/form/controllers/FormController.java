package com.example.form.controllers;

import com.example.form.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Cesar");
        usuario.setApellido("Mesa");
        usuario.setId("123215 - K");
        model.addAttribute("titulo", "Form usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model, SessionStatus sessionStatus){
        model.addAttribute("titulo", "Resultado form");
        if(result.hasErrors()){
           /*
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err ->{
                errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });
            model.addAttribute("error", errores);
            */
            return "form";
        }
        model.addAttribute("usuario", usuario);
        sessionStatus.setComplete();
        return "resultado";
    }

}
