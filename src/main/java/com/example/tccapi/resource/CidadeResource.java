package com.example.tccapi.resource;


import com.example.tccapi.model.Cidade;
import com.example.tccapi.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    //Essa função ira chamar por todas as cidade e ira buscar pela qual o id é igual ao da sua pesquisa
    public Cidade buscarCidadeExistentes(Integer idCidade){
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(idCidade);
        if(!cidadeOptional.isPresent()) {
            throw new IllegalArgumentException();
        }
        return cidadeOptional.get();
    }

    @GetMapping()
    public List<Cidade> listarTodos() {
        return cidadeRepository.findAll();
    }

    //Função para criação de dados no banco
    @PostMapping("/criar")
    public ResponseEntity<Cidade> criar(@RequestBody Cidade cidade, HttpServletResponse httpServletResponse) {
        Cidade cidadeSalvo = cidadeRepository.save(cidade);,
        return ResponseEntity.status(HttpStatus.CREATED). body(cidadeSalvo);
    }

    //Função para editar os dados
    @PutMapping("/{idCidade}")
    public Cidade atualizar(@PathVariable Integer idCidade, @RequestBody Cidade cidade) {
        Cidade cidadeSalva = buscarCidadeExistentes(idCidade);
        BeanUtils.copyProperties(cidade, cidadeSalva, "idCidade");

        return cidadeRepository.save(cidadeSalva);
    }

    @DeleteMapping("/{idCidade}")
    public void remover(@PathVariable Integer idCidade) {
        cidadeRepository.deleteById(idCidade);
    }
}
