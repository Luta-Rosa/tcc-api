package com.example.tccapi.resource;

import com.example.tccapi.model.Mensagemchat;
import com.example.tccapi.repository.MensagemChatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mensagem")
public class MensagemChatResource {

    @Autowired
    private MensagemChatRepository mensagemChatRepository;

    public Mensagemchat buscarMensagensExistentes(Integer idMsg){
        Optional<Mensagemchat> mensagemChatOptional = mensagemChatRepository.findById(idMsg);
        if(!mensagemChatOptional.isPresent()) {
            throw new IllegalArgumentException();
        }
        return mensagemChatOptional.get();
    }

    @GetMapping()
    public List<Mensagemchat> listarTodos() {
        return mensagemChatRepository.findAll();
    }

    //Função para criação de dados no banco
    @PostMapping("/criar")
    public ResponseEntity<Mensagemchat> criar(@RequestBody Mensagemchat mensagemChat, HttpServletResponse httpServletResponse) {
       Mensagemchat mensagemSalva = mensagemChatRepository.save(mensagemChat);
        return ResponseEntity.status(HttpStatus.CREATED). body(mensagemSalva);
    }

    //Função para editar os dados
    @PutMapping("/{idmsg}")
    public Mensagemchat atualizar(@PathVariable Integer idMsg, @RequestBody Mensagemchat mensagemChat) {
        Mensagemchat mensagemSalva = buscarMensagensExistentes(idMsg);
        BeanUtils.copyProperties(mensagemChat, mensagemSalva, "idmsg");

        return mensagemChatRepository.save(mensagemSalva);
    }

    @DeleteMapping("/{idmsg}")
    public void remover(@PathVariable Integer idmsg) {
        mensagemChatRepository.deleteById(idmsg);
    }
}
