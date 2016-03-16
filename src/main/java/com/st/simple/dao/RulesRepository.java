package com.st.simple.dao;

import com.st.simple.bean.Rules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RulesRepository extends JpaRepository<Rules, String> {
}
