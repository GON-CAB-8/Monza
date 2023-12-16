package com.proton.monza.controller;

import com.proton.monza.service.FileLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileLoaderController {
    @Autowired
    private FileLoaderService fileLoaderService;

    @GetMapping("/cargar-archivo")
    public String cargarArchivo() {
        return "archivo/cargar";
    }

    @PostMapping("/cargar-archivo")
    public String cargarArchivo(@RequestParam("archivo") MultipartFile archivo, Model model) {
        // Lógica para cargar el archivo y procesar los datos
        // Puedes pasar información adicional al modelo si es necesario
        model.addAttribute("mensaje", "Archivo cargado con éxito");
        return "archivo/cargar";
    }

}
