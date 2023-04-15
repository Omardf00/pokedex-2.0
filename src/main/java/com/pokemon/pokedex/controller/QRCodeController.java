package com.pokemon.pokedex.controller;

import com.pokemon.pokedex.service.PokemonService;
import com.pokemon.pokedex.service.QRCodeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/pokedex/qr")
@Tag(name = "QR Code Services", description = "Service that generates QR Codes to get more data of the pokemons")
public class QRCodeController {

    @Autowired
    QRCodeService qrCodeService;

    @Autowired
    PokemonService pokemonService;

    private final String URL = "https://www.wikidex.net/wiki/";

    @GetMapping
    public ResponseEntity<?> generateQRCode(HttpServletResponse response,
                                         @RequestParam String name,
                                         @RequestParam(defaultValue = "350") int width,
                                         @RequestParam(defaultValue = "350") int height) throws Exception {

        Map<String, Object> error = new HashMap<>();

        if (pokemonService.findByName(name) == null){
            error.put("message", "The pokemon called " + name + " does not appear in the data base");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        String searchUrl = URL + name;

        BufferedImage image = qrCodeService.generateQRCode(searchUrl, width, height);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();

        return new ResponseEntity<>(image, HttpStatus.OK);
    }

}
