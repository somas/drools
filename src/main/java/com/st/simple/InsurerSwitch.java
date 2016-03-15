package com.st.simple;

import com.st.simple.bean.Merchant;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

public class InsurerSwitch {

    public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        execute( kc );
    }

    public static void execute( KieContainer kc ) {
        KieSession ksession = kc.newKieSession( "TemplatesKS" );

        ksession.insert( new Merchant( "Staples", "CO"));

        final List<String> list = new ArrayList<String>();
        ksession.setGlobal( "list", list );

        ksession.fireAllRules();

        System.out.println(list);

        ksession.dispose();
    }
}