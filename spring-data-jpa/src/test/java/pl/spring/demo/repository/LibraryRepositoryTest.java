package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    public void testShouldFindLibraryByFirstLetter() {
        // given
        final String library = "M";
        // when
        List<LibraryEntity> libraryEntities = libraryRepository.findByName(library);
        // then
        assertNotNull(libraryEntities);
        assertFalse(libraryEntities.isEmpty());
        assertEquals("Miejska biblioteka", libraryEntities.get(0).getName());
    }
    
    @Test
    public void testShouldFindLibraryByPrefix() {
    	// given
    	final String libraryName = "Pierwsza";
    	// when
    	List<LibraryEntity> libraryEntities = libraryRepository.findByName(libraryName);
    	// then
    	assertNotNull(libraryEntities);
    	assertFalse(libraryEntities.isEmpty());
    	assertEquals("Pierwsza biblioteka", libraryEntities.get(0).getName());
    }
}