/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author jmelo
 */
public class MaskFields {
   
    public MaskFormatter maskData(JFormattedTextField textfield) throws ParseException{
        MaskFormatter mask = new MaskFormatter("##/##/####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }
   
    public MaskFormatter maskCpf(JFormattedTextField textfield) throws ParseException{
        MaskFormatter mask = new MaskFormatter("###.###.###-##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }
    
    public MaskFormatter maskRg(JFormattedTextField textfield) throws ParseException{
        MaskFormatter mask = new MaskFormatter("##.###.###");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }
   
    public MaskFormatter maskMoeda(JFormattedTextField textfield) throws ParseException{
        MaskFormatter mask = new MaskFormatter("#.###.###,##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter maskInteiro(JFormattedTextField textfield) throws ParseException{
        MaskFormatter mask = new MaskFormatter("#####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter maskCEP(JFormattedTextField textfield) throws ParseException{
        MaskFormatter mask = new MaskFormatter("#####-###");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    
}