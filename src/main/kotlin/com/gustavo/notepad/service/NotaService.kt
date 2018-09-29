package com.gustavo.notepad.service

import com.gustavo.notepad.model.Nota
import com.gustavo.notepad.repository.NotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotaService {

    @Autowired
    lateinit var notaRepository: NotaRepository

    fun salvar(nota: Nota): Nota{

        return notaRepository.save(nota)

    }

    fun buscarTodos(): List<Nota>{
        return notaRepository.findAll()
    }

    fun apagar(id: String){
        notaRepository.deleteById(id)
    }

    fun buscarPorId(id: String): Nota{
        return notaRepository.findById(id).get()
    }

    fun buscarPorTitulo(titulo: String): Nota{
        return notaRepository.findByTitulo(titulo)
    }

}