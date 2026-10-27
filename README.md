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




# Taller 4 Colecciones, relaciones entre clases y static

1. java.util.ConcurrentModificationException:
esto ocurre porque el el ciclo for-each utiliza un iterador interno para recorrer la lista de canciones. Si intentamos modificar (eliminar o agregar) elementos de la lista directamente utilizando .remove() mientras el iterador está activo, Java detecta una alteración no segura en la estructura y detiene la ejecución inmediatamente lanzando esta excepción.

2. Puesto(int) is not public in parqueadero.modelo; cannot be accessed from outside package:
Este error aparece porque el constructor de la clase Puesto tiene un modificador de acceso por defecto (sin la palabra public), lo que restringe su visibilidad únicamente al paquete parqueadero.modelo. Esto está directamente relacionado con el concepto de composición, donde el Parqueadero es el único dueño y responsable de crear, gestionar y destruir la vida de sus propios Puestos

3. Salida predicha:

3
true
false
2
true

-El tamaño inicial es 3 porque agregamos tres elementos a la lista (dos veces la misma referencia del objeto x y un objeto nuevo creado con new).
-lista.get(0) == lista.get(1) da true porque ambas posiciones apuntan exactamente al mismo objeto en la memoria Heap.
-lista.get(0) == lista.get(2) da false porque, aunque tienen los mismos atributos, fueron instanciados en espacios de memoria diferentes mediante new.
-Al ejecutar lista.remove(x), se elimina la primera ocurrencia del objeto x, lo que reduce el tamaño de la lista a 2 y deja la segunda ocurrencia todavía dentro, haciendo que contains(x) devuelva true.

**Preguntas Teóricas**

1. ¿Por qué ArrayList<int> no compila y ArrayList<Integer> sí?
Porque las colecciones en Java (como ArrayList) están diseñadas para trabajar exclusivamente con objetos y tipos de referencia. El tipo int es un tipo de dato primitivo, mientras que Integer es su clase envolvente (wrapper class), la cual permite tratar los valores numéricos como objetos aptos para las colecciones.

2. ¿Por qué eliminar a Nevado de Favoritas no lo eliminó de Viaje? ¿Qué relación muestra eso?
Porque las listas almacenan referencias a los objetos ubicados en el Memoria Heap. Favoritas y Viaje contenían referencias a las mismas canciones, pero las listas como contenedores son totalmente independientes. Borrar un elemento de una lista solo elimina el apuntador de esa lista específica. Esto demuestra una relación de agregación / asociación, donde un objeto (Cancion) puede pertenecer y ser compartido por múltiples contenedores (Playlist) de manera independiente.

3. ¿Qué diferencia hay entre la relación Playlist-Cancion y la relación Parqueadero-Puesto?
La relación entre Playlist y Cancion es una agregación, lo que significa que las canciones pueden existir de forma independiente y compartirse entre distintas listas. En cambio, la relación entre Parqueadero y Puesto es una composición, lo que implica que los puestos pertenecen exclusivamente al parqueadero, se crean dentro de él y no tienen sentido ni ciclo de vida fuera de este contenedor.

4. ¿Por qué totalCanciones debe ser static y titulo no?
El atributo totalCanciones debe ser static porque pertenece a toda la clase en general y se encarga de llevar una cuenta global de todas las canciones creadas sin importar la instancia. Por el contrario, titulo es un atributo de instancia, lo que significa que es una característica única e independiente para cada objeto de tipo canción que se cree.

5. ¿Por qué un método static no puede usar this?
Porque la palabra clave this hace referencia a una instancia específica (un objeto en particular) que se encuentra en ejecución. Los métodos static pertenecen a la clase como un todo y pueden ser llamados incluso sin haber creado ningún objeto, por lo que no existe un objeto actual (this) al cual hacer referencia.

