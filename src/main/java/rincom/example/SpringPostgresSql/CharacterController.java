package rincom.example.SpringPostgresSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
