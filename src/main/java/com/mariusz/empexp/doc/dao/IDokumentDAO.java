package com.mariusz.empexp.doc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.doc.domain.Dokument;

public interface IDokumentDAO extends JpaRepository<Dokument, Integer> {

}
