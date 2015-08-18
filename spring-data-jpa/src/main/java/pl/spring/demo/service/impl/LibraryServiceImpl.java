package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.dao.LibraryDao;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.mapper.LibraryMapper;
import pl.spring.demo.repository.LibraryRepository;
import pl.spring.demo.service.LibraryService;
import pl.spring.demo.to.LibraryTo;

@Service
@Transactional(readOnly = true)
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    @Transactional(readOnly = false)
    public LibraryTo save(LibraryTo book) {
        LibraryEntity entity = LibraryMapper.map(book);
        entity = libraryRepository.save(entity);
        return LibraryMapper.map(entity);
    }
    
	@Override
	@Transactional(readOnly = false)
	public LibraryTo add(LibraryTo book) {
		LibraryEntity entity = LibraryMapper.map(book);
		entity = libraryRepository.save(entity);
		return LibraryMapper.map(entity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public LibraryTo get(Long bookId) {
		return LibraryMapper.map(libraryRepository.getOne(bookId));
	}

	@Override
    public List<LibraryTo> findByName(String name) {
        return LibraryMapper.map2To(libraryRepository.findByName(name));
    }
	
	@Override
	@Transactional(readOnly = false)
	public LibraryTo findById(Long bookId) {
		return LibraryMapper.map(libraryRepository.findOne(bookId));
	}
	
	@Override
	@Transactional(readOnly = false )
	public void deleteLibraryById(long id) {
		libraryRepository.delete(id);
	}
}