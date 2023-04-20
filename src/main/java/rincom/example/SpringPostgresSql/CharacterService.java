package rincom.example.SpringPostgresSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    CharacterDAO repository;
    public List<Character> findAll() {
       return repository.findAll();
    }

    public Character getCharacterById(Integer id) {
        Optional<Character> optionalCharacter;
        optionalCharacter = repository.findById(id);
        if(optionalCharacter.isPresent()) return optionalCharacter.get();
        else return null;
    }

    public Character newCharacter(Character character) {

        return repository.save(character);

    }

    public void deleteCharacterById(Integer id) {
        repository.deleteById(id);
    }


}
