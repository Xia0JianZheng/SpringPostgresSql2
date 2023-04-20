package rincom.example.SpringPostgresSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CharacterController {
    @Autowired
    CharacterService characterService;

    public List<CharacterDto> getAllChracters() {
        List<Character> characters = characterService.findAll();
        List<CharacterDto> characterDtos = characters.stream().map(CharacterDto::new).toList();
        //List<CharacterDto> characterDtos = characters.stream().map(character -> new CharacterDto(character)).toList();
        return characterDtos;

    }

    public CharacterDto getCharacterById(Integer id) {
        Character character = characterService.getCharacterById(id);
        return new CharacterDto(character);
    }

    public CharacterDto addCharacter(Character characterDto) {
        Character character = characterService.newCharacter(characterDto);
        return new CharacterDto(character);
    }

    public void deleteCharacterById(Integer id) {
        characterService.deleteCharacterById(id);
    }




}
