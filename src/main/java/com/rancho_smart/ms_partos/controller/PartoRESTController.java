package com.rancho_smart.ms_partos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_partos.entity.Parto;
import com.rancho_smart.ms_partos.service.PartoService;

@RestController
@RequestMapping(path = "/partos")
public class PartoRESTController {

    @Autowired
    private PartoService partoService;

    @GetMapping
    public ResponseEntity<List<Parto>> getAllPartos() {
        List<Parto> listado = this.partoService.getPartos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parto> getPartoById(@PathVariable Long id) {
        Optional<Parto> parto = this.partoService.getPartoById(id);
        return parto.map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/animal/{idAnimal}")
    public ResponseEntity<List<Parto>> getPartosByIdAnimal(@PathVariable Long idAnimal){
        List<Parto> partosAnimal = this.partoService.getPartosByIdAnimal(idAnimal);
        if(partosAnimal.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(partosAnimal, HttpStatus.OK);
        }
    }

    @GetMapping("/madre/{idMadre}")
    public ResponseEntity<List<Parto>> getPartosByIdMadre(@PathVariable Long idMadre){
        List<Parto> partosMadre = this.partoService.getPartosByIdMadre(idMadre);
        if(partosMadre.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(partosMadre, HttpStatus.OK);
        }
    }

    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<Parto>> getPartosByIdFinca(@PathVariable Long idFinca){
        List<Parto> partosFinca = this.partoService.getPartosByIdFinca(idFinca);
        if(partosFinca.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(partosFinca, HttpStatus.OK);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Parto>> getPartosByIdUsuario(@PathVariable Long idUsuario){
        List<Parto> partosUsuario = this.partoService.getPartosByIdUsuario(idUsuario);
        if(partosUsuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(partosUsuario, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Parto> saveParto(@RequestBody Parto parto) {
        Parto partoCreado = this.partoService.saveParto(parto);
        return new ResponseEntity<>(partoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parto> updateParto(@PathVariable Long id, @RequestBody Parto parto) {
        if (!this.partoService.getPartoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            parto.setIdParto(id);
            Parto partoActualizado = this.partoService.saveParto(parto);
            return new ResponseEntity<>(partoActualizado, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParto(@PathVariable Long id) {
        if (!this.partoService.getPartoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.partoService.deleteParto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
