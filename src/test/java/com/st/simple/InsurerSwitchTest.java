package com.st.simple;

import com.st.simple.bean.Merchant;
import com.st.simple.bean.Rules;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class InsurerSwitchTest {

    private InsurerSwitch insurerSwitch;
    private KieSession ksession;

    @Before
    public void init() {
        insurerSwitch = new InsurerSwitch();
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        ksession = kc.newKieSession( "InsurerSwitchKS" );
    }

    @Test
    public void testInsurerSwitch_happyPath() throws FileNotFoundException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);

        ksession.insert(Rules.builder().id("1").insurer("CNA").merchantJurisdiction("CO").merchantName("Staples").startDate(calendar.getTime()).endDate(new Date()).build());

        calendar.add(Calendar.DATE, 1);
        ksession.insert( new Merchant( "Staples", "CO", calendar.getTime()));

        List<String> insurerColl = insurerSwitch.fireRules(ksession);

        assertThat(insurerColl, contains("CNA"));
    }

    @Test
    public void testInsurerSwitch_dateBasedSelection() throws FileNotFoundException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.MONTH, -1);

        ksession.insert(Rules.builder().id("1").insurer("CNA").merchantJurisdiction("CO").merchantName("Staples").startDate(calendar.getTime()).endDate(calendar2.getTime()).build());

        calendar.add(Calendar.MONTH, 2);
        ksession.insert(Rules.builder().id("2").insurer("STAR").merchantJurisdiction("CO").merchantName("Staples").startDate(calendar.getTime()).build());

        calendar.add(Calendar.DATE, 1);
        ksession.insert( new Merchant( "Staples", "CO", calendar.getTime()));

        List<String> insurerColl = insurerSwitch.fireRules(ksession);

        assertThat(insurerColl, contains("STAR"));
    }

    @Test
    public void testInsurerSwitch_jurisdiction() throws FileNotFoundException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.MONTH, -1);

        ksession.insert(Rules.builder().id("1").insurer("CNA").merchantJurisdiction("CO").merchantName("Staples").startDate(calendar.getTime()).endDate(calendar2.getTime()).build());
        ksession.insert(Rules.builder().id("2").insurer("STAR").merchantJurisdiction("CA").merchantName("Staples").startDate(calendar.getTime()).endDate(calendar2.getTime()).build());

        calendar.add(Calendar.DATE, 1);
        ksession.insert( new Merchant( "Staples", "CA", calendar.getTime()));

        List<String> insurerColl = insurerSwitch.fireRules(ksession);

        assertThat(insurerColl, contains("STAR"));
    }


}