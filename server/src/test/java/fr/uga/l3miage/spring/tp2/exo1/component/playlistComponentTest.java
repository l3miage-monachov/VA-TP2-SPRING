package fr.uga.l3miage.spring.tp2.exo1.component;

import fr.uga.l3miage.spring.tp2.exo1.components.PlaylistComponent;
import fr.uga.l3miage.spring.tp2.exo1.repositories.PlaylistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class PlayListComponentTest {
    @Autowired
    private PlaylistComponent playlistComponent;
    @MockBean
    private PlaylistRepository playlistRepository;

    @Test
    void getPlaylistNotFound(){
        //Given
        when(playlistRepository.findById(anyString())).thenReturn(Optional.empty());

        assertDoesNotThrow(()->playlistComponent.getPlaylist("test"));
    }
}
