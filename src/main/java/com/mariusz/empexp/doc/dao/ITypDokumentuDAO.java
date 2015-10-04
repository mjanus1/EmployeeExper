package com.mariusz.empexp.doc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.doc.domain.TypDokumentu;

public interface ITypDokumentuDAO extends JpaRepository<TypDokumentu, Short> {
 
}
