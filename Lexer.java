class Lexer {
    static final int ERROR = -1;
    static final int ACEPTAR = 0;   
    public class Lexer {
        static final int ERROR = -1;
        static final int ACEPTAR = 0;
        private String input;
        private int currentIndex = 0;
    
        public Lexer(String input) {
            this.input = input;
        }
    
        private char obtenerCaracter() {
            if (currentIndex < input.length()) {
                return input.charAt(currentIndex++);
            } else {
                return '\0';
            }
        }
    
        private int estado_0() {
            char c = obtenerCaracter();
            switch (c) {
                case 'a':
                    return estado_1();
                case 'b':
                    return estado_4();
                default:
                    return ERROR;
            }
        }
    
        private int estado_1() {
            char c = obtenerCaracter();
            switch (c) {
                case 'a':
                    return estado_1();
                case 'b':
                    return estado_2();
                default:
                    return ERROR;
            }
        }
    
        private int estado_2() {
            char c = obtenerCaracter();
            switch (c) {
                case 'a':
                    return estado_1();
                case 'b':
                    return estado_3();
                default:
                    return ERROR;
            }
        }
    
        private int estado_3() {
            return ACEPTAR;
        }
    
        private int estado_4() {
            char c = obtenerCaracter();
            switch (c) {
                case 'a':
                    return estado_1();
                case 'b':
                    return estado_4();
                default:
                    return ERROR;
            }
        }
    
        public boolean analizar() {
            int estado = estado_0();
            while (estado != ERROR && estado != ACEPTAR) {
                estado = transicion(estado, obtenerCaracter());
            }
            return estado == ACEPTAR;
        }
    
        private int transicion(int estadoActual, char caracter) {
            switch (estadoActual) {
                case 0:
                    return estado_0();
                case 1:
                    return estado_1();
                case 2:
                    return estado_2();
                case 3:
                    return estado_3();
                case 4:
                    return estado_4();
                default:
                    return ERROR;
            }
        }
    
        public static void main(String[] args) {
            String input = "ba bb";
            Lexer lexer = new Lexer(input);
            boolean aceptada = lexer.analizar();
            if (aceptada) {
                System.out.println("Cadena aceptada");
            } else {
                System.out.println("Cadena no aceptada");
            }
        }
    }
    d