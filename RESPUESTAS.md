Respuesta a pregunta 3:
Paso 1: El programa busca en el grafo el nodo persona:Albert Einstein
Paso 2: Mira su relación nace_en y extrae el destino (lugar:Ulm)
Paso 3: Busca todos los demás nodos que tengan una relación nace_en que apunte también a lugar:Ulm.
Paso 4: De esos candidatos, comprueba cuál tiene una relación profesion con el valor fisico.
El programa encuentra,en nuestro caso, a Johannes Kepler, que es el unico que cumple todas las condiciones.