package com.st.simple.service;

import com.st.simple.bean.Rules;
import com.st.simple.dao.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RulesService {

    @Autowired
    private RulesRepository rulesRepository;

    public List<Rules> getRules() {
        List<Rules> rules = rulesRepository.findAll();
        rules.toString();
        return rules;
    }

}