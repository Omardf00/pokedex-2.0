package com.pokemon.pokedex.documentation;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
        info = @Info(
                title = "Pokedex API",
                version = "2.0",
                description = "API based on the first Pokemon generation",
                license = @License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = @Contact(url = "https://github.com/Omardf00/pokedex-2.0", name = "Omar and Gabriel", email = "omardominguezfuentes@gmail.com")
        ),
        tags = {
                @Tag(name = "WikiDex", description = "https://www.wikidex.net/wiki/Pok%C3%A9dex", externalDocs = @ExternalDocumentation(description = "WikiDex is the largest Pokémon encyclopedia in Spanish, with 27,179 articles, covering all the official information on video games, anime, manga, and Collectible Card Game.\n" +
                        "This content comes from wikidex.net, and must be given attribution to its authors, as specified in the license.\n" +
                        "Its use is prohibited to PlagioDex (the FANDOOM wiki), for repeatedly copying without giving attribution"))
        },
        security = {
                @SecurityRequirement(name = "JWT based Secirity")
        },
        servers = {
                @Server(
                        description = "Localhost server",
                        url = "http:localhost:8080//api/v2/pokedex/pokemon")
        }
)
public class DocumentationConfig {
}
