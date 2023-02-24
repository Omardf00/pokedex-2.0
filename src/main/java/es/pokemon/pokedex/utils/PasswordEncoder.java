package es.pokemon.pokedex.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordEncoder {

    public String encoder(String passwd) {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(passwd);
    }

}
