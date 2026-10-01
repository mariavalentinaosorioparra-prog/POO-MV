# SUSTENTACION talle-constru
9. Parte C: retos y análisis
1. Analiza estas cuatro declaraciones de constructores para la clase Habitacion e indica cuáles pueden existir al
mismo tiempo en la clase y cuáles no. Justifica cada caso con el concepto de firma.
Habitacion(int n, String t)
Habitacion(int numero, String tipo)
Habitacion(String tipo, int numero)
Habitacion(int numero)

R/ Habitacion(int n, String t) y Habitacion(int numero, String tipo) No pueden existir al mismo tiempo.
Aunque los nombres de los parámetros son diferentes (n, t frente a numero, tipo), la firma solamente tiene en cuenta:
- nombre del constructor
- cantidad de parámetros
- tipo de cada parámetro
- orden de los tipos
En ambos casos la firma es Habitacion(int, String) por lo tanto, Java los considera el mismo constructor.

- Habitacion(int numero, String tipo) y Habitacion(String tipo, int numero)
R/ Sí pueden existir al mismo tiempo, sus firmas son diferentes porque cambia el orden de los tipos:
Habitacion(int, String) y Habitacion(String, int) Por lo tanto, Java puede distinguirlos.

- Habitacion(int numero)Puede existir junto con cualquiera de los anteriores.
Su firma es:Habitacion(int)Tiene una cantidad y combinación de parámetros diferente, por lo que no entra en conflicto con los constructores de dos parámetros.



10. Preguntas de comprensión
1. ¿Qué diferencias hay entre un constructor y un método? Menciona al menos tres.
Un constructor se utiliza para crear e inicializar un objeto, tiene el mismo nombre de la clase y no tiene tipo de retorno. Un método sirve para realizar una acción o comportamiento del objeto, puede tener cualquier nombre y sí puede tener un tipo de retorno como double, boolean o void. Además, el constructor se ejecuta al crear el objeto con new, mientras que un método se ejecuta cuando lo llamamos.

2. ¿Por qué new Paquete() dejó de compilar en la Etapa 2? ¿Qué harías si la empresa necesitara seguir creando paquetes sin datos?
Dejó de compilar porque al crear constructores personalizados, Java ya no crea automáticamente el constructor vacío Paquete(). Si la empresa necesitara crear paquetes sin datos, agregaría un constructor sin parámetros:
public Paquete() {
}

3. ¿Qué ocurriría si en el constructor de Paquete escribieras peso = peso; en lugar de this.peso = peso;? ¿El programa compilaría?
Sí, el programa compilaría, pero el atributo de la clase no recibiría correctamente el valor. peso = peso; hace referencia al parámetro en ambos lados, por lo que el valor se asigna a sí mismo.
En cambio:
this.peso = peso;
indica que el peso de la izquierda es el atributo del objeto y el de la derecha es el parámetro recibido.


4. ¿Qué es la firma de un método y por qué el tipo de retorno no sirve para distinguir dos versiones sobrecargadas?
La firma de un método está formada por su nombre y los tipos, cantidad y orden de sus parámetros. El tipo de retorno no forma parte de la firma porque Java necesita poder distinguir los métodos cuando se hace una llamada, y solo con el tipo de retorno no sería suficiente.
Por ejemplo, estas dos versiones no pueden existir juntas:
public double calcularCosto(int peso)
public int calcularCosto(int peso)
Tienen la misma firma porque ambas reciben un int.

5. ¿Qué ventaja tiene que los constructores abreviados de Paquete deleguen con this(...) en lugar de asignar los atributos ellos mismos?
La principal ventaja es que se reutiliza el constructor completo y se evita repetir código. Así, si después se cambia la forma de inicializar un atributo, solo es necesario modificar el constructor completo y los demás constructores seguirán utilizando esa misma lógica.
Por ejemplo:
public Paquete(String codigo, String destino) {
    this(codigo, destino, 1.0, false);
}
De esta manera el constructor abreviado delega la inicialización al constructor completo.
