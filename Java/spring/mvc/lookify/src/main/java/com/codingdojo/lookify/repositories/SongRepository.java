package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codingdojo.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	@Query(value="SELECT * FROM songs", nativeQuery = true)
	List<Song> find_All();
	
	@Query(value="SELECT * FROM songs WHERE artist LIKE %:name%", nativeQuery = true)
	List<Song> findBy_artist(@Param("name") String name);
	
	@Query(value="SELECT * FROM songs WHERE id = :id", nativeQuery = true)
	Song findBy_id(@Param("id") Long id);
	
	@Query(value="SELECT * FROM songs ORDER BY rating DESC", nativeQuery = true)
	List<Song> find_TopTen();
	
	@Transactional
	@Modifying(flushAutomatically = true)
	@Query(value="DELETE FROM songs WHERE id = :id", nativeQuery = true)
	void deleteBy_id(@Param("id") Long id);
}
