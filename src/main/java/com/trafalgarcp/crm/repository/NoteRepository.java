package com.trafalgarcp.crm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trafalgarcp.crm.domain.Note;


@Repository
public interface NoteRepository  extends CrudRepository<Note,Integer>{

}
