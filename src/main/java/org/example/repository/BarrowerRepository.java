package org.example.repository;

import org.example.Entity.Barrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarrowerRepository extends JpaRepository<Barrower,Long> {
        Barrower findBybid(String bid);
        Barrower deleteBybid(String bid);

        @Query("SELECT MAX(b.id) FROM Barrower b")
        Long findMaxID();
}
