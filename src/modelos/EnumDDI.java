/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Gustavo Camargo
 */
public class EnumDDI {

    public enum DDI {
        ESTADOS_UNIDOS("+1"),
        RUSSIA("+7"),
        FRANCA("+33"),
        ESPANHA("+34"),
        ITALIA("+39"),
        REINO_UNIDO("+44"),
        ALEMANHA("+49"),
        MEXICO("+52"),
        BRASIL("+55"),
        AUSTRALIA("+61"),
        JAPAO("+81"),
        COREIA_DO_SUL("+82"),
        CHINA("+86"),
        INDIA("+91");

        private final String code;

        DDI(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
