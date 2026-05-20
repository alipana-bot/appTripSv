package com.ejemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ejemplo.demo.model.Categoria;
import com.ejemplo.demo.service.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private ICategoriaService service;

    // LISTAR
    @GetMapping({"/index", "/"})
    public String listar(Model model) {
        model.addAttribute("categorias", service.buscarTodas());
        return "categorias/listCategoria";
    }

    // CREATE
    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formCategoria";
    }

    // SAVE (CREATE + EDIT)
    @PostMapping("/save")
    public String guardar(@ModelAttribute Categoria categoria,
                          RedirectAttributes attr) {

        service.guardar(categoria);
        attr.addFlashAttribute("msg", "Guardado correctamente");

        return "redirect:/categorias/index";
    }

    // EDIT
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model,
                         RedirectAttributes attr) {

        Categoria categoria = service.buscarPorId(id);

        if (categoria == null) {
            attr.addFlashAttribute("error", "No encontrada");
            return "redirect:/categorias/index";
        }

        model.addAttribute("categoria", categoria);
        return "categorias/formCategoria";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id,
                           RedirectAttributes attr) {

        service.eliminar(id);
        attr.addFlashAttribute("msg", "Eliminada");

        return "redirect:/categorias/index";
    }

    // TEST
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "OK CRUD";
    }

    // DEBUG
    @GetMapping("/debug")
    @ResponseBody
    public String debug() {
        return "TOTAL: " + service.buscarTodas().size();
    }
}