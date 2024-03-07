package org.example.repository;
import jakarta.transaction.Transactional;
import org.example.Entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower,Long> {
        Borrower findByBorrowerId(String borrowerId);

        @Transactional
        void deleteByBorrowerId(String borrowerId);


        @Query(value = "SELECT MAX(b.id) FROM Borrower b", nativeQuery = true)
        Long findMaxID();
}
