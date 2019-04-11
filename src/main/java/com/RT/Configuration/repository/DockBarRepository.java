package com.RT.Configuration.repository;

import com.RT.Configuration.entity.DockBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface DockBarRepository extends JpaRepository<DockBar, Long> {

    @Query("select d from DockBar d where d.name = :name and d.roleName = :roleName")
    public DockBar findByName(@PathVariable("name") String name, @PathVariable("roleName") String roleName);

    @Query("select d from DockBar d where d.roleName = :roleName")
    public List<DockBar> findByRoleName(@PathVariable("roleName") String roleName);

}
