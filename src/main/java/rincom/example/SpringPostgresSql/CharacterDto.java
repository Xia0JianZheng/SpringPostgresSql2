package rincom.example.SpringPostgresSql;

import lombok.Data;

@Data
public class CharacterDto {
    private Integer id;
    private String name;
    private Integer rarity;
    private String image;
    private String description;
    private String element;
    private String region;
    private String weaponType;
public CharacterDto(Integer id, String name, Integer rarity, String image, String description, String element, String region, String weaponType) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.image = image;
        this.description = description;
        this.element = element;
        this.region = region;
        this.weaponType = weaponType;
}

public CharacterDto(Character character) {
    this.id = character.getId_character();
    this.name = character.getName();
    this.rarity = character.getRarity();
    this.image = character.getImage();
    this.description = character.getDescrption();
    this.element = character.getElement();
    this.region = character.getRegion();
    this.weaponType = character.getWeaponType();
}
}
