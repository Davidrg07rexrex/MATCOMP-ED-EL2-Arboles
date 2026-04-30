Respuesta a pregunta 3:
Paso 1: El programa busca en el grafo el nodo persona:Albert Einstein
Paso 2: Mira su relación nace_en y extrae el destino (lugar:Ulm)
Paso 3: Busca todos los demás nodos que tengan una relación nace_en que apunte también a lugar:Ulm.
Paso 4: De esos candidatos, comprueba cuál tiene una relación profesion con el valor fisico.
El programa encuentra,en nuestro caso, a Johannes Kepler, que es el unico que cumple todas las condiciones.

Pregunta 4:
Para listar los lugares de nacimiento de los premios Nobel, el programa tendría que hacer dos recorridos. Primero buscar todos los nodos que tengan una arista premio apuntando a Nobel, y luego para cada uno de esos nodos buscar su arista nace_en y anotar el destino. Antonio no aparecería en esa lista porque aunque tiene nace_en, no tiene ninguna relación con un premio Nobel.

Pregunta 5:
Hay tres tipos principales. Los nodos de persona como persona:Albert Einstein, los nodos de lugar como lugar:Ulm, y nodos de concepto o valor como fisico o Nobel. En el código no hay ninguna distinción formal entre ellos, todos son Strings en el HashMap, el tipo se deduce únicamente por el prefijo del nombre.

Pregunta 6:
Una ontología es un esquema que define qué tipos de cosas existen en un dominio y cómo se relacionan entre sí. La relación con los grafos es que el grafo contiene los datos concretos y la ontología sería el molde que define las reglas. Para este problema se podría definir una con clases como Persona, Lugar o Premio y propiedades como nace_en o profesion. Con eso se podrían validar los datos automáticamente y detectar errores, como que alguien tenga un nace_en apuntando a otra persona en vez de a un lugar.
