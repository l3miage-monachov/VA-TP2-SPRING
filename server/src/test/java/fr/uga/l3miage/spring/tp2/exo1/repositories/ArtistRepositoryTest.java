package fr.uga.l3miage.spring.tp2.exo1.repositories;


import fr.uga.l3miage.spring.tp2.exo1.models.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static fr.uga.l3miage.exo1.enums.GenreMusical.RANDB;
import static fr.uga.l3miage.exo1.enums.GenreMusical.SLAM;

@AutoConfigureTestDatabase()
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
public class ArtistRepositoryTest {
    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void testCountByGenreMusicalEquals(){
        //given
        ArtistEntity artistEntity = ArtistEntity
                .builder()
                .name("test")
                .biography("test")
                .genreMusical(RANDB)
                .build();
        //when
        artistRepository.save(artistEntity);
        int artistEntiteResponse = artistRepository.countByGenreMusicalEquals(RANDB);
        int artistEntiteResponse2 = artistRepository.countByGenreMusicalEquals(SLAM);
        //then
        assert(artistEntiteResponse == 1);
        assert(artistEntiteResponse2 == 0);

    }


}
