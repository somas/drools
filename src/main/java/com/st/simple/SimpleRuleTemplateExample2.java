package com.st.simple;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * This shows off a very simple rule template where the data provider is a spreadsheet.
 */
public class SimpleRuleTemplateExample2 {

    public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        execute( kc );
    }

    public static void execute( KieContainer kc ) {
        KieSession ksession = kc.newKieSession( "TemplatesKS" );

        //now create some test data
        ksession.insert( new Person( "stilton",
                42 ) );
        ksession.insert( new Person( "michael",
                "stilton",
                42 ) );
        final List<String> list = new ArrayList<String>();
        ksession.setGlobal( "list", list );

        ksession.fireAllRules();

        System.out.println(list);

        ksession.dispose();
    }
}