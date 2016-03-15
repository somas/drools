package com.st.simple;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DroolsExampleApp extends JFrame {

    public static void main(String[] args) {
        DroolsExampleApp droolsExamplesApp = new DroolsExampleApp();
        droolsExamplesApp.pack();
        droolsExamplesApp.setVisible(true);
    }

    protected final transient Logger logger = LoggerFactory.getLogger(getClass());

    private final KieContainer kieContainer;

    public DroolsExampleApp() {
        super("JBoss BRMS examples");
        setContentPane(createContentPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logger.info("DroolsExamplesApp started.");
        kieContainer = createKieContainer();
    }

    private KieContainer createKieContainer() {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        return kc;
    }

    private Container createContentPane() {
        JPanel contentPane = new JPanel(new GridLayout(0, 1));
        contentPane.add(new JLabel("Which GUI example do you want to see?"));


        contentPane.add(new JLabel("Which output example do you want to see?"));

        contentPane.add(new JButton(new AbstractAction("HelloWorldExample") {
            public void actionPerformed(ActionEvent e) {
                HelloWorldExample.execute( kieContainer );
            }
        }));
        return contentPane;
    }

}
