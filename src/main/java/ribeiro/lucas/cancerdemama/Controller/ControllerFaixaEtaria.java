package ribeiro.lucas.cancerdemama.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ribeiro.lucas.cancerdemama.Entity.FaixaEtaria;
import ribeiro.lucas.cancerdemama.Repo.FaixaEtariaRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerFaixaEtaria {

    private final FaixaEtariaRepo fRepository;

    public ControllerFaixaEtaria(FaixaEtariaRepo frepository) {
        this.fRepository = frepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{
            List<FaixaEtaria> lista = fRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> findByIdFaixaEtaria(@PathVariable long id){
        try{
            Optional<FaixaEtaria> unidOptional = fRepository.findById(id);
            if (unidOptional.isPresent()) {
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria) {
        return fRepository.save(newFaixaEtaria);
    }

    @DeleteMapping("/faixaetaria/delete/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id) {
        fRepository.deleteById(id);
    }
}
