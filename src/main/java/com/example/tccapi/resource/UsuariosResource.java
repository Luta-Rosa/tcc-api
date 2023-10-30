package com.example.tccapi.resource;

import com.example.tccapi.model.Usuarios;
import com.example.tccapi.repository.UsuariosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResource {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios buscarUsuariosExistentes(Integer idUsuarios){
        Optional<Usuarios> usuariosOptional = usuariosRepository.findById(idUsuarios);
        if(!usuariosOptional.isPresent()){
            throw new IllegalArgumentException();
        }
        return usuariosOptional.get();
    }

    @GetMapping()
    public List<Usuarios> listarTodos(){
        return usuariosRepository.findAll();
    }

    //Função para criação de dados no banco
    @PostMapping("/criar")
    public ResponseEntity<Usuarios> criar(@RequestBody Usuarios usuarios, HttpServletResponse httpServletResponse) {
        Usuarios usuariosSalvo = usuariosRepository.save(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED). body(usuariosSalvo);
    }

    //Função para editar os dados
    @PutMapping("/{idUsuarios}")
    public Usuarios atualizar(@PathVariable Integer idUsuarios, @RequestBody Usuarios usuarios) {
        Usuarios usuarioSalvo = buscarUsuariosExistentes(idUsuarios);
        BeanUtils.copyProperties(usuarios, usuarioSalvo, "idUsuarios");

        return usuariosRepository.save(usuarioSalvo);
    }

    @DeleteMapping("/{idUsuarios}")
    public void remover(@PathVariable Integer idUsuarios) {
        usuariosRepository.deleteById(idUsuarios);
    }

}
