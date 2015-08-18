package pl.spring.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.to.LibraryTo;

public class LibraryMapper {

	public static LibraryTo map(LibraryEntity libraryEntity) { 
		if (libraryEntity != null) {
			return new LibraryTo(libraryEntity.getId(), libraryEntity.getName());
		}
		return null;
	}

	public static LibraryEntity map(LibraryTo libraryTo) {
		if (libraryTo != null) {
			return new LibraryEntity(libraryTo.getId(), libraryTo.getName());
		}
		return null;
	}

	public static List<LibraryTo> map2To(List<LibraryEntity> libraryEntities) {
        return libraryEntities.stream().map(LibraryMapper::map).collect(Collectors.toList());
	}

	public static List<LibraryEntity> map2Entity(List<LibraryTo> libraryEntities) {
        return libraryEntities.stream().map(LibraryMapper::map).collect(Collectors.toList());
	}
}