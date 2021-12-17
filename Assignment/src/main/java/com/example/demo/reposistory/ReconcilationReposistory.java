package com.example.demo.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ReconcilationModel;

public interface ReconcilationReposistory extends JpaRepository<ReconcilationModel, Long>{

}
