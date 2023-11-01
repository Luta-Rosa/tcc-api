package com.example.tccapi.resource;

import com.example.tccapi.model.Mapa;
import com.example.tccapi.repository.MapaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mapa")
public class MapaResource {

    @Autowired
    private MapaRepository mapaRepository;

    //lembrando que o mapa é o local
    public Mapa buscarMapaExistentes(Integer idMapa){
        Optional<Mapa> mapaOptional = mapaRepository.findById(idMapa);
        if(!mapaOptional.isPresent()){
            throw new IllegalArgumentException();
        }
        return mapaOptional.get();
    }

    @GetMapping()
    public List<Mapa> listarTodos(){
        return mapaRepository.findAll();
    }

    @PostMapping("/criar")
    public ResponseEntity<Mapa> criar(@RequestBody Mapa mapa, HttpServletResponse httpServletResponse) {
        Mapa mapaSalvo = mapaRepository.save(mapa);
        return ResponseEntity.status(HttpStatus.CREATED). body(mapaSalvo);
    }

    @PutMapping("/{idMapa}")
    public Mapa atualizar(@PathVariable Integer idMapa, @RequestBody Mapa mapa) {
        Mapa mapaSalvo = buscarMapaExistentes(idMapa);
        BeanUtils.copyProperties(mapa, mapaSalvo, "idMapa");

        return mapaRepository.save(mapaSalvo);
    }

    @DeleteMapping("/{idMapa}")
    public void remover(@PathVariable Integer idMapa) {
        mapaRepository.deleteById(idMapa);
    }
}
