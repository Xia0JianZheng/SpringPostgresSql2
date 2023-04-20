package rincom.example.SpringPostgresSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(CharacterResource.CHARACTERS)
public class CharacterResource {
    public static final String CHARACTERS = "/characters";
    @Autowired
    CharacterController characterController;

    @GetMapping
    public List<CharacterDto> readAll() {
        return characterController.getAllChracters();
    }

    @GetMapping("{id}")
    public CharacterDto getCharacter(@PathVariable Integer id) {

        return characterController.getCharacterById(id);

    }

    @GetMapping("{id}/name")
    public Map<String,String> name(@PathVariable Integer id) {
       return Collections.singletonMap("name",characterController.getCharacterById(id).getName());
    }

    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody Character character) {
        CharacterDto createdCharacter = characterController.addCharacter(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCharacter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CharacterDto> deleteCharactter(@PathVariable Integer id) {
        try{
            characterController.deleteCharacterById(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }



}
