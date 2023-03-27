package rincom.example.SpringPostgresSql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "character")
public class Character {

    @Id
    private Integer id_character;
    @Column(name = "character_name")
    private String name;
    @Column(name = "character_rarity")
    private Integer rarity;
    @Column(name = "character_image")
    private String image;
    @Column(name = "character_description")
    private String descrption;
    @Column(name = "element_name")
    private String element;
    @Column(name = "region_name")
    private String region;
    @Column(name = "weapon_type")
    private String weaponType;

    public Character() {
        super();
    }

    public Character(Integer id_character, String name, Integer rarity, String image, String descrption, String element, String region, String weaponType) {
        this.id_character = id_character;
        this.name = name;
        this.rarity = rarity;
        this.image = image;
        this.descrption = descrption;
        this.element = element;
        this.region = region;
        this.weaponType = weaponType;
    }

    public Character(CharacterDto characterDto) {
        this.id_character = characterDto.getId();
        this.name = characterDto.getName();
        this.rarity = characterDto.getRarity();
        this.image = characterDto.getImage();
        this.descrption = characterDto.getDescription();
        this.element = characterDto.getElement();
        this.region = characterDto.getRegion();
        this.weaponType = characterDto.getWeaponType();
    }
}
