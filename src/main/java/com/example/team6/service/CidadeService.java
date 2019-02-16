package com.example.team6.service;

import com.example.team6.model.Cidade;
import com.example.team6.repository.CidadeRepository;
import com.example.team6.service.exception.CidadeNaoEncontradoException;
import com.example.team6.service.exception.CidadeesExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CidadeService
{
    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade buscar(Long id) throws CidadeNaoEncontradoException
    {
        Cidade cidade = cidadeRepository.findById(id).get();

        if (cidade == null)
        {
            throw new CidadeNaoEncontradoException("Ubs nao pode ser encontrado");
        }
        return cidade;

    }

    public java.util.List<Cidade> listar()
    {
        return cidadeRepository.findAll().stream()
            .filter(c -> c.getDscCidade().contains("Aracaju"))
            .collect(Collectors.toList());

    }


    // Salvando um Cidade
    public Cidade salvar(Cidade cidade) throws CidadeesExistenteException
    {
        if (cidade.getId() != null)
        {

            Cidade c = cidadeRepository.save(cidade);
            if (c != null)
            {
                throw new CidadeesExistenteException("O Cidade já existe");
            }
        }
        return cidadeRepository.save(cidade);

    }
}
