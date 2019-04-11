package com.RT.Configuration.repository;

import com.RT.Configuration.entity.DashBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface DashBoardRepository extends JpaRepository<DashBoard,Long> {

    @Query("select d from DashBoard d where d.name = :name and d.roleName = :roleName")
    public DashBoard findByName(@PathVariable("name") String name, @PathVariable("roleName") String roleName);

    @Query("select d from DashBoard d where d.roleName = :roleName")
    public List<DashBoard> findByRoleName(@PathVariable("roleName") String roleName);
}
