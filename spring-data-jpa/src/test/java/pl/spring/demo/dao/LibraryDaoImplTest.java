package pl.spring.demo.dao;

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
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {

    @Autowired
    private LibraryDao libraryDao;

    @Test
    public void testShouldFindLibraryById2() {
        // given
        final long libraryId = 2;
        // when
        LibraryEntity libraryEntity = libraryDao.findOne(libraryId);
        // then
        assertNotNull(libraryEntity);
        assertEquals("Miejska biblioteka", libraryEntity.getName());
    }
    
    @Test
    public void testShouldFindLibraryById1() {
    	// given
    	final long libraryId = 1;
    	// when
    	LibraryEntity libraryEntity = libraryDao.findOne(libraryId);
    	// then
    	assertNotNull(libraryEntity);
    	assertEquals("Pierwsza biblioteka", libraryEntity.getName());
    }

    @Test
    public void testShouldFindLibraryByPrefix() {
        // given
        final String libraryName = "miejs";
        // when
        List<LibraryEntity> libraryEntities = libraryDao.findByName(libraryName);
        // then
        assertNotNull(libraryEntities);
        assertFalse(libraryEntities.isEmpty());
        assertEquals("Miejska biblioteka", libraryEntities.get(0).getName());
    }
    
    @Test
    public void testShouldFindLibraryByShortPrefixl() {
    	// given
    	final String libraryName = "pi";
    	// when
    	List<LibraryEntity> libraryEntities = libraryDao.findByName(libraryName);
    	// then
    	assertNotNull(libraryEntities);
    	assertFalse(libraryEntities.isEmpty());
    	assertEquals("Pierwsza biblioteka", libraryEntities.get(0).getName());
    }
}