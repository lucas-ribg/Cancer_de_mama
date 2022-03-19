package ribeiro.lucas.cancerdemama.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ribeiro.lucas.cancerdemama.Entity.Incidencia;
import ribeiro.lucas.cancerdemama.Repo.IncidenciaRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerIncidencia {

    private final IncidenciaRepo inRepository;

    public ControllerIncidencia(IncidenciaRepo inRepository) {
        this.inRepository = inRepository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<List<Incidencia>> findAllIncidencia(){
        try{
            List<Incidencia> lista = inRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<Incidencia> findByIdIncidencia(@PathVariable long id){
        try{
            Optional<Incidencia> incidenciaOptional = inRepository.findById(id);
            if (incidenciaOptional.isPresent()) {
                Incidencia incidenciaUnid = incidenciaOptional.get();
                return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public Incidencia newIncidencia(@RequestBody Incidencia newIncidencia) {
        return inRepository.save(newIncidencia);
    }
}
