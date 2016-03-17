package com.st.simple;

import com.st.simple.bean.Merchant;
import com.st.simple.bean.Rules;
import com.st.simple.service.RulesService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.st.simple.dao")
@EntityScan("com.st.simple.bean")
@ComponentScan("com.st.simple")
public class InsurerSwitch {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableAppContext = SpringApplication.run(InsurerSwitch.class);
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        InsurerSwitch insurerSwitch = new InsurerSwitch();
        insurerSwitch.execute(kc, insurerSwitch.getRulesData(configurableAppContext));
        insurerSwitch.execute(kc);
    }

    private List<Rules> getRulesData(ConfigurableApplicationContext configurableAppContext) {
        RulesService rulesService = (RulesService) configurableAppContext.getBean("rulesService");
        List<Rules> rules = rulesService.getRules();
        System.out.println(rules);
        return rules;
    }

    public void execute( KieContainer kc, List<Rules> rules) {
        System.out.println("---------------- Running with db rules and DRL --------------");
        KieSession ksession = kc.newKieSession( "InsurerSwitchKS" );

        addFactsToSession(rules, ksession);

        fireRules(ksession);
    }

    protected List<String> fireRules(KieSession ksession) {
        final List<String> list = new ArrayList<String>();
        ksession.setGlobal( "list", list );

        ksession.fireAllRules();

        ksession.dispose();

        return list;
    }

    private void addFactsToSession(List<Rules> rules, KieSession ksession) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);

        ksession.insert( new Merchant( "Staples", "CO", calendar.getTime()));
        ksession.insert( new Merchant( "Staples", "CA", calendar.getTime()));
        ksession.insert( new Merchant( "Staples", "WA", calendar.getTime()));
        ksession.insert( new Merchant( "Staples", "OR", calendar.getTime()));

        calendar.add(Calendar.MONTH, 2);
        ksession.insert( new Merchant( "Staples", "CO", calendar.getTime()));

        for(Rules eachRule : rules) {
            ksession.insert(eachRule);
        }
    }

    public void execute( KieContainer kc) {
        System.out.println("---------------- Running with decision table / rules template --------------");
        KieSession ksession = kc.newKieSession( "TemplatesKS" );

        ksession.insert( new Merchant( "Staples", "CO"));

        final List<String> list = new ArrayList<String>();
        ksession.setGlobal( "list", list );

        ksession.fireAllRules();

        System.out.println(list);

        ksession.dispose();
    }
}