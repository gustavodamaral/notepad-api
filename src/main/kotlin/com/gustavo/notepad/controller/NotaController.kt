package com.gustavo.notepad.controller

import com.gustavo.notepad.model.Nota
import com.gustavo.notepad.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/nota")
class NotaController{


    @Autowired
    lateinit var notaService: NotaService

    @GetMapping("/check")
    fun checkHealth(): String {
        return "OK"
    }

    @GetMapping("/listar")
    fun buscarTodos(): List<Nota>{
        return notaService.buscarTodos()
    }

    @PostMapping("/salvar")
    fun salvar(@RequestBody nota: Nota): Nota{
        return notaService.salvar(nota)
    }

    @DeleteMapping("/{id}")
    fun remover(@PathVariable("id") id: String){
        notaService.apagar(id)
    }

    @GetMapping("{id}")
    fun buscarPorId(@PathVariable("id") id: String): Nota{
        return notaService.buscarPorId(id)
    }

    @GetMapping("/titulo/{titulo}")
    fun buscarPorTitulo(@PathVariable("titulo") titulo: String): Nota{
        return notaService.buscarPorTitulo(titulo)
    }

}